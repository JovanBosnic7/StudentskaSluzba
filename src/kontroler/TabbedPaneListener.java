package kontroler;

import javax.swing.event.*;

import komponente.*;

public class TabbedPaneListener  implements ChangeListener{
	@Override
	//listener koji prati na kojoj sam kartici i kakav ce toolbar iscrtati u zavisnosti od toga na kojoj sam kartici
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		TabbedPane tabbedPane=(TabbedPane) e.getSource(); // kastovanje
		ToolBar toolBar=ToolBar.getInstance();
		toolBar.iscrtajNaEkran(Tip.getTip(tabbedPane.getSelectedIndex()));
		
	}
}
