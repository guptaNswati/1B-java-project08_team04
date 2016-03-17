package project08_team04;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/***
 * CSVReader Class with three private fields.
 * CSVReader(fileName) reads the cellular.csv file and sets its members data
 * @param CSVReader
 *
 */
public class CSVReader
{
    private String[] countryNames; 
    private int[] yearLabels; 
    private double[][] cellularDataTable;

    public CSVReader(String fileName)
    {
        Scanner input;

        /**
         * reads given file line by line and splits every line into tokens 
         * and stores these tokens into countryName, yearLable and cellularDataTable arrays
         * @param fileName 
         */
        try 
        {
            input = new Scanner (new File(fileName));

            String Title = input.nextLine(); // first line of file, stored but not used 

            /**
             * reads and splits second line to get total number of countries 
             * to initialize countryData array that will hold lines of file 
             * containing country name and its data
             * 
             */
            String numOfCountries = input.nextLine();  
            String[] tokens = numOfCountries.split(",");            

            int numberOfCountries = Integer.parseInt(tokens[1]); 

            String years = input.nextLine();
            String[] yearTokens = years.split(",");

            /*
             * initializes and sets elements from third line containing years
             */
            yearLabels = new int[yearTokens.length-1];          

            for(int i = 1; i < yearTokens.length; i++)
            {
                // skips first element i.e Country Name in yearTokens array 
                yearLabels[i-1] = Integer.parseInt(yearTokens[i]);
            }

            /*
             * storing lines with country name and its data in ccountryData array
             * line by line
             */
            String[] countryData = new String[numberOfCountries]; 

            countryNames = new String[numberOfCountries];

            cellularDataTable = new double[numberOfCountries][yearLabels.length];

            int count = 0;

            while (input.hasNextLine() && count < numberOfCountries)
            {
                String nameAndData = input.nextLine();
                countryData[count] = nameAndData;
                /*
                 * splits line at "," into tokens and stores in an array of dataTokens
                 */
                String[] dataTokens = nameAndData.split(",");

                /*
                 * stores the first element of dataTokens in countryNames array 
                 * at every loop pass
                 */
                countryNames[count] = dataTokens[0]; 

                for(int j = 1; j < dataTokens.length; j++)
                {   
                    // skips country name and stores its data corresponding to its index
                    cellularDataTable[count][j-1] = Double.parseDouble(dataTokens[j]);                         
                }   
                count++; 
            } 
            input.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("File " + fileName + " not found!");
        }

    }

    public String[] getCountryNames() { return countryNames; }

    public int[] getYearLabels() { return yearLabels; }

    public double[][] getParsedTable() { return cellularDataTable; }

}