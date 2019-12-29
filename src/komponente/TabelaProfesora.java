package komponente;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaProfesora  extends JTable {

	private static final long serialVersionUID = 3921753356544022327L;
	private static TabelaProfesora instance;
	public static TabelaProfesora getInstance() {
		if(instance==null) {
			instance= new TabelaProfesora();
		}
		return instance;
	}
	private TabelaProfesora() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ModelTabelaProfesori());
	}
}