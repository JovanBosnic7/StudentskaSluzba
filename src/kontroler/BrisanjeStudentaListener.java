package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.BrisanjeStudentaDijalog;
import komponente.MainFrame;
import komponente.TabelaStudenata;

public class BrisanjeStudentaListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = TabelaStudenata.getInstance().getSelectedRow();
		BrisanjeStudentaDijalog dijalogBrisanjeStudenta = new BrisanjeStudentaDijalog(row);
		dijalogBrisanjeStudenta.setLocationRelativeTo(MainFrame.getInstance());
		if(row>=0)
			dijalogBrisanjeStudenta.setVisible(true);
		
	}

}
