package edu.umn.d.cs1632;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Prompts user to enter file to read and creates object MArray
        System.out.print("Enter a file name: ");
        Scanner file = new Scanner(System.in);
        MArray mArray = new MArray(file.next());
        //src/data/simple.csv

        // Put your code for queries here
        //Loops through scanners for user input, accept 5 outcomes
        List<List<Value>> finalMatrix = mArray.getFinalMatrix();
        boolean continueLoop = true;
        while(continueLoop == true)
        {
            System.out.println("Enter Letter");
            String command = file.next();
            if(command.equals("Q"))
            {
                continueLoop = false;
            }
            else if(command.equals("V"))
            {
                System.out.println("Enter column");
                int col = file.nextInt();
                System.out.println("Enter starting row index");
                int rowStart = file.nextInt();
                System.out.println("Enter ending row index");
                int rowEnd = file.nextInt();
                boolean currentlyInt = false;
                boolean currentlyDouble = false;
                boolean currentlyString = false;

                for(int row = rowStart; row <= rowEnd; row++)
                {
                    Value value = finalMatrix.get(row).get(col);
                    if (value instanceof IntValue)
                    {
                        currentlyInt = true;
                        if(currentlyDouble == true || currentlyString == true)
                        {
                            row = (rowEnd + 1);
                            System.out.println("Multiple");
                        }
                        if(row == rowEnd)
                        {
                            System.out.println("Int");
                        }
                    }
                    else if (value instanceof DoubleValue)
                    {
                        currentlyDouble = true;
                        if(currentlyInt == true || currentlyString == true)
                        {
                            row = (rowEnd + 1);
                            System.out.println("Multiple");
                        }
                        if(row == rowEnd)
                        {
                            System.out.println("Double");
                        }
                    }
                    else
                    {
                        currentlyString = true;
                        if(currentlyInt == true || currentlyDouble == true)
                        {
                            row = (rowEnd + 1);
                            System.out.println("Multiple");


                        }
                        if(row == rowEnd)
                        {
                            System.out.println("String");
                        }
                    }

                }

                currentlyString = false;
                currentlyInt = false;
                currentlyDouble = false;
            }
            else if(command.equals("H"))
            {
                System.out.println("Enter row");
                int row = file.nextInt();
                System.out.println("Enter starting column index");
                int colStart = file.nextInt();
                System.out.println("Enter ending column index");
                int colEnd = file.nextInt();
                boolean currentlyInt = false;
                boolean currentlyDouble = false;
                boolean currentlyString = false;

                for(int col = colStart; col <= colEnd; col++)
                {
                    Value value = finalMatrix.get(row).get(col);
                    if (value instanceof IntValue)
                    {
                        currentlyInt = true;
                        if(currentlyDouble == true || currentlyString == true)
                        {
                            col = (colEnd + 1);
                            System.out.println("Multiple");
                        }
                        if(col == colEnd)
                        {
                            System.out.println("Int");
                        }
                    }
                    else if (value instanceof DoubleValue)
                    {
                        currentlyDouble = true;
                        if(currentlyInt == true || currentlyString == true)
                        {
                            col = (colEnd + 1);
                            System.out.println("Multiple");
                        }
                        if(col == colEnd)
                        {
                            System.out.println("Double");
                        }
                    }
                    else
                    {
                        currentlyString = true;
                        if(currentlyInt == true || currentlyDouble == true)
                        {
                            col = (colEnd + 1);
                            System.out.println("Multiple");


                        }
                        if(col == colEnd)
                        {
                            System.out.println("String");
                        }
                    }

                }

                currentlyString = false;
                currentlyInt = false;
                currentlyDouble = false;
            }
            else if(command.equals("M"))
            {
                System.out.println("Enter starting row index");
                int rowStart = file.nextInt();
                System.out.println("Enter ending row index");
                int rowEnd = file.nextInt();
                System.out.println("Enter starting column index");
                int colStart = file.nextInt();
                System.out.println("Enter ending column index");
                int colEnd = file.nextInt();
                boolean currentlyInt = false;
                boolean currentlyDouble = false;
                boolean currentlyString = false;

                for(int col = colStart; col <= colEnd; col++)
                {
                    for(int row = rowStart; row <= rowEnd; row++)
                    {
                        Value value = finalMatrix.get(row).get(col);
                        if (value instanceof IntValue) {
                            currentlyInt = true;
                            if (currentlyDouble == true || currentlyString == true) {
                                row = (rowEnd + 1);
                                col = (colEnd + 1);
                                System.out.println("Multiple");
                            }
                            if (col == colEnd && row == rowEnd) {
                                System.out.println("Int");
                            }
                        } else if (value instanceof DoubleValue) {
                            currentlyDouble = true;
                            if (currentlyInt == true || currentlyString == true) {
                                row = (rowEnd + 1);
                                col = (colEnd + 1);
                                System.out.println("Multiple");
                            }
                            if (col == colEnd && row == rowEnd) {
                                System.out.println("Double");
                            }
                        } else {
                            currentlyString = true;
                            if (currentlyInt == true || currentlyDouble == true) {
                                row = (rowEnd + 1);
                                col = (colEnd + 1);
                                System.out.println("Multiple");
                            }
                            if (col == colEnd && row == rowEnd) {
                                System.out.println("String");
                            }
                        }

                    }
                }

                currentlyString = false;
                currentlyInt = false;
                currentlyDouble = false;
            }
            else
            {
                System.out.println("Invalid command, enter V, H, M, or Q to start a command");
            }
        }
    }
}