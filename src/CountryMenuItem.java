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
	
	
	public CountryMenuItem(String name, boolean isSelected){
		super(name,isSelected);
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
	
}



 