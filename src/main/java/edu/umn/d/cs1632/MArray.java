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
    private MArray() {}
    public MArray(String fileName) {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();

            List<List<Value>> finalMatrix = new ArrayList<>();
            int rows = 0;

            for (String[] row : allData) {
                List<Value> currentRow = new ArrayList<>();
                for (String cell : row) {
                    //System.out.print(cell + "\t");
                    //Checks if string is number by valueOf, then checks for double
                    try {
                        int testInt = Integer.valueOf(cell);
                            //Value is an int
                            Value iCell = new IntValue(cell);
                            currentRow.add(iCell);
                        }
                    catch(Exception e)
                    {
                        //Not an int
                        //Proceed
                        try {
                            double testDouble = Double.valueOf(cell);
                            //Value is a double
                            Value dCell = new DoubleValue(cell);
                            currentRow.add(dCell);
                        }
                        catch (Exception j) {
                            //Value is a string
                            Value sCell = new StringValue(cell + "(S)");
                            currentRow.add(sCell);

                        }



                    }
                    rows++;
                }

                finalMatrix.add(currentRow);


            }
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
}
