package komponente;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ScrollPaneProfesori extends JScrollPane {

	private static final long serialVersionUID = 4076538182259882907L;
	private static ScrollPaneProfesori instance = null;

	public static ScrollPaneProfesori getInstance() {
		if (instance == null)
			instance = new ScrollPaneProfesori(TabelaProfesora.getInstance());
		return instance;

	}

	private TableRowSorter<ModelTabelaProfesori> sorter;
	private ArrayList<RowFilter<ModelTabelaProfesori, Object>> filteri;

	private ScrollPaneProfesori(TabelaProfesora tabela) {
		super(tabela);
		ModelTabelaProfesori model = new ModelTabelaProfesori();
		sorter = new TableRowSorter<ModelTabelaProfesori>(model);
		tabela.setRowSorter(sorter);
		filteri = new ArrayList<RowFilter<ModelTabelaProfesori, Object>>();
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
				if (parametriPretrage[0].equalsIgnoreCase("ime"))
					pretragaIme(parametriPretrage[1]);
				else if (parametriPretrage[0].equalsIgnoreCase("prezime"))
					pretragaPrezime(parametriPretrage[1]);
				else if (parametriPretrage[0].equalsIgnoreCase("brLicneKarte"))
					pretragaBrLicneKarte(parametriPretrage[1]);
				else {
					filteri.clear();
					break;
				}
			}
		}
		sorter.setRowFilter(RowFilter.andFilter(filteri));
	}

	private void pretragaIme(String ime) {
		RowFilter<ModelTabelaProfesori, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(ime);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		filteri.add(rf);
	}

	private void pretragaPrezime(String prezime) {
		RowFilter<ModelTabelaProfesori, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(prezime);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		filteri.add(rf);
	}

	private void pretragaBrLicneKarte(String brLicneKarte) {
		RowFilter<ModelTabelaProfesori, Object> rf = null;
		try {
			rf = RowFilter.regexFilter(brLicneKarte);
		} catch (java.util.regex.PatternSyntaxException e) {
			return;
		}
		filteri.add(rf);
	}
}
