package komponente;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class ModelTabelaPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2452213233524811171L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getKolone();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column){
		return BazaPredmeta.getInstance().getImeKolone(column);
	}


}
