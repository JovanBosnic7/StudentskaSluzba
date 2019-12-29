package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DijalogZaBrisanjeProfesora;
import komponente.MainFrame;
import komponente.TabelaProfesora;

public class BrisanjeProfesoraListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = TabelaProfesora.getInstance().getSelectedRow();
		DijalogZaBrisanjeProfesora dijalogBrisanjeProfesora = new DijalogZaBrisanjeProfesora(row);
		dijalogBrisanjeProfesora.setLocationRelativeTo(MainFrame.getInstance());
		if(row >=0)
			dijalogBrisanjeProfesora.setVisible(true);
	}
	
	

}
