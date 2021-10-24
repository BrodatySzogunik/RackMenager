package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Similarities {

    private Map<Integer,Map<Integer,Integer>> similarities = new HashMap<Integer,Map<Integer,Integer>>();
    private ArrayList<String> fileList = null;


    public Similarities(String filePath){
        fileList = fileReader.fileReader(filePath);
        getSimilarities();
    }

    private void getSimilarities(){

        fileList.stream().forEach((item)-> {

            String[] list = item.split(";");
            Map<Integer,Integer> tempMap = new HashMap<Integer,Integer>();
            for(int i = 1; i<list.length; i++){
                tempMap.put(i,Integer.parseInt(list[i].split(",")[1]));
            }
            similarities.put(Integer.parseInt(list[0]),tempMap);

        });
    }

    public int getSimilarityToOtherProduct(int productId, int similarProductId){
        if (productId != 0 && similarProductId != 0) {
            return similarities.get(productId).get(similarProductId);
        }else{
        return 0;
        }
    }

    public Map<Integer,Integer> getSimilaritiesOf(Integer idx){
        return similarities.get(idx);

    }

}
