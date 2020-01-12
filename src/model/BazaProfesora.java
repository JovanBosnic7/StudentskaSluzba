package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BazaProfesora {
	public static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	protected ArrayList<Profesor> profesori;
	private ArrayList<String> kolone;

	private BazaProfesora() {
		this.profesori = new ArrayList<Profesor>();
		this.kolone = new ArrayList<String>();

		kolone.add("Broj li\u010Dne karte");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Datum ro\u0111enja");
		kolone.add("Adresa stanovanja");
		kolone.add("Telefon");
		kolone.add("Adresa kancelarije");
		kolone.add("Titula");
		kolone.add("Zvanje");
		kolone.add("Predmeti");
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public Boolean dodajProfesora(Profesor profesor) {
		for (Profesor p : this.profesori)
			if (profesor.getBrojLicneKarte().equals(p.getBrojLicneKarte()))
				return false;

		profesori.add(profesor);
		return true;
	}

	public Boolean izmeniProfesora(int row, Profesor profesor) {
		if (row < 0 || row > profesori.size())
			return false;

		for (int i = 0; i < profesori.size(); i++)
			if (profesor.getBrojLicneKarte().equals(profesori.get(i).getBrojLicneKarte()) && i != row)
				return false;

		profesori.set(row, profesor);
		return true;

	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getKolone() {
		return kolone.size();
	}

	public String getImeKolone(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public void setKolone(ArrayList<String> kolone) {
		this.kolone = kolone;
	}

	public void izbrisiProfesora(String brlk) {
		for (Profesor p : profesori) {

			if (p.getBrojLicneKarte().matches(brlk)) {
				profesori.remove(p);
				for (int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
					if (p == BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor()) {
						BazaPredmeta.getInstance().getPredmeti().get(i).obrisiProfesora(p);
					}
				}
				break;
			}
		}
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
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
			return df.format(prof.getDatumRodjenja());
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

	public void dodajPredmet(Profesor profesor, Predmet predmet) {
		profesor.getPredmeti().add(predmet);
	}

	public Profesor pronadjiPoBrLicneKarte(String brojLicneKarte) {
		Profesor profesor = null;
		for (Profesor p : profesori)
			if (p.getBrojLicneKarte().equalsIgnoreCase(brojLicneKarte)) {
				profesor = p;
				break;
			}
		return profesor;
	}

	public Boolean hasRefTo(Predmet predmet) {
		Boolean retVal = false;
		for (Profesor pro : profesori) {
			for (Predmet pre : pro.getPredmeti()) {
				if (pre == predmet) {
					retVal = true;
					break;
				}
			}
		}
		return retVal;
	}

	public void izbrisiPredmet(Profesor profesor, Predmet predmet) {
		if (profesor == null)
			return;
		profesor.getPredmeti().remove(predmet);
	}
}
