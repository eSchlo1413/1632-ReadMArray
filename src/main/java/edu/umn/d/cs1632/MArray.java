package edu.umn.d.cs1632;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MArray {
    // ArrayList<Feature> featureList;
    // ArrayList<ArrayList<DataItem>> data;
    private List<List<Value>> finalMatrix = new ArrayList<>();
    public MArray(String fileName){
        //Creates final 2D array to store in values and counts rows of this array

        int rows = 0;
        try {
            //Reads in csv file
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();

            //Goes through rows of data
            for (String[] row : allData) {
                List<Value> currentRow = new ArrayList<>();
                for (String cell : row) {
                    //Checks if Value is a number by valueOf, if so we make a new int value and add it to matrix
                    try {
                        int testInt = Integer.valueOf(cell);
                            //Value is an int
                            Value iCell = new IntValue(cell);
                            currentRow.add(iCell);
                        }
                    catch(Exception e)
                    {
                        //Not an int, proceed
                        try {
                            //Tests to see if value is a double same way for an int
                            double testDouble = Double.valueOf(cell);
                            //Value is a double
                            Value dCell = new DoubleValue(cell);
                            currentRow.add(dCell);
                        }
                        //If the value is neither, assume it is a string
                        catch (Exception j) {
                            //Value is a string
                            Value sCell = new StringValue(cell + "(S)");
                            currentRow.add(sCell);
                        }
                    }
                    //Move to the next row
                    rows++;
                }
                finalMatrix.add(currentRow);
            }
            //Final print out, displays each value row by row
            System.out.println("Data: ");
            for(List<Value> r : finalMatrix)
            {
                for(Value v : r)
                {
                    System.out.print(v + " ");

                }
                System.out.println("");
            }
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public List<List<Value>> getFinalMatrix()
    {
        return finalMatrix;
    }

}
