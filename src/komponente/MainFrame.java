package komponente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;


public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ToolBar toolbar;

	public MainFrame() {

		setLayout(new BorderLayout());

		toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize( 3* screenDimension.width / 4, 3* screenDimension.height / 4);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Studentska služba");
		setResizable(false);
		setVisible(true);
		setLocation(screenDimension.width/2 - getWidth()/2, screenDimension.height/2 -getHeight()/2);
	

	}
	
}
