package komponente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import kontroler.*;
import model.BazaPodataka;


public class MainFrame extends JFrame {

	
	private static final long serialVersionUID = 8475781865375555499L;
	private ToolBar toolbar= ToolBar.getInstance();
	private static MainFrame instance=null;
	private TabbedPane tabbedPane;
	private MenuBar menubar;
	//ovo je za singlton klasu 
	public static MainFrame getInstance() {
		if(instance==null) {
			instance=new MainFrame();
		}
		return instance;
	}
	
	public MainFrame() {
		BazaPodataka baza = new BazaPodataka();
		baza.LoadFromFile();
		setLayout(new BorderLayout());
	//	toolbar= ToolBar.getInstance();
		menubar = new MenuBar();
		this.setJMenuBar(menubar);
		add(toolbar, BorderLayout.NORTH);
		
		tabbedPane= TabbedPane.getInstance();
		tabbedPane.addChangeListener(new TabbedPaneListener());
		add(tabbedPane,BorderLayout.CENTER);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize( 3* screenDimension.width / 4, 3* screenDimension.height / 4);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Studentska služba");
		setResizable(false);
		setLocation(screenDimension.width/2 - getWidth()/2, screenDimension.height/2 -getHeight()/2);
		
		add(new StatusBar(), BorderLayout.SOUTH);
		
		addWindowListener(new MainFrameListener());
		
		setVisible(true);


	}
	
}
