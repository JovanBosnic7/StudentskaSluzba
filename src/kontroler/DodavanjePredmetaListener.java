package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DijalogZaDodavanjePredmeta;
import komponente.MainFrame;

public class DodavanjePredmetaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DijalogZaDodavanjePredmeta dijalogPredmet=new DijalogZaDodavanjePredmeta();
		dijalogPredmet.setLocationRelativeTo(MainFrame.getInstance());
		dijalogPredmet.setVisible(true);
		
	}

}
