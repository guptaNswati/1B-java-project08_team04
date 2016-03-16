package project08_team04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TestUI {

    public static void main(String[] args){
        
        //Reads data from CSV file and parses it
        final String FILENAME = "resources/cellular.csv";   
        CSVReader parser = new CSVReader(FILENAME);
        String [] countryNames = parser.getCountryNames();
        int [] yearLabels = parser.getYearLabels();
        double [][] parsedTable = parser.getParsedTable(); 
        
        

       //creates the main frame
        JFrame UI_menu = new JFrame();
        UI_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI_menu.setTitle("Graph Settings");
        UI_menu.setLayout(new BorderLayout());
        UI_menu.setSize(600,600);
     
        JPanel yearMenu_panel = new JPanel();
        yearMenu_panel.setLayout(new BoxLayout(yearMenu_panel, BoxLayout.Y_AXIS));
        yearMenu_panel.setSize(new Dimension(300,600));
 
        JLabel textLabel = new JLabel("Give the starting year and ending Year");
        yearMenu_panel.add(textLabel);
        
        YearMenu yearField = new YearMenu();
       
        yearMenu_panel.add(yearField);

        UI_menu.add(yearMenu_panel); 
      
        JPanel countryMenu_panel = new JPanel();
        countryMenu_panel.setLayout(new BoxLayout(countryMenu_panel, BoxLayout.Y_AXIS));
        countryMenu_panel.setSize(new Dimension(300,600));
        
        JLabel promptLabel = new JLabel("Select countries to graph");
        countryMenu_panel.add(promptLabel);
        
        for(int index = 0; index < countryNames.length; index++){
            CountryMenuItem item = new CountryMenuItem(countryNames[index],false);
            countryMenu_panel.add(item);
        }
        
    
       JScrollPane Scroller = new JScrollPane(countryMenu_panel);
       Scroller.setPreferredSize(new Dimension(300,500));
        UI_menu.add(Scroller, BorderLayout.WEST);
        
        
/**        JPanel countryMenu_Panel = new JPanel();
        countryMenu_Panel.setSize(200,600);
        for(int index = 0; index < countryNames.length; index++){
            CountryItem newItem = new CountryItem(countryNames[index]);
            countryMenu_Panel.add(newItem);
        }
        
        UI_menu.add(countryMenu_Panel);
        
   
//        CountryMenu countryList = new CountryMenu(countryNames);
//        leftPanel.add(countryList);
//        UI_menu.add(leftPanel, BorderLayout.WEST);
//creates a panel for year menu
//        JPanel yearPanel = new JPanel();
//        YearMenu startYear_menu = new YearMenu(300,600,yearLabels);
//        JLabel prompt1 = new JLabel("Select Starting Year");
//        startYear_menu.add(prompt1);
//        yearPanel.add(startYear_menu, BorderLayout.NORTH);    
    */ 
        UI_menu.setVisible(true);
    }
    
}