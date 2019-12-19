package model;

import java.util.ArrayList;

public class Student {
	String ime;
	String prezime;
	String datumRodjenja;
	String adresaStanovanja;
	String kontaktTelefon;
	String emailAdresa;
	String brojIndeksa;
	String datumUpisa;
	GodinaStudija trenutnaGodinaStudija;
	Status statusStudenta;
	double prosecnaOcena;
	ArrayList<Predmet> spisakPredmeta;
	
	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, String datumUpisa, GodinaStudija trenutnaGodinaStudija, Status statusStudenta,
			double prosecnaOcena) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.datumUpisa = datumUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.statusStudenta = statusStudenta;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPredmeta = new ArrayList<Predmet>();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public String getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public GodinaStudija getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(String trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = GodinaStudija.valueOf(trenutnaGodinaStudija);
	}

	public Status getStatusStudenta() {
		return statusStudenta;
	}

	public void setStatusStudenta(Status statusStudenta) {
		this.statusStudenta = statusStudenta;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Predmet> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(ArrayList<Predmet> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	
}
