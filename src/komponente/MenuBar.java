package komponente;

import javax.swing.*;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = -5149647733879041189L;
	private static MenuBar instance = null;
	public static MenuBar getInstance() {
		if(instance == null)
			instance = new MenuBar();
		return instance;
	}
	
	private MenuBar() {
	JMenu menuFile = new JMenu("File");
	JMenuItem itemNew = new JMenuItem("New");
	JMenuItem itemClose = new JMenuItem("Close");
	menuFile.add(itemNew);
	menuFile.addSeparator();
	menuFile.add(itemClose);
	JMenu menuEdit = new JMenu("Edit");
	JMenuItem itemEdit = new JMenuItem("Edit");
	JMenuItem itemDelete = new JMenuItem("Delete");
	menuEdit.add(itemEdit);
	menuEdit.addSeparator();
	menuEdit.add(itemDelete);
	JMenu menuHelp = new JMenu("Help");
	JMenuItem itemHelp = new JMenuItem("Help");
	JMenuItem itemAbout = new JMenuItem("About");
	menuHelp.add(itemHelp);
	menuHelp.add(itemAbout);
	add(menuFile);
	add(menuEdit);
	add(menuHelp);
	}
}
