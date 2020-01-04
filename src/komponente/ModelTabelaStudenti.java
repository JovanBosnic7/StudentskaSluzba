package komponente;
import javax.swing.JButton;
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
		return BazaStudenata.getInstance().getBrojKolona();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 11;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			return String.class;
		case 11:
			return JButton.class;
		default:
			return null;
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex < 11)
			return BazaStudenata.getInstance().getVrednostPolja(rowIndex, columnIndex);
		else if(columnIndex == 11) {
			JButton dugmePredmeti = new JButton("Predmeti");
			return dugmePredmeti;
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column){
		return BazaStudenata.getInstance().getImeKolone(column);
	}
	
}
