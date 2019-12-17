package komponente;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

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
	
	itemNew.setPreferredSize(new Dimension(200, 25));
	itemNew.setIcon(new ImageIcon("slike/plus.png"));
	itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
	itemNew.setMnemonic(KeyEvent.VK_N);

	itemClose.setIcon(new ImageIcon("slike/x.png"));
	itemClose.setPreferredSize(new Dimension(200, 25));
	itemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
	itemClose.setMnemonic(KeyEvent.VK_C);
	
	menuFile.add(itemNew);
	menuFile.addSeparator();
	menuFile.add(itemClose);
	
	JMenu menuEdit = new JMenu("Edit");
	JMenuItem itemEdit = new JMenuItem("Edit");
	JMenuItem itemDelete = new JMenuItem("Delete");
	
	itemEdit.setPreferredSize(new Dimension(200, 25));
	itemEdit.setIcon(new ImageIcon("slike/edit.png"));
	itemEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
	itemEdit.setMnemonic(KeyEvent.VK_E);
	
	itemDelete.setPreferredSize(new Dimension(200, 25));
	itemDelete.setIcon(new ImageIcon("slike/delete.png"));
	itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
	itemDelete.setMnemonic(KeyEvent.VK_D);
	
	menuEdit.add(itemEdit);
	menuEdit.addSeparator();
	menuEdit.add(itemDelete);
	
	JMenu menuHelp = new JMenu("Help");
	JMenuItem itemHelp = new JMenuItem("Help");
	JMenuItem itemAbout = new JMenuItem("About");
	
	itemHelp.setPreferredSize(new Dimension(200, 25));
	itemHelp.setIcon(new ImageIcon("slike/help.png"));
	itemHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
	itemHelp.setMnemonic(KeyEvent.VK_H);
	
	itemAbout.setPreferredSize(new Dimension(200, 25));
	itemAbout.setIcon(new ImageIcon("slike/about.png"));
	itemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
	itemAbout.setMnemonic(KeyEvent.VK_A);
	
	menuHelp.add(itemHelp);
	menuHelp.add(itemAbout);
	
	add(menuFile);
	add(menuEdit);
	add(menuHelp);
	}
}
