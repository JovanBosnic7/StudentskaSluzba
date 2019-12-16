package komponente;

import javax.swing.*;

public class TabbedPane extends JTabbedPane {

	
	private static final long serialVersionUID = -6641767877803421613L;

	public TabbedPane() {
		addTab("Studenti", new ImageIcon("slike/studenti_pane.png"), null, "");
		addTab("Profesori", new ImageIcon("slike/profesori_pane.png"), null, "");
		addTab("Predmeti", new ImageIcon("slike/predmeti_pane.png"), null, "");
		

	}
}
