import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.Iterator;

public class TestUI implements ActionListener, ItemListener {

	int minYear;
	int maxYear;
	LinkedList<Country>checkedCountries = new LinkedList<Country>();
	LinkedList<Country>graphViewCountries = new LinkedList<Country>();
	LinkedList<Country>allCountries = new LinkedList<Country>();
	 
	public static void main(String[] args) {

		// Reads data from CSV file and parses it
		final String FILENAME = "resources\\cellular.csv";
		CSVReader parser = new CSVReader(FILENAME);
		String[] countryNames = parser.getCountryNames();
		int[] yearLabels = parser.getYearLabels();
		double[][] parsedTable = parser.getParsedTable();

		// creates an array of country objects
		Country[] countries;
		final int NUM_COUNTRIES_TO_TEST = 3;
		countries = new Country[NUM_COUNTRIES_TO_TEST];

		Country current;
		countries = new Country[countryNames.length];

		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++) {
			int numberOfYears = yearLabels.length;

			current = new Country(countryNames[countryIndex]);

			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++) {
				double[] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}
			countries[countryIndex] = current;
		} 
		
		TestUI application = new TestUI();
		application.buildCountryList(countries);
		application.createUI();
		
} //END OF MAIN
	
		
	public void buildCountryList(Country[] countries){
			for (int index = 0; index < countries.length; index++) {
			this.allCountries.add(countries[index]);
		}
	
	
} //END OF BUILD LIST METHOD

	
		public void createUI(){
		
		// Creates the UI
		JFrame UI_menu = new JFrame();
		UI_menu.setTitle("Graph Settings");
		UI_menu.setLayout(new BorderLayout());
		UI_menu.setSize(600, 600);

		
		 
		JPanel yearMenuPanel = new JPanel();
		yearMenuPanel.setLayout(new BoxLayout(yearMenuPanel, BoxLayout.Y_AXIS));
		yearMenuPanel.setSize(new Dimension(300, 600));
		JLabel promptLabel = new JLabel("Select range of years");
		yearMenuPanel.add(promptLabel);

		JPanel startingYearPanel = new JPanel();
		startingYearPanel.setSize(new Dimension(300,300));
		JTextField startingYearField = new JTextField(10);
		JLabel startYearPrompt = new JLabel("Enter starting year");
		startingYearPanel.add(startYearPrompt);
		startingYearPanel.add(startingYearField);
		
		

		JPanel endingYearPanel = new JPanel();
		endingYearPanel.setSize(new Dimension(300,600));
		JTextField endingYearField = new JTextField(10);
		JLabel endYearPrompt = new JLabel("Enter ending year");
		endingYearPanel.add(endYearPrompt);
		endingYearPanel.add(endingYearField);
		
		yearMenuPanel.add(startingYearPanel);
		yearMenuPanel.add(endingYearPanel);
		
		

		UI_menu.add(yearMenuPanel);
		
		
		JPanel countryMenuPanel = new JPanel();
		countryMenuPanel.setSize(new Dimension(300,600));
		countryMenuPanel.setLayout(new BoxLayout(countryMenuPanel, BoxLayout.Y_AXIS));
		JLabel countryPrompt = new JLabel("Select countries to graph ");
		for(int index = 0; index < allCountries.size(); index++){
			CountryMenuItem newItem = new CountryMenuItem(allCountries.getNodeAtIndex(index).getData().getName(),false);
			newItem.addItemListener(this);
			countryMenuPanel.add(newItem);
		}
		
		JScrollPane Scroller = new JScrollPane(countryMenuPanel);
		Scroller.setPreferredSize(new Dimension(300, 500));
		Scroller.add(countryPrompt);
		UI_menu.add(Scroller, BorderLayout.WEST);

		JButton graphButton = new JButton("Graph");
		graphButton.setPreferredSize(new Dimension(20, 25));
		graphButton.addActionListener(this);
		yearMenuPanel.add(graphButton);

		UI_menu.setVisible(true);

		minYear = 1960;
		maxYear = 2012;
		
		
		
	} //END OF CREATE GUI METHOD
		
		public void itemStateChanged(ItemEvent evt) {
			if(evt.getSource() instanceof CountryMenuItem){
				CountryMenuItem selectedItem = (CountryMenuItem)evt.getSource();
				 	selectedItem.setSelected(true);				    
				    if(selectedItem.isSelected()==true){
				   this.checkedCountries.add(new Country(selectedItem.getName()));
				    
				}
				    Country selectedCountry;
				   Iterator<Country> c_iterator = checkedCountries.iterator();
				    
				    while(c_iterator)
				    {
				    	selectedCountry = c_iterator.next();
				    	
				    	Country foundCountry = this.allCountries.contains(selectedCountry);						
						this.graphViewCountries.add(foundCountry);
					}				    
			}			
		}


	public void initializeGraphView(){
		// Creates and Initializes GraphView and LegendPanel
		int FRAME_WIDTH = 800;
		int FRAME_HEIGHT = 600;
		JFrame frame = new JFrame("Cellular Graph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Sets the layout for the frame
		FlowLayout layout = new FlowLayout();
		frame.setLayout(layout);

		int graph_panel_size = 600;

		// Creates an object of type GraphView and adds a label
		GraphView myPlots = new GraphView(graph_panel_size, FRAME_HEIGHT, this.graphViewCountries);
		myPlots.setPreferredSize(new Dimension(592, FRAME_HEIGHT)); // 400
		myPlots.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel graphLabel = new JLabel("Graph");
		myPlots.add(graphLabel);

		//Creates scrollbars for GraphView
		JScrollPane graphScroller = new JScrollPane(myPlots, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		graphScroller.setPreferredSize(new Dimension(580, FRAME_HEIGHT - 30));
		myPlots.setAutoscrolls(true);

		//adds to frame
		frame.add(graphScroller);
		graphScroller.setVisible(true);
		
		//Creates a legend panel with legend keys and adds a label
		LegendPanel graphKey = new LegendPanel(200, 600, Color.white, myPlots);
		graphKey.setLayout(new BorderLayout());
		graphKey.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel legendLabel = new JLabel("Legend Key");
		graphKey.add(legendLabel, BorderLayout.NORTH);

		// Creates scrollbars for the legend panel.
		graphKey.setPreferredSize(new Dimension(148, FRAME_HEIGHT));
		JScrollPane legendScroller = new JScrollPane(graphKey, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		legendScroller.setPreferredSize(new Dimension(148, FRAME_HEIGHT - 60));
		graphKey.setAutoscrolls(true);

		// Adds to frame
		frame.add(legendScroller);
		legendScroller.setVisible(true);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
		}
	//END OF GRAPHVIEW METHOD


	@Override
	public void actionPerformed(ActionEvent evt) {
	 if(evt.getSource() instanceof JButton){
		 initializeGraphView(); 
		}
	}
	
	
	
} //END OF TEST CLASS
       
