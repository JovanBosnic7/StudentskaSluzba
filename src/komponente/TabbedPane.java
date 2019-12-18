package komponente;

import javax.swing.*;

public class TabbedPane extends JTabbedPane {

	
	private static final long serialVersionUID = -6641767877803421613L;

	private PanelSaTabelama panelSaTabelomStudent;
	private PanelSaTabelama panelSaTabelomPredmet;
	private PanelSaTabelama panelSaTabelomProfesor;
	private TabelaStudenata tabelaStudenata;
	private TabelaProfesora tabelaProfesora;
	private TabelaPredmeta tabelaPredmeta;
	
	public TabbedPane() {
		tabelaStudenata = new TabelaStudenata();
		JScrollPane studenti = new JScrollPane(tabelaStudenata);
		
		tabelaProfesora = new TabelaProfesora();
		JScrollPane profesori = new JScrollPane(tabelaProfesora);
		
		tabelaPredmeta=new TabelaPredmeta();
		JScrollPane predmeti= new JScrollPane(tabelaPredmeta);
		
		panelSaTabelomStudent=new PanelSaTabelama(studenti,100);
		panelSaTabelomProfesor=new PanelSaTabelama(profesori,100);
		panelSaTabelomPredmet=new PanelSaTabelama(predmeti,100);
		
		
		addTab("Studenti", new ImageIcon("slike/studenti_pane.png"), panelSaTabelomStudent, "");
		addTab("Profesori", new ImageIcon("slike/profesori_pane.png"), panelSaTabelomProfesor, "");
		addTab("Predmeti", new ImageIcon("slike/predmeti_pane.png"), panelSaTabelomPredmet, "");
		

	}
}
