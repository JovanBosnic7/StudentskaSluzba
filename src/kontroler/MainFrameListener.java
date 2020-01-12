package kontroler;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

import model.BazaPodataka;


public class MainFrameListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		JFrame frame= (JFrame) e.getComponent();
		int biranje= JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da \u017Eelite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
				JOptionPane.YES_NO_OPTION);
		if(biranje==JOptionPane.YES_OPTION) {
			BazaPodataka bp = new BazaPodataka();
			bp.saveToFile();
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		} else 
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
