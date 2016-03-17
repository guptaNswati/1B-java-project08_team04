import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.JCheckBoxMenuItem;

/**
 * One item of class CountryMenuItem contains the name of a country and a boolean variable
 * that determines the state of the  CountryMenuItem
 * @author Shiva
 */

public class CountryMenuItem extends JCheckBoxMenuItem {
	private String name;
	private boolean isSelected = false;
	
	/**
	 * Constructs a new countryMenuItem with name of country
	 * and default state that is false.
	 * @param name  	  name of country
	 * @param isSelected  default state of Checkbox
	 */
	public CountryMenuItem(String name, boolean isSelected){
		super(name, isSelected);
		this.setName(name);
		this.setSelected(isSelected);
	}
	
	/**
	 * Returns the selected state of the CountryMenuItem
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * Sets the state of the countryMenuItem
	 */
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	/**
	 * String representation of 
	 * the name of the country
	 */
	public String toString() {
		return name;
	}

	/**
	 * Returns the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of countryMenuItem
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}



 