package komponente;

import javax.swing.*;

public class TabelaStudenata extends JTable {

	private static final long serialVersionUID = 3921753356544022327L;
	private static TabelaStudenata instance;
	public static TabelaStudenata getInstance() {
		if(instance==null) {
			instance= new TabelaStudenata();
		}
		return instance;
	}
	private TabelaStudenata() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ModelTabelaStudenti());
		new ButtonColumnStudenti(this, 11);
	}
}