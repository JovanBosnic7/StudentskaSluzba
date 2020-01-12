package komponente;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ScrollPanePredmeti extends JScrollPane {

	private static final long serialVersionUID = 3842121667197769438L;
	
	private static ScrollPanePredmeti instance = null;

	public static ScrollPanePredmeti getInstance() {
		if (instance == null)
			instance = new ScrollPanePredmeti(TabelaPredmeta.getInstance());
		return instance;
	}
	private TableRowSorter<ModelTabelaPredmeti> sorter;
	private ArrayList<RowFilter<ModelTabelaPredmeti, Object>> filteri;

	public ScrollPanePredmeti(TabelaPredmeta tabela) {
		super(tabela);
		ModelTabelaPredmeti model = new ModelTabelaPredmeti();
		sorter = new TableRowSorter<ModelTabelaPredmeti>(model);
		sorter.setSortable(4, false);
		sorter.setSortable(5, false);
		tabela.setRowSorter(sorter);
		filteri = new ArrayList<RowFilter<ModelTabelaPredmeti, Object>>();
	}

	public void pretrazi(String pretraga) {
		filteri.clear();
		String[] delovi = pretraga.split(";");
		for (int i = 0; i < delovi.length; i++) {
			String[] parametriPretrage = delovi[i].split(":");
			if (parametriPretrage.length < 2) {
				filteri.clear();
				break;
			} else {
				if (parametriPretrage[0].equalsIgnoreCase("nazivPredmeta"))
					pretragaNaziv(parametriPretrage[1]);
				else if (parametriPretrage[0].equalsIgnoreCase("sifraPredmeta"))
					pretragaSifra(parametriPretrage[1]);

				else {
					filteri.clear();
					break;
				}
			}
		}
		sorter.setRowFilter(RowFilter.andFilter(filteri));
	}

	private void pretragaNaziv(String nazivPredmeta) {
		RowFilter<ModelTabelaPredmeti, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(nazivPredmeta);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		filteri.add(rf);
	}

	private void pretragaSifra(String sifraPredmeta) {
		RowFilter<ModelTabelaPredmeti, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(sifraPredmeta);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		filteri.add(rf);
	}

}
