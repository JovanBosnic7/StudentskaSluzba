package komponente;

import java.util.Comparator;

import model.Predmet;

public class ComparatorPredmet implements Comparator<Predmet>{

	@Override
	public int compare(Predmet o1, Predmet o2) {
		return o1.getSifraPredmeta().compareToIgnoreCase(o2.getNazivPredmeta());
	}

}
