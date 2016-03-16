import javax.swing.*;
import java.awt.event.*;

public class CountryMenu extends JPanel implements ItemListener 
{
	LinkedList<String>checkedCountries = new LinkedList<String>();
	JPanel countryPanel;
	
   public CountryMenu(int width, int height, LinkedList<Country>countries) {
      this.countryPanel = new JPanel();
      countryPanel.setLayout(new BoxLayout(countryPanel, BoxLayout.Y_AXIS));
      countryPanel.setSize(width,height);
      for(int index = 0; index < countries.size(); index++){
    	  CountryMenuItem newItem = new CountryMenuItem(countries.getNodeAtIndex(index).getData().getName(),false);
    	  countryPanel.add(newItem);
    	  this.add(countryPanel);
      }
   }

public LinkedList<String> getCheckedCountries(){
	return checkedCountries;
}

@Override
public void itemStateChanged(ItemEvent evt) {
	if(evt.getSource() instanceof CountryMenuItem){
		CountryMenuItem selectedItem = (CountryMenuItem)evt.getSource();
		    selectedItem.setSelected(true);
		     if(selectedItem.isSelected()==true){
		    	 checkedCountries.add(selectedItem.getName());
		      	}
		    }
		} 
	
}

  

