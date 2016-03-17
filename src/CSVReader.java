import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * One object of class CSVReader reads a .csv file one line at a time,
 * sets the values of various attributes, and parses the information.
 * @author Shiva
 */
public class CSVReader {
	private String countryNames[];
	private int yearLabels[];
	private double cellularData[][];
	private String FILENAME;
	private int numOfCountries;
	private int numOfYears;
	private String delimiter = ",";
	CellularData table;
	Scanner reader;

	/**
	 * Sets the value of 'newFileName' to 'FileName'
	 * @param newFileName   name of the file to be read
	 */
	public void setFilename(String newFileName) {
		newFileName = FILENAME;
	}

	/**
	 * Creates an object of File and Scanner
	 * and reads the file line by line.
	 * @param FILENAME   name of the file to be read.
	 */
	public CSVReader(String FILENAME) {
		setFilename(FILENAME);
		File dataFile = new File(FILENAME);
		try {
			reader = new Scanner(dataFile);
			reader.nextLine();
			String totalNumOfCountries = reader.nextLine();
			String years = reader.nextLine();
			
			numOfCountries = Integer.parseInt(totalNumOfCountries.split(delimiter)[1]);
			
			String listOfYears[] = years.split(delimiter);
		    yearLabels = new int[listOfYears.length-1];
		     for(int yearIndex = 0; yearIndex < yearLabels.length; yearIndex++){
		    	 yearLabels[yearIndex] = Integer.parseInt(listOfYears[yearIndex + 1]);
		     }
		     
		     numOfYears = yearLabels.length;
		     
		     countryNames = new String[numOfCountries];
		     cellularData = new double[numOfCountries][numOfYears];
		     
		     int countryIndex = 0;
		     while(reader.hasNextLine()){
		    	 String allContents = reader.nextLine();
		    	 String tableData[] = allContents.split(delimiter); 
		    	 countryNames[countryIndex] = tableData[0];
		    	 for(int dataPos = 0; dataPos < numOfYears; dataPos++){
		    		 cellularData[countryIndex][dataPos] = Double.parseDouble(tableData[dataPos+1]);
		    	 }
		    	 countryIndex++;
		    	}
		     reader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
			
	
	/**
	 * Returns the value of number of Years
	 * @return  numOfYears   number of years from 1960 to 2012
	 */
	public int getNumberOfYears() {
		return numOfYears;
	}
	
	/**
	 * Returns the array of yearLabels
	 * @return yearLabels[]  array of years from 1960 to 2012
	 */
	public int[] getYearLabels() {
	     return yearLabels;
	}
	
	/**
	 * Returns the list of Countries
	 * @return  countryNames[]  array that stores all the 252 countries
	 */
	public String[] getCountryNames() {
	      return countryNames;
	}

	/**
	 * Returns the table of data
	 * @return cellularData[][]  parsed 2D array containing data for all countries
	 */
	public double[][] getParsedTable() {
		 return cellularData;
	} 
	
	/**
	 * Returns the top row containing the 
	 * row header 'Country Names' and the years
	 * from 1960 to 2012
	 * @return topRow    top Row contains row headers for the table
	 */
	public String displayTopRow(){
		String topRow = "Country Names : ";
		for(int index = 0; index < yearLabels.length; index++){
			topRow = topRow + yearLabels[index] + " ";
		}
		
		return  topRow;
	} 
}

