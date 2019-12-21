package kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import komponente.DijalogZaBrisanjePredmeta;
import komponente.MainFrame;

public class BrisanjePredmetaListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		DijalogZaBrisanjePredmeta dijalogBrisanjePredmet=new DijalogZaBrisanjePredmeta();
		dijalogBrisanjePredmet.setLocationRelativeTo(MainFrame.getInstance());
		dijalogBrisanjePredmet.setVisible(true);
		
	}

}
