import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class YearMenu extends JPanel implements ItemListener{
	
	private JComboBox <Integer> year_menu = new JComboBox<>();
	private int selectedYear = 0;
	
	public YearMenu(int width, int height, int [] years){
		this.setSize(width, height);
		for(int index = 0; index < years.length; index++){
			year_menu.addItem(years[index]);
		}
		this.add(year_menu);
		year_menu.setSelectedIndex(0);
		year_menu.addItemListener(this);
	}

	public int getSelectedYear(){
		return selectedYear;
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		if(evt.getStateChange()==ItemEvent.SELECTED);
		selectedYear = (Integer)year_menu.getSelectedItem();
		
	}

}
