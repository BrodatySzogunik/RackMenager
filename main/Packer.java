package main;


import java.sql.SQLOutput;

public class Packer {
    private static Similarities similarities ;
    private static Racks racks ;
    private static Mag mag;
    private static String similaritiesPath;
    private static String racksPath;
    private static String magPath;



    public static void LowestRackLoadHighestPrize(){
        restart();
        int itemNearestAvailableCap;
        for(int rackId = 1 ; rackId<=racks.getAllRacks().keySet().size();rackId++){
            itemNearestAvailableCap=mag.findItemNearestAvailableCap(racks.getAllRacks().get(rackId).getRackMaxCap());

            if(itemNearestAvailableCap!=0){
                for (int i = 0; i < racks.getAllRacks().get(rackId).getShelfCount(); i++) {
                    for (int j = 0; j < racks.getAllRacks().get(rackId).getShelfMaxCap(); j++) {
                            try {
                                putProduct(rackId, i, j, itemNearestAvailableCap);
                            } catch (Error e) {
//                                System.out.println(e);
                            }
                    }
                }


            }

        }
    }

    public static int calculateRacksCap(){
        int racksCap = racks.getRacksCap();
        return racksCap;
    }

    public static void changeSimilaritiesPath(String newPath){
        similaritiesPath = newPath;
    }
    public static void changeRacksPath(String newPath){
        racksPath = newPath;
    }
    public static void changeMagPath(String newPath){
        magPath = newPath;
    }


    public static void getRidOfLeastPopularProducts(){
        restart();
        int leastPopularProduct;
        int amountOfProduct;
        int rackWithEnoughCap;
        while (racks.getPlaceLeft()!=0){
            leastPopularProduct=mag.findLeastPopularProductId();
            amountOfProduct = mag.getAmountOfProduct(leastPopularProduct);
            rackWithEnoughCap = racks.findRackWithEnoughCap(amountOfProduct)!=0 ? racks.findRackWithEnoughCap(amountOfProduct): racks.findRackWithHighestCap();
            for (int i = 0; i < racks.getAllRacks().get(rackWithEnoughCap).getShelfCount(); i++){
                for (int j = 0; j < racks.getAllRacks().get(rackWithEnoughCap).getShelfMaxCap(); j++) {
                    try {
                        putProduct(rackWithEnoughCap, i, j, leastPopularProduct);
                    } catch (Error e) {

                    }
                }
            }


        }


    }

    public static int calculatePrize(){

        System.out.println(racks.getAllRacks());
        int prize =0 ;
        for(int i = 1 ; i<racks.getAllRacks().keySet().toArray().length; i++){
            for (int j = 0 ; j<racks.getAllRacks().get(i).getShelfCount(); j++){
                for(int x=0; x<racks.getAllRacks().get(i).getShelfs()[j].getProducts().length-1;x++){
                    prize+=similarities.getSimilarityToOtherProduct(
                            racks.getAllRacks().get(i).getShelfs()[j].getProducts()[x]
                            ,racks.getAllRacks().get(i).getShelfs()[j].getProducts()[x+1]
                    );

                }
            }
        }

        return prize;
    }

    public static void restart(){

        similarities = new Similarities(similaritiesPath);
        racks = new Racks(racksPath);
        mag = new Mag(magPath);

    }

    private static void putProduct(int rackId, int shelfId, int position, int productId){
        if(mag.getAmountOfProduct(productId)>0){
            racks.putProduct(rackId,shelfId,position,productId);
            mag.decreaseAmountOfProduct(productId);
        }
        else{
            throw new Error("this product is out of stock");
        }
    }
}
