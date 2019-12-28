package kontroler;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import komponente.DijalogZaDodavanjePredmeta;
import komponente.MainFrame;
import komponente.TabelaPredmeta;

public class IzmenaPredmetaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int red = TabelaPredmeta.getInstance().getSelectedRow();
		DijalogZaDodavanjePredmeta dijalogPredmet = new DijalogZaDodavanjePredmeta(1, red);
		dijalogPredmet.setLocationRelativeTo(MainFrame.getInstance());
		if(red >=0) 
			dijalogPredmet.setVisible(true);
	}

}
