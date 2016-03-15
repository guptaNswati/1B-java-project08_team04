import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;

/**
 * One item of class CountryMenuItem contains the name of a country and a boolean variable
 * that determines the state of the  CountryMenuItem
 * @author Shivaa
 *
 */

public class CountryMenuItem extends JCheckBoxMenuItem implements ItemListener{
	private String name;
	private boolean isSelected;
	private JCheckBoxMenuItem countryItem;
	private String selectedItem;
	private LinkedList<String>selectedCountries = new LinkedList<String>();
	
	public CountryMenuItem(String name, boolean isSelected){
		this.name = name;
		this.setSelected(false);
		this.countryItem = new JCheckBoxMenuItem(name,isSelected);
		this.add(countryItem);
		
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSelectedCountryName(){
		if(countryItem.isSelected()==true){
			selectedItem = countryItem.getName();
		}
		return selectedItem;
	}
	
	@Override
	public void itemStateChanged(ItemEvent evt) {
		if(evt.getStateChange() == ItemEvent.SELECTED){
			String selectedItem = (String)evt.getSource();
			System.out.println(selectedItem);
		}
		
	}

	public JCheckBoxMenuItem getCountryItem() {
		return countryItem;
	}
}



 