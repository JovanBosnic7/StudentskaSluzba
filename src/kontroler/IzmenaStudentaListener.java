package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DodavanjeStudentaDijalog;
import komponente.MainFrame;
import komponente.TabelaStudenata;

public class IzmenaStudentaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = TabelaStudenata.getInstance().getSelectedRow();
		DodavanjeStudentaDijalog dijalogStudent=new DodavanjeStudentaDijalog(1, row);
		dijalogStudent.setLocationRelativeTo(MainFrame.getInstance());
		if(row >= 0)
			dijalogStudent.setVisible(true);
		
	}

}
