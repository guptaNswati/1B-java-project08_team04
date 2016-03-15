package project08_team04;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

public class MousePlay implements MouseInputListener
{
    private JLabel label;
    private Point clickPoint;
    GraphView gv;
    private String coordinate;
    
    MousePlay(GraphView graph)
    {
        this.coordinate = " ";
        this.clickPoint = new Point();
        this.label = new JLabel();
        this.gv = graph;
        
        gv.addMouseListener(this);
        gv.addMouseMotionListener(this);        
    }

    public void updateClickPoint(Point p) 
    {
        clickPoint = p;
        updateLabel();
    }
    
    protected void updateLabel() 
    {
        String text = "";
        
        if (this.clickPoint != null) 
            {
                text += "The last click was at (" 
                        + this.coordinate+ "). ";
            }
        
        
        this.label.setText(text);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        boolean state = false;
      
        LinkedList<PlottedDataSet> dataPoints = this.gv.getListOfCountryDataPoints();
        
        Iterator<PlottedDataSet> iterator_P = dataPoints.iterator();
        
        PlottedDataSet currentDataPoints;
        
        // generating the colored point for each data value
        while(iterator_P.hasNext())
        {
            currentDataPoints = iterator_P.next();
    
            for (int i = 0; i < currentDataPoints.getDataPoints().size(); i++)
            {      
                int mappedX = currentDataPoints.getDataPoints().getNodeAtIndex(i).getData().getMappedX();
                int mappedY = currentDataPoints.getDataPoints().getNodeAtIndex(i).getData().getMappedY();
                int difference = e.getX() - mappedX;
            
                if (Math.abs(difference) < 6)
                {
                    state = true;
                    int x = mappedX;
                    int y = mappedY;
                    this.clickPoint.x = x;
                    this.clickPoint.y = y;                   
                    this.coordinate = currentDataPoints.getDataPoints().getNodeAtIndex(i).getData().getLabel(); 
                    updateLabel();
                }                
            }
            System.out.println(state);
            System.out.println(e.getX());
            System.out.println(clickPoint.x);
        }
        this.updateClickPoint(clickPoint);        
    }
    
    public void paintComponent(Graphics g)
    {        
        g.drawString(this.coordinate, clickPoint.x, clickPoint.y);      
    }
        

    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub        
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub        
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub        
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub        
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        // TODO Auto-generated method stub        
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        // TODO Auto-generated method stub
        this.updateClickPoint(e.getPoint());
    }
}
