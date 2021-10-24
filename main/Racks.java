package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Racks {
    private Map<Integer,Rack> racks = new HashMap<Integer,Rack>();
    private ArrayList<String> fileLines= null;
    private int emptyRacksCount=0;
    private int placeLeft;
    private int racksCap;




    public Racks(String filePath){
        fileLines = fileReader.fileReader(filePath);
        getRacks();
    }

    public void putProduct(int rackId, int shelfId, int position, int productId){
        this.racks.get(rackId).putProductonShelf(shelfId,position,productId);
    }

    private void getRacks(){

        fileLines.stream().forEach((item)->{

            String[] itemSplited = item.split(";");

            Rack tempRack = new Rack(Integer.parseInt(itemSplited[1]),Integer.parseInt(itemSplited[2]));

            racks.put(Integer.parseInt(itemSplited[0]),tempRack);


        });
    }

    public int getEmptyRacksCount() {
        calculateEmptyRacks();
        return emptyRacksCount;
    }


    private void calculateEmptyRacks(){
        for(int i=1 ; i<=racks.keySet().toArray().length; i++){
            if(racks.get(i).isEmpty()){
                emptyRacksCount++;
            }
        }
    }

    public int findRackWithHighestCap(){
        int highestCap=0;
        int highestCapId=0;
        for(int i=1 ; i<=racks.keySet().toArray().length; i++){
            if(racks.get(i).getRackMaxCap()-racks.get(i).getRackCap()>highestCap){
                highestCap=racks.get(i).getRackCap();
                highestCapId=i;
            }
        }
        return highestCapId;

    }
    public int findRackWithEnoughCap(int cap){
        for(int i=1 ; i<racks.keySet().toArray().length; i++){
            if(racks.get(i).getRackMaxCap()-racks.get(i).getRackCap()>cap){

                return i;
            }
        }
        return 0;

    }


    public int getPlaceLeft() {
        calculatePlaceLeft();
        return placeLeft;
    }

    private void calculatePlaceLeft(){
        placeLeft=0;
        for(int i = 1 ; i<=racks.keySet().size();i++ ){
            placeLeft+=(racks.get(i).getRackMaxCap()-racks.get(i).getRackCap());
        }
    }

    public int getRacksCap(){
        calculateRacksCap();
        return racksCap;
    }

    private void calculateRacksCap(){
        racksCap=0;
        for(int i = 1 ; i<=racks.keySet().size();i++ ){
            racksCap+=(racks.get(i).getRackCap());
        }
    }

    public Map<Integer,Rack> getAllRacks(){
        return racks;
    }

}
