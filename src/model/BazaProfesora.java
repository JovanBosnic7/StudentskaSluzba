package model;

import java.util.ArrayList;

public class BazaProfesora {
	public static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance=new BazaProfesora();
		}
		return instance;
	}
	
	private ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;
	
	
	
	private BazaProfesora() {
		this.profesori = new ArrayList<Profesor>();
		this.kolone = new ArrayList<String>();
		Profesor p= new Profesor("Pera", "Peric", "12.12.2012.", "Mise Dimitrijevica 500", "01234412", "perapera@perica.com","Bulevar Oslobodjenja 100", "123332112", "Profesor", "Diplomirani inzinjer");
		Profesor p1=new Profesor("", "", "", "", "", "", "", "", "", "");
		
		profesori.add(p);
		profesori.add(p1);
		profesori.add(p1);
		profesori.add(p1);
		profesori.add(p1);
		profesori.add(p1);
		
		kolone.add("Broj licne karte");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Datum rodjenja");
		kolone.add("Adresa stanovanja");
		kolone.add("Telefon");
		kolone.add("Adresa kancelarije");
		kolone.add("Titula");
		kolone.add("Zvanje");
		}



	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}



	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}



	public int getKolone() {
		return 9;
	}
	public String getImeKolone(int index) {
		return this.kolone.get(index);
	}


	public void setKolone(ArrayList<String> kolone) {
		this.kolone = kolone;
	}
	
	public static void setInstance(BazaProfesora instance) {
		BazaProfesora.instance = instance;
	}
	public String getValueAt(int row, int column) {
		Profesor prof = this.profesori.get(row);
		switch (column) {
		case 0:
			return prof.getBrojLicneKarte();
		case 1:
			return prof.getIme();
		case 2:
			return prof.getPrezime();
		case 3:
			return prof.getDatumRodjenja();
		case 4:
			return prof.getAdresaStanovanja();
		case 5:
			return prof.getKontaktTelefon();
		case 6:
			return prof.getAdresaKancelarije();
		case 7:
			return prof.getTitula();
		case 8:
			return prof.getZvanje();

		default:
			return null;
		}

	}
}
