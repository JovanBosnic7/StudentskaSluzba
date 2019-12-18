package komponente;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaProfesora  extends JTable {

	private static final long serialVersionUID = 3921753356544022327L;
	
	public TabelaProfesora() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ModelTabelaProfesori());
	}
}