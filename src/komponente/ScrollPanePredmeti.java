package komponente;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.table.TableRowSorter;

public class ScrollPanePredmeti extends JScrollPane {

	
	private static final long serialVersionUID = 3842121667197769438L;
	private TableRowSorter<ModelTabelaPredmeti> sorter;
	
	public ScrollPanePredmeti(Component comp) {
		super(comp);
		ModelTabelaPredmeti model = new ModelTabelaPredmeti();
	    sorter = new TableRowSorter<ModelTabelaPredmeti>(model);
	    TabelaPredmeta tabela = TabelaPredmeta.getInstance();
	    tabela.setRowSorter(sorter);
	}
	
}
