import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 * One object of class LegendPanel provides a visual guide to viewing the list of 
 * random countries.
 * @author Team04
 */
public class LegendPanel extends JPanel  {
    private int height;
    private int width;
    private Color backgroundColor;
    private GraphView graphObject;
    
    /**
     * Constructor that creates a panel with the given attributes
     * @param width[Type: int, sets the width of the panel]
     * @param height[Type: int , sets the height of the panel]
     * @param color[Type: Color, sets the background color of the panel
     * @param graphObject[Type: GraphView, gives the color of the plotted data points and name of country to be added in panel]
     */
    public LegendPanel(int width, int height, Color color, GraphView gv){
        this.setSize(width, height);
        this.setBackground(color); 
        this.graphObject = gv;
    }
    
    /**
     * draws a rectangle using legend objects and writes its name
     * @param g[a Graphics object that draws rectangle in the panel]
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        LinkedList<Legend>legends = graphObject.getListOfLegends();
       
        Iterator<Legend> l_iterator = legends.iterator();
        
        // x coordinate of rectangle for legend panel
        int xCoordinate = 10; 
        
        // y coordinate of rectangle for legend panel
        int yCoordinate = 10; 
        
        // width of rectangle for legend panel
        int width = 30;
        
        // height of rectangle for legend panel
        int height = 20;
        
        // space after which the next rectangle to be drawn
        int increment = 30; 
        
        Legend legendKey;
       
        while(l_iterator.hasNext()){
            legendKey = l_iterator.next();
            for(int counter = 0; counter < legends.size(); counter++){
                g2d.drawRect(xCoordinate, yCoordinate + increment, width, height);             
                g2d.setColor(legendKey.getLegendColor());
                g2d.fillRect(xCoordinate, yCoordinate + increment, width, height);               
                g2d.setColor(Color.BLACK);
                g2d.drawString(legendKey.getCountryName(), xCoordinate + 32, yCoordinate + increment + 15); 
                }
            yCoordinate = yCoordinate + increment;
        }
    }
}
