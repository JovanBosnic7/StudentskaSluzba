package komponente;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.table.TableRowSorter;

public class ScrollPaneStudenti extends JScrollPane {

	private static final long serialVersionUID = 3920000178082639634L;
	private TableRowSorter<ModelTabelaStudenti> sorter;
	
	public ScrollPaneStudenti(Component comp) {
		super(comp);
		ModelTabelaStudenti model = new ModelTabelaStudenti();
	    sorter = new TableRowSorter<ModelTabelaStudenti>(model);
	    TabelaStudenata tabela = TabelaStudenata.getInstance();
	    tabela.setRowSorter(sorter);
	}
	
}
