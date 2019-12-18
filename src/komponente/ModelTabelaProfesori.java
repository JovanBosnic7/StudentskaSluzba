package komponente;

import java.util.ArrayList;

	import javax.swing.table.AbstractTableModel;

	import model.BazaProfesora;
	import model.Profesor;

	public class ModelTabelaProfesori extends AbstractTableModel{

		private static final long serialVersionUID = 667674068684849863L;
		private ArrayList<Profesor> dodatiProfesori=new ArrayList<Profesor>();
		@Override
		public int getRowCount() {
			return BazaProfesora.getInstance().getProfesori().size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return BazaProfesora.getInstance().getKolone();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		}
		
		@Override
		public String getColumnName(int column){
			return BazaProfesora.getInstance().getImeKolone(column);
		}
		public void  dodajProfesore() {
			
		}

	}


