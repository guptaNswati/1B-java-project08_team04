import java.awt.Color;
import java.util.Random;

/**
 *  One object of type PlottedDataSet class holds a list of ColoredPoints.
 * @author Team04
 */

public class PlottedDataSet
{
    private LinkedList<ColoredPoint> dataPoints;
    Color randomColor;
    
    private int count = 0;
    
    /**
     * Constructs an object of type PlottedDataSet that holds
     * a linked list of type ColoredPoints.
     */
    public PlottedDataSet()
    {
        this.dataPoints = new LinkedList<ColoredPoint>();
        
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);
        int purple = randomGenerator.nextInt(256);        
        
        this.randomColor  = new Color(red,green,blue, purple);   
    }
    
    
    /**
     * Creates and adds an object of coloredPoint to dataPoints(LinkedList)
     * @param originalX     value of the year
     * @param originalY     value of the subscription
     * @param mappedX       x-coordinate of the point
     * @param mappedY       y-coordinate of the point
     */
    public void addDataPoints(double originalX, double originalY, double mappedX, double mappedY)
    {     
        ColoredPoint currentDataPoint = new ColoredPoint(this.randomColor, originalX,originalY, (int)mappedX, (int)mappedY);
        
        this.dataPoints.add(currentDataPoint);
        count++;
    }
    
   /**
    * Returns the value of random color
    * @return Color      randomly generated color
    */
    public Color getRandomColor() {
        return this.randomColor.darker();
    }
    
    /**
     * Returns the linked list of ColoredPoints
     * @return dataPoints  list of coloredPoints
     */
    public LinkedList<ColoredPoint> getDataPoints() {
        return dataPoints; 
    } 

}