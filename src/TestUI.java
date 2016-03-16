import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class TestUI implements ActionListener {
	
		public static void main(String[] args) {
		
		//Reads data from CSV file and parses it
	    final String FILENAME = "resources\\cellular.csv";   
        CSVReader parser = new CSVReader(FILENAME);
        String [] countryNames = parser.getCountryNames();
        int [] yearLabels = parser.getYearLabels();
        double [][] parsedTable = parser.getParsedTable();
        
        //creates an array of country objects
        Country [] countries;
        final int NUM_COUNTRIES_TO_TEST = 3; 
        countries = new Country[NUM_COUNTRIES_TO_TEST];

        Country current;
        countries = new Country[countryNames.length];

        for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
        {
            int numberOfYears = yearLabels.length;   

            current = new Country(countryNames[countryIndex]);  

            for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
            {
                double [] allSubscriptions = parsedTable[countryIndex];
                double countryData = allSubscriptions[yearIndex];
                current.addSubscriptionYear(yearLabels[yearIndex], countryData);
            }
            countries[countryIndex] = current;
        }
        
        LinkedList<Country> allCountries = new LinkedList<Country>();	
        //creates a LinkedList of Country Objects
        for (int index = 0; index < countries.length; index++)
        {
            allCountries.add(countries[index]);
        }
        
		//Creates the UI 
        JFrame UI_menu = new JFrame();
        UI_menu.setTitle("Graph Settings");
        UI_menu.setLayout(new BorderLayout());
        UI_menu.setSize(600,600);
       
     
        JPanel yearMenu_panel = new JPanel();
        yearMenu_panel.setLayout(new BoxLayout(yearMenu_panel, BoxLayout.Y_AXIS));
        yearMenu_panel.setSize(new Dimension(300,600));
        
       YearMenu startYearMenu = new YearMenu(250,600, yearLabels);
        JLabel prompt1 = new JLabel("Select starting year ");
        yearMenu_panel.add(prompt1);
        yearMenu_panel.add(startYearMenu);
       
        YearMenu endYearMenu = new YearMenu(250,600,yearLabels);
        JLabel prompt2 = new JLabel("Select ending year ");
        yearMenu_panel.add(prompt2);
        yearMenu_panel.add(endYearMenu);
        
        UI_menu.add(yearMenu_panel); 
       
        //Creates a new CountryMenu
        CountryMenu countryMenuPanel = new CountryMenu(300,600,allCountries);
         JScrollPane Scroller = new JScrollPane(countryMenuPanel);
        Scroller.setPreferredSize(new Dimension(300,500));
        UI_menu.add(Scroller, BorderLayout.WEST);
        
         JButton graphButton = new JButton("Graph");
        graphButton.setPreferredSize(new Dimension(20,25));
        yearMenu_panel.add(graphButton);
        UI_menu.setVisible(true);
        
        LinkedList<Country>selectedCountries = new LinkedList<Country>();
      
        LinkedList<String>checkedCountries = countryMenuPanel.getCheckedCountries();
       
        
        for(int index = 0; index < checkedCountries.size();index++){
        	Country checkedCountry = new Country(checkedCountries.getNodeAtIndex(index).getData());
        		Country foundCountry = allCountries.contains(checkedCountry);
        		if(foundCountry!=null){
        			selectedCountries.add(foundCountry);
        	}
        }
       
       
        
   
////       //Creates and Initializes GraphView and LegendPanel
		    int FRAME_WIDTH = 800;
		    int FRAME_HEIGHT = 600;
		   JFrame frame = new JFrame("Cellular Graph");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

//	        //Sets the layout for the frame
	        FlowLayout layout = new FlowLayout();
	        frame.setLayout(layout);    

	        int graph_panel_size = 600;

	        //Creates an object of type GraphView and adds a label
	        GraphView myPlots = new GraphView(graph_panel_size, FRAME_HEIGHT, selectedCountries);   
        myPlots.setPreferredSize(new Dimension(592, FRAME_HEIGHT)); //400
	        myPlots.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        JLabel graphLabel = new JLabel("Graph");
	        myPlots.add(graphLabel);
        
////	        //Creates scrollbars for GraphView
	        JScrollPane graphScroller = new JScrollPane(myPlots, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        graphScroller.setPreferredSize(new Dimension(580, FRAME_HEIGHT-30));
	        myPlots.setAutoscrolls(true);
	        
////	        //adds to frame
	        frame.add(graphScroller);
	        graphScroller.setVisible(true);
//	        
////	        //Creates a legend panel with legend keys and adds a label
	        LegendPanel graphKey = new LegendPanel(200, 600, Color.white, myPlots);
	        graphKey.setLayout(new BorderLayout());
	        graphKey.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        JLabel legendLabel = new JLabel("Legend Key");
	        graphKey.add(legendLabel, BorderLayout.NORTH);
//      
//	       // Creates scrollbars for the legend panel.	
	        graphKey.setPreferredSize(new Dimension(148, FRAME_HEIGHT));      
	        JScrollPane legendScroller = new JScrollPane(graphKey, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        legendScroller.setPreferredSize(new Dimension(148, FRAME_HEIGHT-60));
	        graphKey.setAutoscrolls(true);
      
//	       // Adds to frame
	       frame.add(legendScroller);
	       legendScroller.setVisible(true);
//	       
//	 
	        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	        frame.setResizable(false);
	        frame.setVisible(true);    
		}
//		
		@Override
		public void actionPerformed(ActionEvent evt) {
			
			
		}
       
   }
