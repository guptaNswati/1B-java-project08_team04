import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
/**
 * One object of class YearMenu creates a drop down menu of years.
 * @author Shiva
 *
 */
public class YearMenu extends JPanel implements ItemListener{
	
	private JComboBox <Integer> year_menu;
	private int selectedYear;
	
	public YearMenu(int width, int height, int [] years){
		this.setSize(width, height);
		this.year_menu =  new JComboBox<>();
		for(int index = 0; index < years.length; index++){
			year_menu.addItem(years[index]);
		}
		this.add(year_menu);
		year_menu.addItemListener(this); 
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()==ItemEvent.SELECTED){
			selectedYear = (Integer) year_menu.getSelectedItem();
		}
		System.out.println(selectedYear);
		
	}
	
	public int getSelectedYear(){
		return selectedYear;
	}

}
