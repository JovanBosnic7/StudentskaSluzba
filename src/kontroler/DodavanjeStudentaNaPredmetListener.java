package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DodavanjeStudentaNaPredmetDijalog;
import komponente.MainFrame;
import komponente.TabelaPredmeta;

public class DodavanjeStudentaNaPredmetListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = TabelaPredmeta.getInstance().getSelectedRow();
		DodavanjeStudentaNaPredmetDijalog dijalog = new DodavanjeStudentaNaPredmetDijalog(row);
		dijalog.setLocationRelativeTo(MainFrame.getInstance());
		
		if(row >= 0)
			dijalog.setVisible(true);
		
	}

}
