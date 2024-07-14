/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomonitoringsystem;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Josh R
 */
public class Animals {
    //class variables
    private final FileInputStream fileByteStream;
    private final Scanner inFS;
    private Scanner inSS;
    private String line;
    private String word;
    private String animal;



    //Constructor
    public Animals() throws IOException {
        this.fileByteStream = new FileInputStream("src\\zoomonitoringsystem\\animals.txt");
        this.inFS = new Scanner(fileByteStream);
        this.inSS = null;
        this.line = "";
        this.word = "";
        this.animal = "";
   
    }
    
    //Method to print available animals menu
    public void printAnimalMenu() {
        System.out.println("           Animals Menu");
        System.out.println("---------------------------------------");
        System.out.println("Available animal details:");
        line = inFS.nextLine();
        while (line.startsWith("Details")) {
            inSS = new Scanner(line);
            while (inSS.hasNext()) {
                word = inSS.next();
                if (!word.equals("Details") && !word.equals("on")) {
                    animal = word.substring(0, word.length() - 1);
                }
            }
            System.out.println(line);
            System.out.println("   Enter \"" + animal + "\" to view details.");
            line = inFS.nextLine();
        }
        System.out.println("Enter \"back\" to return to the main menu.");
        System.out.println();
    }
    
    //Method to print details of selected animal.
    public void printAnimalDetails(String menuOption) {
        menuOption = menuOption.toLowerCase();
        this.animal = menuOption.substring(0,1).toUpperCase() + menuOption.substring(1);
        System.out.println(animal + " Details:");
        System.out.println();
        while (inFS.hasNextLine()) {
            line = inFS.nextLine();
            if (!inFS.hasNextLine()){
                System.out.println("Error: " +animal + " not found in system.");
                break;
            }
            if (line.endsWith(animal)){
                System.out.println(line);
                String subLine = inFS.nextLine();
                while (!subLine.isEmpty()){
                    if (subLine.startsWith("*")){
                        subLine = subLine.replace('*', ' ').trim();
                        String category = subLine.substring(0, subLine.indexOf(":"));
                        String message = subLine.substring(subLine.indexOf(":") + 2);
                        JOptionPane.showMessageDialog(null, message, "Warning! " + category, 1);
                    }
                    System.out.println(subLine);
                    if (!inFS.hasNextLine()){
                        break;
                    }
                    else {
                        subLine = inFS.nextLine();
                    }
                }
                break;
            }
        }
    }
}
