package model;

import java.util.ArrayList;

public class BazaPredmeta {
	public static BazaPredmeta instance=null;
	
	public static BazaPredmeta getInstance() {
		if(instance==null) {
			instance=new BazaPredmeta();
		}
		return instance;
	}
	
	private ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;
	
	private BazaPredmeta() {
		this.predmeti=new ArrayList<Predmet>();
		this.kolone= new ArrayList<String> ();
		kolone.add("Sifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("Semestar");
		kolone.add("Godina u kojoj se izvodi");
		kolone.add("Profesor");
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	public void dodajPredmet(String sifra, String naziv, String semestar,String godinaUKojojSeIzvodi,String profesor ) {
		predmeti.add(new Predmet(sifra,naziv,semestar,godinaUKojojSeIzvodi,profesor));
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int  getKolone() {
		return 5;
	}

	public void setKolone(ArrayList<String> kolone) {
		this.kolone = kolone;
	}

	public static void setInstance(BazaPredmeta instance) {
		BazaPredmeta.instance = instance;
	}
	public String getImeKolone(int index) {
		return this.kolone.get(index);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet= this.predmeti.get(row);
		switch(column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getSemestar();
		case 3:
			return predmet.getGodinaUKojojSePredmetIzvodi();
		case 4:
			return predmet.getProfesor();
			default:
				return null;
		
		}
	}
}
