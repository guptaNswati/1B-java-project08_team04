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
/**
 * Tests the User Interface by creating objects of type GraphView,
 * LegendPanel, and countryMenuItem.
 * @author Team04
 */

public class TestUI implements ActionListener, ItemListener {

	LinkedList<Country> graphViewCountries = new LinkedList<Country>();
	LinkedList<Country> allCountries = new LinkedList<Country>();

	/**
	 * Reads from CSV file and parses the data
	 * @param args
	 */
	public static void main(String[] args) {

		// Reads data from CSV file and parses it
		final String FILENAME = "resources/cellular.csv";
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

	}

	/**
	 * Creates a LinkedList of Countries
	 * 
	 * @param countries
	 *            Array of country Objects
	 */
	public void buildCountryList(Country[] countries) {
		for (int index = 0; index < countries.length; index++) {
			this.allCountries.add(countries[index]);
		}

	}

	/**
	 * Creates a UI panel that displays a scrollable list of Checkboxes with
	 * countryNames and a graph button that redirects the user to the GraphView
	 * Panel
	 */
	public void createUI() {
		JFrame UI_menu = new JFrame();
		UI_menu.setTitle("Graph Settings");
		UI_menu.setLayout(new BorderLayout());
		UI_menu.setSize(400, 600);

		JPanel countryMenuPanel = new JPanel();
		countryMenuPanel.setSize(new Dimension(300, 500));
		countryMenuPanel.setLayout(new BoxLayout(countryMenuPanel, BoxLayout.Y_AXIS));
		JLabel countryPrompt = new JLabel("Select countries, then click the graph button");
		countryMenuPanel.add(countryPrompt);
		for (int index = 0; index < allCountries.size(); index++) {
			CountryMenuItem newItem = new CountryMenuItem(allCountries.getNodeAtIndex(index).getData().getName(),
					false);
			newItem.addItemListener(this);
			countryMenuPanel.add(newItem);
		}

		JButton graphButton = new JButton("Graph");
		graphButton.setPreferredSize(new Dimension(20, 25));
		graphButton.addActionListener(this);

		countryMenuPanel.add(graphButton);
		JScrollPane Scroller = new JScrollPane(countryMenuPanel);
		Scroller.setPreferredSize(new Dimension(300, 500));
		UI_menu.add(Scroller);

		UI_menu.setVisible(true);

	}

	/**
	 * Invoked when an item is selected by the user. Gets the selected item and
	 * adds it to a new LinkedList of country objects
	 */

	public void itemStateChanged(ItemEvent evt) {
		if (evt.getSource() instanceof CountryMenuItem) {
			CountryMenuItem selectedItem = (CountryMenuItem) evt.getSource();
			selectedItem.setSelected(true);

			if (selectedItem.isSelected() == true) {
				Country tempCountry = new Country(selectedItem.getName());
				this.graphViewCountries.add(this.allCountries.contains(tempCountry));
			}
		}
	}

	/**
	 * Creates the GraphView and LegendPanel by creating a frame and adding the
	 * panels to it. GraphView constructor takes a LinkedList of selected
	 * countries as a parameter.
	 */
	public void initializeGraphView() {
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

		// Creates scrollbars for GraphView
		JScrollPane graphScroller = new JScrollPane(myPlots, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		graphScroller.setPreferredSize(new Dimension(580, FRAME_HEIGHT - 30));
		myPlots.setAutoscrolls(true);

		// adds to frame
		frame.add(graphScroller);
		graphScroller.setVisible(true);

		// Creates a legend panel with legend keys and adds a label
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
	

	/**
	 * Invoked when an action occurs. Listens to the JButton, and when pressed,
	 * displays the GraphView and Legend Panel.
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() instanceof JButton) {
			initializeGraphView();
		}
	}
}