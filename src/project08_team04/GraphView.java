package project08_team04;
/**
 * @author Team04
 * @Class [Maps the cellular data of a country to the width and height of the panel. And also shows the subscription data when user clicks on the plotted points]
 */
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class GraphView extends JPanel implements MouseInputListener
{
    /**
     * @member POINT_SIZE[Type: int, size of the data point to be plotted on graph]
     * @member MARGIN[Type: int, spaces out the x and y coordinates]
     * @member width[Type: int, width of the JPanel]
     * @member height[Type: int, height of the JPanel]
     * @member font[Type: font, sets the text size nad style]
     * @member plottedXmin[Type: int, holds value of minimum x coordinate]
     * @member plottedXmax[Type: int, holds value of maximum x coordinate]
     * @member plottedYmin[Type: int, holds value of minimum y coordinate]
     * @member plottedYmax[Type: int , holds value of maximum y coordinate]
     * @member dataMinX[Type: int, holds the starting year ]
     * @member dataMaxY[Type: int, holds the ending year]
     * @member dataMinY[Type: double, holds the minimum subscription data ]
     * @member dataMaxY[Type: double, holds the maximum subscription data ]
     * @member listOfCountryDataPoints[Type: PlottedDataSet, a linkedlist of colored data points]
     * @member listOfLegends[Type: Legend, a linkedlist of legends objects] 
     */
    private static final int POINT_SIZE = 9;
    private final int MARGIN = 27; 
    private int width; 
    private int height; 
    private Font font;

    // instances variables to map the data points to the drawing area 
    private int plottedXmin; 
    private int plottedXmax; 
    private int plottedYmin; 
    private int plottedYmax;

    private int dataMinX;
    private int dataMaxX;
    private double dataMinY;
    private double dataMaxY;   

    private LinkedList<PlottedDataSet> listOfCountryDataPoints;

    private LinkedList<Legend> listOfLegends;
    
    // point for capturing mouse clicks
    Point point = null;
    
    // label of the selected point
    private JLabel label;

    /**
     * constructs an object on GraphView that creates a graph of the country data
     * @param width [ sets the width of the panel]
     * @param height[ sets the height of the panel]
     * @param countries [ takes linkedlist of country objects]
     */
    GraphView(int width, int height, LinkedList<Country> countries)
    {
      // adding MouseListener to this GraphView Object
        addMouseListener(this);      
        addMouseMotionListener(this);  
        
        this.width = width;
        this.height = height;

        this.plottedXmin = MARGIN;
        this. plottedXmax = width - MARGIN; 

        this.plottedYmin = height - MARGIN;
        this. plottedYmax = MARGIN; 

        font = new Font("Serif", Font.PLAIN, 9); 
        
        label = new JLabel();       

        // using the subscriptions of one country to determine the starting year (dataMinX) and ending year (dataMaxX)
        this.dataMinX = countries.getNodeAtIndex(0).getData().getMinYear();
        this.dataMaxX = countries.getNodeAtIndex(0).getData().getMaxYear();

        // setting the minimum subscription value (dataMinY)       
        dataMinY = 0.0;

        // To set the maximum subscription value we need to run through all the subscriptions of all the countries 
        //to find the largest one
        dataMaxY = 0.0;

        Iterator <Country> iterator = countries.iterator();

        Country current;

        // list of plottedDataPoints holding list of coloredPoints for each country
        listOfCountryDataPoints = new LinkedList<PlottedDataSet>();

        listOfLegends = new LinkedList<Legend>();

        // counter for outer loop
        int counter_1 = 0;

        while(iterator.hasNext())
        {
            current = iterator.next();

            if (current.getMaxSubscription() > dataMaxY)
            {
                dataMaxY = current.getMaxSubscription();
            }

            // After determining the dataMinX, dataMaxX, dataMinY and dataMaxY, 
            // going through all the data once and saving the mapped values
            double originalX;
            double originalY;
            double mappedX;
            double mappedY;

            // current node of type PlottedDataSet holding a list of coloredPoints for each country 
            //to be stored in listOfCountryDataPoints 
            PlottedDataSet dataPoints = new PlottedDataSet();           

            // creates an object of type legend using the name of the current country and PlottedDataSet object's color
            Legend legendKey = new Legend(current.getName(), dataPoints.getRandomColor());

            SubscriptionYear currentSubscription;

            Iterator<SubscriptionYear> iterator_s =  current.getSubscriptions().iterator();

            // counter for inner loop
            int counter_2 = 0;

            while(iterator_s.hasNext())
            {                
                currentSubscription = iterator_s.next();

                // saves original x and y values to be used in creating object of the type PlottedDataSet
                originalX = currentSubscription.getYear();

                originalY = currentSubscription.getSubscriptions();              

                // calculates the x and y value as the per the screen area by calling map()
                mappedX = map(originalX, dataMinX, dataMaxX, (plottedXmin -20), (plottedXmax-MARGIN));

                mappedY = map(originalY, dataMinY, dataMaxY, (plottedYmin - 32), (plottedYmax + 32));

                dataPoints.addDataPoints(originalX, originalY, mappedX, mappedY);

                counter_2++;                           
            }          
            this.listOfCountryDataPoints.add(dataPoints);

            this.listOfLegends.add(legendKey);       

            counter_1++;
        } 
       
    }

    public LinkedList<PlottedDataSet> getListOfCountryDataPoints() { return this.listOfCountryDataPoints; }  

    public LinkedList<Legend> getListOfLegends() { return listOfLegends; }  

    /**
     *  map the data to the available space of the screen
     * @param value [Type: double, original data values of x and y ]
     * @param dataMin [Type: double, starting values of x and y ]
     * @param dataMax  [Type: double, ending values of x and y ]
     * @param plottedMin  [Type: double, holds minimum x coordinate and maximum y coordinates ]
     * @param plottedMax  [Type: double, holds minimum y coordinate and maximum x coordinate ]
     * @return mappedValue of type double
     */
    public static final double map(double value, double dataMin, double dataMax, double plottedMin, double plottedMax)
    {
        return plottedMin + (plottedMax - plottedMin) * ((value - dataMin) / (dataMax- dataMin));
    }

    /**
     * captures the location of the point on which mouse is clicked on this graph view event
     */
    public void mouseClicked(MouseEvent e) 
    { 
        int x = e.getX();
        int y = e.getY();
        
        if (point == null) 
        {
            point = new Point(x, y);
        }
        else  
            
        this.updatePoint(x, y);
        this.repaint();
    }
    
    /**
     * updates the location of clicked points
     * @param x [type: int, x coordinate of the point ]
     * @param y [type: int, y, coordinate of this point]
     */
    public void updatePoint(int x, int y) 
    {
        point.x = x;
        point.y = y;
    }
       
    /**
     * First draws the x-axis and y-axis, names them
     * then draws the points
     * finally when user clicks on those points show their values
     */
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int firstX = this.plottedXmin - 20;       
        int firstY = this.plottedYmax;     
        int lastX = this.plottedXmax - 20;
        int lastY = this.plottedYmin - MARGIN;       

        // draws horizontal line and names it
        g2d.drawLine(firstX, lastY, firstX, firstY);         
        g2d.drawString("Year", lastX,lastY);

        // draws vertical line and names it
        g2d.drawLine(firstX, lastY, lastX, lastY);       
        g2d.drawString("Number of Subscriptions (per 100 people)",firstY - 25, firstX + 20);

        Iterator<PlottedDataSet> iterator_P =  this.listOfCountryDataPoints.iterator();

        PlottedDataSet currentDataPoints;

        // generating the colored point for each data value
        while(iterator_P.hasNext())
        {
            currentDataPoints = iterator_P.next();

            for (int i = 0; i < currentDataPoints.getDataPoints().size(); i++)
            {          
                g2d.setColor(currentDataPoints.getRandomColor());

                g2d.fillOval((int)currentDataPoints.getDataPoints().getNodeAtIndex(i).getData().getX(), 
                        (int)currentDataPoints.getDataPoints().getNodeAtIndex(i).getData().getY(), 
                        POINT_SIZE, POINT_SIZE);
                
                // first checks if point is not null and then 
                if (this.point != null)
                {                 
                    // the range of clicked point and its closest plotted point and if its less than 6, plot the original values of that comparison point
                    if ((Math.abs(this.point.getX() - currentDataPoints.getDataPoints().getNodeAtIndex(i).getData().getMappedX()) < 6))
                    {                    
                        this.label.setText(currentDataPoints.getDataPoints().getNodeAtIndex(i).getData().getLabel());    
                        this.label.setLocation((int)this.point.getX(), (int)this.point.getY());
                    }
                    // finally add the label on panel
                    add(label);
                }                           
            }  
        }        
     }
    // unused methods of interface MouseInput Listener
    public void mouseMoved(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { } 
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { } 
    public void mouseDragged(MouseEvent e) { }
}

 



