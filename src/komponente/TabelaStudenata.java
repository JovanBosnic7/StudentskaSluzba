package komponente;

import javax.swing.*;

public class TabelaStudenata extends JTable {

	private static final long serialVersionUID = 3921753356544022327L;
	
	public TabelaStudenata() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ModelTabelaStudenti());
	}
}