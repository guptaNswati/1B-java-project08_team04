import java.util.Iterator;
import java.util.ListIterator;

/**
* One object of class country creates objects of type SubscriptionYear and
* stores the subscription data for one country.
* @author Team04
*/

public class Country {
    private String name;
    private int numOfYears;
    private int minYear;
    private int maxYear;
    private int yearCounter;
    LinkedList <SubscriptionYear> subscriptions = new LinkedList<SubscriptionYear>();

    /**
     * Sets value of 'name'
     * 
     * @param name  name of country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns value of name
     * @return name  name of country
     */
    public String getName() {
        return name;
    }

    /**
     * Sets value of numOfYears
     * 
     * @param numOfYears  size of subscriptions array
     */
    public void setNumOfYears(int numOfYears) {
        this.numOfYears = numOfYears;
    }

    /**
     * returns value of numOfYears;
     * 
     * @return numOfYears  total number of years for each country
     */
    public int getNumOfYears() {
        return numOfYears;
    }

    /**
     * Instantiates size of subscriptions array
     * @param country     name of country
     */
    public Country(String country){
        setName(country);
        yearCounter = 0;
        minYear = 9999;
        maxYear = 0;
    }

    /**
     * Creates objects of type SubscriptionYear and adds the SubscriptionYear
     * to the list of subscriptions.
     * @param year           year for which data is stored
     * @param dataElement    subscription for a particular year
     */
    public void addSubscriptionYear(int year, double dataElement) {
        if(yearCounter == 0){
             minYear = year;
        }
        SubscriptionYear dataObject = new SubscriptionYear(year, dataElement);
            subscriptions.add(dataObject);
            yearCounter++;
            maxYear = year; 
    }
    
    /**
     * Returns total number of subscriptions for a country for a given
     * period of time
     * @param startingYear    lower limit for the time period
     * @param endingYear      upper limit for the time period
     * @return totalSubscriptions  sum of subscriptions
     */
    public double getNumSubscriptionsForPeriod(int startingYear, int endingYear) {
        Iterator<SubscriptionYear> subsIterator = subscriptions.iterator();
        double totalSubscriptions = 0;
        double existingData = 0;
        int counter = 0;
        int period = ((endingYear - startingYear) + 1);
        if (startingYear >= minYear && endingYear <= maxYear) {
            System.out.println("Total subscriptions from " + startingYear + " to " + endingYear + " : ");
            while (subsIterator.hasNext()) {
                SubscriptionYear element = subsIterator.next();
                if ((element.getYear() >= (startingYear)) && (counter < period)) {
                    totalSubscriptions += element.getSubscriptions();
                    counter++;
                }
            }
        } else {
            if (startingYear < minYear) {
                System.out.println("\n" + "Error: Starting year " + startingYear + " is out of bounds");
            } else if (endingYear > maxYear) {
                System.out.println("\n" + "Error: Ending year " + endingYear + " is out of bounds ");
            }
            while (subsIterator.hasNext()) {
                existingData += subsIterator.next().getSubscriptions();
            }
            System.out.println("Total Subscriptions from " + minYear + " to " + maxYear + ": ");
            return existingData;
        }
        return totalSubscriptions;
    }

    /**
     * returns a string representation of subscriptions
     */
    public String toString() {
        String info = " ";
        info = name + "\t";
        Iterator<SubscriptionYear>iterator = subscriptions.iterator();
        while(iterator.hasNext()){
            info += String.format("%.2f  ", iterator.next().getSubscriptions());
        }
        return info;

    }
    
    /**
     * Returns true if the country names are equal
     * @param obj   country object to be compared
     * @return true   if country names are equal
     */
    public boolean equals(Object obj){
        Country other = (Country)obj;
        if(other.getName().equalsIgnoreCase(this.getName())){
            return true;
        }
        return false;
    }
    
    
    /**
     * Returns minSubscriptions  
     *@return minSubscriptions  minimum subscription value of the data set
     */
    public double getMinSubscription()
    {
        return subscriptions.getNodeAtIndex(0).getData().getSubscriptions();      
    }
    
    /**
     * Returns maxSubscriptions
     * @return maxSubscriptons  maximum subscription value of the data set
     */
    public double getMaxSubscription()
    {
        return subscriptions.getNodeAtIndex(subscriptions.size()-1).getData().getSubscriptions();      
    }
  
    /**
     * Returns linked list of type SubscriptionYear
     * @return subscriptions   linkedList of subscriptions
     */
    public LinkedList <SubscriptionYear> getSubscriptions(){
        return subscriptions;
    }
    
    /**
     * Returns the maxYear
     * @return maxYear maximum year of data set
     */
    public int getMaxYear() 
    { 
        return this.maxYear;
    }
    
    /**
     * Returns minYear
     * @return minYear minimum year of data set
     */
    public int getMinYear() 
    { 
        return this.minYear; 
    }
}


