package edu.umn.d.cs1632;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Prompts user to enter file to read
        System.out.print("Enter a file name: ");
        Scanner file = new Scanner(System.in);
        MArray mArray = new MArray(file.next());
        //src/data/simple.csv

        // Put your code for queries here
        boolean continueLoop = true;
        while(continueLoop == true)
        {
            Scanner Qre = new Scanner(System.in);
            if(Qre.next().equals("Q"))
            {
                continueLoop = false;
            }
            else if(Qre.next().equals("V"))
            {

            }
            else if(Qre.next().equals("H"))
            {

            }
            else if(Qre.next().equals("M"))
            {

            }
            else
            {
                System.out.println("Invalid command, enter V, H, M, or Q to start a command");
            }
        }
    }
}