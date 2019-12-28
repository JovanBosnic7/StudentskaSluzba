package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DijalogZaBrisanjePredmeta;
import komponente.MainFrame;
import komponente.TabelaPredmeta;

public class BrisanjePredmetaListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = TabelaPredmeta.getInstance().getSelectedRow();
		DijalogZaBrisanjePredmeta dijalogBrisanjePredmet=new DijalogZaBrisanjePredmeta(row);
		dijalogBrisanjePredmet.setLocationRelativeTo(MainFrame.getInstance());
		if(row >= 0)
		dijalogBrisanjePredmet.setVisible(true);
		
	}

}
