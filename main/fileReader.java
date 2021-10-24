package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileReader {

    public static ArrayList<String> fileReader (String fileSource){

        ArrayList<String> fileLines = new ArrayList<String>();
        File file = new File(fileSource);
        Scanner scanner = null;



        try {
            scanner = new Scanner(file);

            while(scanner.hasNext()){
                fileLines.add(scanner.nextLine());
            }

        }catch(FileNotFoundException e) {
            System.out.println(e);
        }
        return fileLines;

    }
}
