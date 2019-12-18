package komponente;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaPredmeta extends JTable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4975453440056641604L;

	public TabelaPredmeta(){
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ModelTabelaPredmeti());
	}

}