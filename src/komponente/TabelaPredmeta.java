package komponente;

import javax.swing.JTable; 
import javax.swing.ListSelectionModel;


public class TabelaPredmeta extends JTable {
	

	private static TabelaPredmeta instance=null;
	
	public static TabelaPredmeta getInstance() {
		if(instance==null) {
			instance= new TabelaPredmeta();
		}
		return instance;
	}
	private static final long serialVersionUID = -4975453440056641604L;

	public TabelaPredmeta(){
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(new ModelTabelaPredmeti());
		new ButtonColumnPredmeti(this, 5);
		new ButtonColumnProfesorPredmeti(this, 4);
	}

}