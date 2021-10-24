package main;

public class Rack {

    private int shelfCount;
    private Shelf[] shelfs;
    private int shelfMaxCap;
    private int rackCap=0;
    private int rackMaxCap;
    private boolean isEmpty=true;

    public Rack( int shelfMaxCap, int shelfCount){
        this.shelfMaxCap=shelfMaxCap;
        this.shelfCount=shelfCount;
        this.shelfs = new Shelf[shelfCount];
        this.rackMaxCap = this.shelfCount*shelfMaxCap;
        for(int i = 0 ; i<this.shelfs.length; i++){
            this.shelfs[i] = new Shelf(i,shelfMaxCap);
        }
    }

    public void putProductonShelf(int shelfId, int position, int productId){
        this.shelfs[shelfId].addProduct(productId,position);
    }


    public int getShelfCount() {
        return shelfCount;
    }

    public Shelf[] getShelfs() {
        return shelfs;
    }

    public int getRackMaxCap() {
        return rackMaxCap;
    }

    public int getRackCap() {
        calculateRackCap();
        return rackCap;
    }

    private void calculateRackCap(){
        rackCap=0;
        for(int i=0 ; i<this.shelfs.length; i++){
            this.rackCap+=this.shelfs[i].getShelfCap();
        }
        if (rackCap != 0) {
            this.isEmpty=false;
        }else{
            this.isEmpty=true;
        }
    }

    public boolean isEmpty() {
        calculateRackCap();
        return isEmpty;
    }

    public int getShelfMaxCap() {
        return shelfMaxCap;
    }

    @Override
    public String toString() {
        String output = "\n";
        for(int i=0 ; i<shelfCount; i++){
            output+=this.shelfs[i];
            calculateRackCap();
        }
        output+="rackCap:"+this.rackCap+"\n \n";
        return output;
    }
}
