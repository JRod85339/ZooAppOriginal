/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoomonitoringsystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Josh R
 */
public class Habitats {
    //class variables
    private final FileInputStream fileByteStream;
    private final Scanner inFS;
    private Scanner inSS;
    private String line;
    private String word;
    private String habitat;

    //Constructor
    public Habitats() throws IOException {
        this.fileByteStream = new FileInputStream("src\\zoomonitoringsystem\\habitats.txt");
        this.inFS = new Scanner(fileByteStream);
        this.inSS = null;
        this.line = "";
        this.word = "";
        this.habitat = "";
   
    }
    
    //Method to print available habitats menu
    public void printHabitatMenu() {
        System.out.println("           Habitats Menu");
        System.out.println("---------------------------------------");
        System.out.println("Available habitat detals:");
        line = inFS.nextLine();
        while (line.startsWith("Details")) {
            inSS = new Scanner(line);
            while (inSS.hasNext()) {
                word = inSS.next();
                if (!word.equals("Details") && !word.equals("on")) {
                    habitat = word;
                    break;
                }
            }
            System.out.println(line);
            System.out.println("   Enter \"" + habitat + "\" to view details.");
            line = inFS.nextLine();
        }
        System.out.println("Enter \"back\" to return to Main Menu.");
        System.out.println();
    }
    
    //Method to print details of selected habitat.
    public void printHabitatDetails(String menuOption) {
        menuOption = menuOption.toLowerCase();
        this.habitat = menuOption.substring(0,1).toUpperCase() + menuOption.substring(1);
        System.out.println(habitat + " Habitat Details:");
        System.out.println();
        while (inFS.hasNextLine()) {
            line = inFS.nextLine();
            if (!inFS.hasNextLine()){
                System.out.println("Error: " + habitat + " not found in system.");
                break;
            }
            if (line.endsWith(habitat)){
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
