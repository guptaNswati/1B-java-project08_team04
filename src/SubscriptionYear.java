
/**
 * One object of class SubscriptionYear sets the values of the attributes year
 * and subscriptios, and returns these values.
 * @author Shiva
 */
public class SubscriptionYear {
	private int year;
	private double subscriptions;

	/**
	 * Sets value of year
	 * 
	 * @param year   year for subscription data
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Sets value of subscriptions
	 *
	 * @param subscriptions   number of subscription for a given year
	 */
	public void setSubscriptions(double subscriptions) {
		this.subscriptions = subscriptions;
	}

	/**
	 * returns the value of year
	 * 
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * returns the value of subscriptions
	 * 
	 * @return subscriptions
	 */
	public double getSubscriptions() {
		return subscriptions;
	}

	/**
	 * Initializes values of year and subscriptions
	 * 
	 * @param year    year for subscription data
	 * @param subscriptions   number of subscriptions for a year
	 */
	public SubscriptionYear(int year, double subscriptions) {
		setYear(year);
		setSubscriptions(subscriptions);
	}

	/**
	 * returns a string representation of subscriptions
	 */
	public String toString() {
		return Double.toString(getSubscriptions());
	}
	
	
	/**
	 * Checks if two objects of type SubscriptionYear 
	 * are equal.
	 * @param obj  contains subscriptions for a country
	 * @return true 	if objects are equal
	 */
	public boolean equals(Object obj){
		SubscriptionYear other = (SubscriptionYear)obj;
		if(other.equals(this)){
			return true;
		}
		return false;
	}
}

