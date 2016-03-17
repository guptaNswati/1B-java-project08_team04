/**
 * One object of class CellularData represents a table containing the cellular
 * data for all the countries.
 * @author Shiva
 */
public class CellularData {
	private double table[][];
	private String countryNames[];
	private int numRows;
	private int numColumns;
	private int startingYear;

	/**
	 * Sets value of 'numRows'
	 * 
	 * @param numRows    rows of the table
	 */
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	/**
	 * Sets value of 'numColumns'
	 * 
	 * @param numColumns  columns of the table
	 */
	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	/**
	 * Sets value of 'startingYear'
	 * 
	 * @param startingYear  starting year for the data table
	 */
	public void setStartingYear(int startingYear) {
		this.startingYear = startingYear;
	}

	/**
	 * Sets value of 'table'
	 * 
	 * @param rows    rows of the table   
	 * @param columns columns of the table
	 */
	public void setTable(int rows, int columns) {
		this.table = new double[rows][columns];
	}

	/**
	 * Sets value of 'countryNames'
	 * 
	 * @param rows   length of the array countryNames
	 */
	public void setCountryNames(int rows) {
		this.countryNames = new String[rows];
	}

	/**
	 * Calls the setter methods for initializing the values of the rows,
	 * columns, starting year, table, and countryNames.
	 * 
	 * @param numRows  number of rows of the table
	 * @param numColumns number of columns of the table
	 * @param startingYear starting year for the data table 
	 */
	public CellularData(int numRows, int numColumns, int startingYear) {
		setNumRows(numRows);
		setNumColumns(numColumns);
		setStartingYear(startingYear);
		setTable(numRows, numColumns);
		setCountryNames(numRows);

	}

	/**
	 * Adds a country name to the list of countries, and assigns value of the
	 * countrydata to the corresponding countryName.
	 * 
	 * @param countryName  name of the country to be added
	 * @param countryData  array of data for one country
	 */
	public void addCountry(String countryName, double[] countryData) {
		int index = -1;
		int pos;
		for (int i = 0; i < numRows; i++) {
			if (countryNames[i] == null) {
				index = i;
				break;
			}
		}
		if (index > -1) {
			countryNames[index] = countryName;

			for (pos = 0; pos < numColumns; pos++) {
				if (table[index][pos] == 0) {
					table[index][pos] = countryData[pos];
				}
			}
		}
	}

	/**
	 * Returns a string representation of the table.
	 */
	public String toString() {
		String info = " ";
		for (int countryPos = 0; countryPos < numRows; countryPos++) {
			info = info + countryNames[countryPos] + " : ";
			for (int dataPos = 0; dataPos < numColumns; dataPos++) {
				info += (String.format("%.2f", table[countryPos][dataPos]) + "  ");
			}
			info = info + "\r\n";
		}
		return info;

	}
	
	/**
	 * Calculates and returns total value of subscriptions for the given
	 * country.
	 * 
	 * @param countryName       name of country required to calculate total subscriptions
	 * @param beginningYear		beginning of data calculation period
	 * @param endYear			end of data calculation period
	 * @return totalSubscriptions
	 */
	public double getNumSubscriptionsInCountryForPeriod(String countryName, int beginningYear, int endYear) {
		double totalSubscriptions = 0;
		int yearIndex;
		int periodOfCalc;
		int endLimit;
		
		if ((beginningYear < startingYear) || (endYear > 2012 )) {
			System.out.print("Error! Year is out of bounds for ");
			return -1;
		}
		else if(beginningYear > endYear){
				System.out.print("Error! Wrong order of years for  ");
				return -1;
			}
			else {
			yearIndex = beginningYear - startingYear;
			periodOfCalc = ((endYear - beginningYear) + 1);
			endLimit = yearIndex + periodOfCalc;
			

			for (int countryPos = 0; countryPos < countryNames.length; countryPos++) {
				if (countryNames[countryPos].equalsIgnoreCase(countryName))
					for (int index = yearIndex; index < endLimit; index++) {
						totalSubscriptions += table[countryPos][index];
						} 
					} 
				}
		return totalSubscriptions;
	} 
}
