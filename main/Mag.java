package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mag {

    private Map<Integer,Integer> mag = new HashMap<Integer, Integer>();

    private ArrayList<String> fileLines = null;


    public Mag(String filePath){
        fileLines = fileReader.fileReader(filePath);
        getMag();
    }

    private void getMag(){
        fileLines.stream().forEach((item) -> {
            String[] itemSplitted = item.split(";");
            mag.put(Integer.parseInt(itemSplitted[0]),Integer.parseInt(itemSplitted[1]));

        });
    }

    public  Map<Integer,Integer> getMagazine (){
        return mag;
    }

    public int getAmountOfProduct(int productId){
        if(mag.get(productId)==null){

            return 0;
        }else if(mag.get(productId)>0){

            return mag.get(productId);
        }else{
            return 0;
        }
    }

    public void decreaseAmountOfProduct(int productId){
        if(this.mag.get(productId)>0){
            this.mag.put(productId,this.mag.get(productId)-1);
        }
    }
    public void increaseAmountOfProduct(int productId){
        this.mag.put(productId,this.mag.get(productId)+1);
    }

    public int findItemNearestAvailableCap(int availableCap){
        int itemNearestAvailableCap=0;
        int difference=100;

        for(int i = 1 ; i<=mag.keySet().size();i++)
        {
            if(mag.get(i)<=availableCap) {
                if(availableCap-mag.get(i)<difference) {
                    difference = availableCap - mag.get(i);
                    itemNearestAvailableCap=i;
                }
            }
        }
        return itemNearestAvailableCap;
    }

    public int findLeastPopularProductId(){
        int leastPopularProductId=0;
        int maxAmount=0;
        for(int i = 1 ; i<=mag.keySet().size();i++)
        {

            if(mag.get(i)>maxAmount){
                maxAmount=mag.get(i);
                leastPopularProductId=i;
            }
        }
        return leastPopularProductId;
    }
}
