package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PrimitiveIterator;

public class Shelf {

    private Integer shelfId ;
    private Integer shelfMaxCap;
    private Integer shelfCap=0;
    Integer[] products;

    public Shelf(Integer shelfId , Integer shelfMaxCap){
        this.shelfId=shelfId;
        this.shelfMaxCap=shelfMaxCap;
        this.products = new Integer[shelfMaxCap];
        for(int i=0 ; i<this.products.length; i++){
            this.products[i]=0;
        }
    }

    public Integer[] getProducts() {
        return products;
    }

    public void addProduct(int productId, int position){
        if(products[position]==0){
            products[position] = productId;
            shelfCap++;
        }else{
            throw new Error("To miejsce jest już zajęte");
        }

    }

    public Integer getShelfId() {
        return shelfId;
    }

    public Integer getShelfMaxCap() {
        return shelfMaxCap;
    }

    public Integer getShelfCap() {
        return shelfCap;
    }

    @Override
    public String toString(){
        String output="";
        for(int i = 0 ; i<products.length ; i++){
            output += " "+products[i]+" ";
        }
        output+="\n";
        return output;
    }


}
