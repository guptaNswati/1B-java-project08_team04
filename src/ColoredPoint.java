
import java.awt.Color;
import java.awt.Point;
/**
 * One object of class ColoredPoint represents a point on the graph.
 * One point represents the subscription data of one country for one year.
 * @author Team04
 */

public class ColoredPoint extends Point {
    private Color color;
    private double originalX;
    private double originalY;
    private int mappedX;
    private int mappedY;
    
    /**
     * Constructs an object of type ColoredPoint of type ColoredPoint
     * @param color         color of the poiny
     * @param originalX     value of year
     * @param originalY     value of subscription 
     * @param mappedX       mapped x-coordinate of the point
     * @param mappedY       mapped y-coordinate of the point
     */
    public ColoredPoint(Color color, double originalX, double originalY, int mappedX, int mappedY){
        super(mappedX, mappedY);
        this.mappedX = mappedX;
        this.mappedY = mappedY;
        this.color = color;
        this.originalX = originalX;
        this.originalY = originalY;
    }

    /**
     * Returns the color of each coloredPoint
     * @return color    color of coloredPoint
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns a string representation x and y values of the data point
     * @return label displaying x and y values of a point  
     */
    public String getLabel()
    {
          return "(" + (int)originalX + "," + String.format("%.2f", originalY)  + ")";        
    } 
    
    public int getMappedX() { return this.mappedX; }
    
    public int getMappedY() { return this.mappedY; }
       
} 


