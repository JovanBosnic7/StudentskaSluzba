package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DijalogZaDodavanjeProfesora;
import komponente.MainFrame;
import komponente.TabelaProfesora;

public class IzmenaProfesoraListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = TabelaProfesora.getInstance().getSelectedRow();
		DijalogZaDodavanjeProfesora dijalogProfesor = new DijalogZaDodavanjeProfesora(row);
		dijalogProfesor.setLocationRelativeTo(MainFrame.getInstance());
		if(row >= 0)
			dijalogProfesor.setVisible(true);
	}

}
