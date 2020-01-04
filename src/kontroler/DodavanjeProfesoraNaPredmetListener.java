package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DijalogZaDodavanjeProfesoraNaPredmet;
import komponente.MainFrame;
import komponente.TabelaPredmeta;

public class DodavanjeProfesoraNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = TabelaPredmeta.getInstance().getSelectedRow();
		DijalogZaDodavanjeProfesoraNaPredmet dijalog = new DijalogZaDodavanjeProfesoraNaPredmet(row);
		dijalog.setLocationRelativeTo(MainFrame.getInstance());
		
		if(row >=0)
			dijalog.setVisible(true);
	}

}
