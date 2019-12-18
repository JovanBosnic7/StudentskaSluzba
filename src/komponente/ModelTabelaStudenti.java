package komponente;
import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

public class ModelTabelaStudenti extends AbstractTableModel{

	private static final long serialVersionUID = 6085500274625417159L;

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudenata.getInstance().getVrednostPolja(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column){
		return BazaStudenata.getInstance().getImeKolone(column);
	}
	
}
