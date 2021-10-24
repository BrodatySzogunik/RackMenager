package main;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){



        Scanner scanner = new Scanner(System.in);
        int userChoice;
        String userInput;
        Packer.changeSimilaritiesPath("src/similarities");
        Packer.changeMagPath("src/mag");
        Packer.changeRacksPath("src/Racks");
        do{
            //Pliki można podmienić na pliki o takiej samej strukturze
            System.out.println("----Menu----\n" +
                    "1-Get rid of least popular items\n" +
                    "2-Lowest load highest prize\n" +
                    "3-exit\n" +
                    "4-Change similarities path\n" +
                    "5-Change racks path\n" +
                    "6-Change Mag path\n");

            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1 -> {
                    Packer.getRidOfLeastPopularProducts();
                    System.out.println("Prize: "+Packer.calculatePrize());
                    System.out.println("Racks Cap: "+Packer.calculateRacksCap());
                }
                case 2->{
                    Packer.LowestRackLoadHighestPrize();
                    System.out.println("Prize: "+Packer.calculatePrize());
                    System.out.println("Racks Cap: "+Packer.calculateRacksCap());
                }
                case 4->{
                    userInput=scanner.next();
                    Packer.changeSimilaritiesPath(userInput);
                }
                case 5->{
                    userInput=scanner.next();
                    Packer.changeRacksPath(userInput);
                }
                case 6->{
                    userInput=scanner.next();
                    Packer.changeMagPath(userInput);
                }

            }

        }while(userChoice!=3);






    }
}
