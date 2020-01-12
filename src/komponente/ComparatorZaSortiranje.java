package komponente;

import java.util.Comparator;

public class ComparatorZaSortiranje implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
			int retVal = 0;
			//Kada je u pitanju indeks poredimo prvo po studijskom smeru, zatim po godini upisa i na kraju po broju indeksa
			if(s1.matches("(([a-z][a-z])|([A-Z][A-Z]))\\-([00]?[1-9]|0?[1-9][0-9]|[1-9][0-9][0-9])\\-[0-9]{4}")) {
				String[] podeljen1 = s1.split("\\-");
				String[] podeljen2 = s2.split("\\-");
				int prvoPoredjenje = podeljen1[0].compareTo(podeljen2[0]);
				if(prvoPoredjenje == 0) {
					int godinaUpisa1 = Integer.parseInt(podeljen1[2]);
					int godinaUpisa2 = Integer.parseInt(podeljen2[2]);
					int drugoPoredjenje = godinaUpisa1 - godinaUpisa2;
					if(drugoPoredjenje == 0) {
						int brojIndeksa1 = Integer.parseInt(podeljen1[1]);
						int brojIndeksa2 = Integer.parseInt(podeljen2[1]);
						retVal = brojIndeksa1 - brojIndeksa2;
					}
					else {
						retVal = drugoPoredjenje;
					}
				}
				else {
					retVal = prvoPoredjenje;
				}
			}
			//Kada su datumi u pitanju, umesto ugradjenog nacina poredimo ih prvo po godini, zatim mesecu i na kraju danu
			if(s1.matches("0?([1-9]|[12][0-9]|3[01])\\.0?([1-9]|1[012])\\.[0-9]{4}\\.")) {
				String[] podeljen1 = s1.split("\\.");
				String[] podeljen2 = s2.split("\\.");
				int godina1 = Integer.parseInt(podeljen1[2]);
				int godina2 = Integer.parseInt(podeljen2[2]);
				int prvoPoredjenje = godina1 - godina2;
				if(prvoPoredjenje == 0) {
					int mesec1 = Integer.parseInt(podeljen1[1]);
					int mesec2 = Integer.parseInt(podeljen2[1]);
					int drugoPoredjenje = mesec1 - mesec2;
					if(drugoPoredjenje == 0) {
						int dan1 = Integer.parseInt(podeljen1[0]);
						int dan2 = Integer.parseInt(podeljen2[0]);
						retVal = dan1 - dan2;
					}
					else {
						retVal = drugoPoredjenje;
					}
				}
				else {
					retVal = prvoPoredjenje;
				}
			}
		return retVal;
	}

}
