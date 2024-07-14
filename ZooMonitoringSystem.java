/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomonitoringsystem;

/**
 *
 * @author Josh R
 */
import java.util.Scanner;
import java.io.IOException; 

public class ZooMonitoringSystem {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try (Scanner scnr = new Scanner(System.in)) {
            String menuOption = "";
            
            while (!menuOption.equals("q")) {
                printMainMenu();
                menuOption = scnr.next();
                if (menuOption.equals("q")){
                    break;
                }
                switch (menuOption) {
                    case "a":
                        while (!menuOption.equals("back")) {
                            Animals animalFile = new Animals();
                            animalFile.printAnimalMenu();
                            menuOption = scnr.next();
                            if (menuOption.equals("back")) {
                                break;
                            }
                            animalFile.printAnimalDetails(menuOption);
                            System.out.println();
                            System.out.println("Returning to Animals Menu...");
                            System.out.println();
                            }
                        break;
                    case "h":
                        while (!menuOption.equals("back")) {
                            Habitats habitatFile = new Habitats();
                            habitatFile.printHabitatMenu();
                            menuOption = scnr.next();
                            if (menuOption.equals("back")) {
                                break;
                            }
                            habitatFile.printHabitatDetails(menuOption);
                            System.out.println();
                            System.out.println("Returning to Habitats Menu...");
                            System.out.println();
                            }
                        break;
                    default:
                        System.out.println("Menu option not recognized.");
                        break;
                }
                System.out.println("Returning to main menu...");
                System.out.println();
            }
        }
        System.out.println("Exiting zoo monitoring system.");
    }

    /**
     Method to print the main menu.
     */
        public static void printMainMenu(){
        System.out.println("     Main Menu");
        System.out.println("----------------------");
        System.out.println("To monitor animals: Enter \"a\".");
        System.out.println("To monitor habitats: Enter \"h\".");
        System.out.println("To exit the zoo monitoring system: Enter \"q\".");
        System.out.println();
    }
}
