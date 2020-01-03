package komponente;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ScrollPaneStudenti extends JScrollPane {

	private static final long serialVersionUID = 3920000178082639634L;
	private TableRowSorter<ModelTabelaStudenti> sorter;
	private ArrayList<RowFilter<ModelTabelaStudenti, Object>> filteri;
	private static ScrollPaneStudenti instance = null;
	
	public static ScrollPaneStudenti getInstance() {
		if(instance == null)
			instance = new ScrollPaneStudenti(TabelaStudenata.getInstance());
		return instance;
	}
	
	private ScrollPaneStudenti(TabelaStudenata tabela) {
		super(tabela);
		ModelTabelaStudenti model = new ModelTabelaStudenti();
	    sorter = new TableRowSorter<ModelTabelaStudenti>(model);
	    tabela.setRowSorter(sorter);
	    filteri = new ArrayList<RowFilter<ModelTabelaStudenti,Object>>();
	}
	
	public void pretrazi(String pretraga) {
		filteri.clear();
		String[] delovi = pretraga.split(";");
		for(int i = 0; i < delovi.length; i++) {
			String[] parametriPretrage = delovi[i].split(":");
			if(parametriPretrage.length < 2) {
				filteri.clear();
				break;
			}
			else {
				if(parametriPretrage[0].equalsIgnoreCase("ime"))
					pretragaIme(parametriPretrage[1]);
				else if(parametriPretrage[0].equalsIgnoreCase("prezime"))
					pretragaPrezime(parametriPretrage[1]);
				else if(parametriPretrage[0].equalsIgnoreCase("indeks"))
					pretragaIndeks(parametriPretrage[1]);
				else {
					filteri.clear();
					break;
				}
			}
		}
		sorter.setRowFilter(RowFilter.andFilter(filteri));
	}
	
	private void pretragaIme(String ime) {
		RowFilter<ModelTabelaStudenti, Object> rf = null;
		try {
          rf = RowFilter.regexFilter(ime);
      } catch (java.util.regex.PatternSyntaxException e) {
          return;
      }
		filteri.add(rf);
	}
	
	private void pretragaPrezime(String prezime) {
		RowFilter<ModelTabelaStudenti, Object> rf = null;
		try {
          rf = RowFilter.regexFilter(prezime);
      } catch (java.util.regex.PatternSyntaxException e) {
          return;
      }
		filteri.add(rf);
	}
	private void pretragaIndeks(String indeks) {
		RowFilter<ModelTabelaStudenti, Object> rf = null;
		try {
          rf = RowFilter.regexFilter(indeks);
      } catch (java.util.regex.PatternSyntaxException e) {
          return;
      }
		filteri.add(rf);
	}
}
