package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DijalogZaDodavanjeProfesora;
import komponente.MainFrame;

public class DodavanjeProfesoraListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DijalogZaDodavanjeProfesora dijalogProfesor=new DijalogZaDodavanjeProfesora();
		dijalogProfesor.setLocationRelativeTo(MainFrame.getInstance());
		dijalogProfesor.setVisible(true);
	}
	
}
