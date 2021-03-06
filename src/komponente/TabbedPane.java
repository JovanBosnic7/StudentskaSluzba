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
	
	private static TabbedPane instance;
	
	public static TabbedPane getInstance() {
		if(instance == null)
			instance = new TabbedPane();
		return instance;
	}
	
	private TabbedPane() {
		tabelaStudenata =  TabelaStudenata.getInstance();
		ScrollPaneStudenti studenti = ScrollPaneStudenti.getInstance();
		
		tabelaProfesora = TabelaProfesora.getInstance();
		ScrollPaneProfesori profesori =ScrollPaneProfesori.getInstance();
		
		tabelaPredmeta=TabelaPredmeta.getInstance();
		ScrollPanePredmeti predmeti= ScrollPanePredmeti.getInstance();
		
		panelSaTabelomStudent=new PanelSaTabelama(studenti,100);
		panelSaTabelomProfesor=new PanelSaTabelama(profesori,100);
		panelSaTabelomPredmet=new PanelSaTabelama(predmeti,100);
		
		
		addTab("Studenti", new ImageIcon("slike/studenti_pane.png"), panelSaTabelomStudent, "");
		addTab("Profesori", new ImageIcon("slike/profesori_pane.png"), panelSaTabelomProfesor, "");
		addTab("Predmeti", new ImageIcon("slike/predmeti_pane.png"), panelSaTabelomPredmet, "");
		

	}
	
	public void azurirajPrikaz() {
		ModelTabelaStudenti model = (ModelTabelaStudenti) tabelaStudenata.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public void azurirajPrikzazPredmeta() {
		ModelTabelaPredmeti model = (ModelTabelaPredmeti) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazProfesora() {
		ModelTabelaProfesori model = (ModelTabelaProfesori) tabelaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
