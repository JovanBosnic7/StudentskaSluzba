package komponente;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.table.TableRowSorter;

public class ScrollPaneProfesori extends JScrollPane {

	private static final long serialVersionUID = 3920000178082639634L;
	private TableRowSorter<ModelTabelaProfesori> sorter;
	
	public ScrollPaneProfesori(Component comp) {
		super(comp);
		ModelTabelaProfesori model = new ModelTabelaProfesori();
	    sorter = new TableRowSorter<ModelTabelaProfesori>(model);
	    TabelaProfesora tabela = TabelaProfesora.getInstance();
	    tabela.setRowSorter(sorter);
	}
	
}
