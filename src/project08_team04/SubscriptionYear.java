package project08_team04;


/**
*
* @param SubscriptionYear[having two private instance variables]
*       
*/

public class SubscriptionYear
{
   /**
    * @param year[Type: int, stores the year for a subscription data]
    * @param subscriptions[Type: double, stores the number of subscriptions for a specific year]
    */
   private int year;
   private double subscriptions;
   
   SubscriptionYear(int year, double subscriptions)
   {       
       this.year = year;
       this.subscriptions = subscriptions;        
   }
  
   public void setYear(int year)
   {
       this.year = year;
   }
     
   public void setSubscriptions(double subscriptions)
   {
       this.subscriptions = subscriptions;
   }
   
   public int getYear() { return year; }
   
   public double getSubscriptions() { return subscriptions; }

  /**
   * @return subscription as a String
   */
   public String toString()
   {        
       return " " + this.getSubscriptions();
   }
   
   
   // commenting this out after reading your discussion with Benjamin as you mentioned we don't need this in this project
//   public boolean equals(Object someObject)
//   {   
//       // if someObject is null, simply return
//       if (someObject == null)
//           return false;
//      
//       // else checks if this objects subscription data equals object's subscription data 
//       // someOject is of type Object, so it is casted in to SubscriptionYear before comparing it with SubscriptionYear object 
//       return (this.subscriptions == ((SubscriptionYear)someObject).getSubscriptions() && this.year == ((SubscriptionYear)someObject).getYear());                                  
//   }   
//   
}