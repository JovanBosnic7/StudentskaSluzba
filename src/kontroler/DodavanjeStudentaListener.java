package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DodavanjeStudentaDijalog;
import komponente.MainFrame;

public class DodavanjeStudentaListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		DodavanjeStudentaDijalog dijalogStudent=new DodavanjeStudentaDijalog();
		dijalogStudent.setLocationRelativeTo(MainFrame.getInstance());
		dijalogStudent.setVisible(true);
		
	}

}
