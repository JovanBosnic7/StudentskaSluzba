package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = 1524169267767801501L;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private Date datumUpisa;
	private GodinaStudija trenutnaGodinaStudija;
	private Status statusStudenta;
	private double prosecnaOcena;
	private ArrayList<Predmet> spisakPredmeta;
	
	public Student(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, Date datumUpisa, GodinaStudija trenutnaGodinaStudija, Status statusStudenta,
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
	
	public Student() {
		super();
		this.ime = "";
		this.prezime = "";
		this.datumRodjenja = new Date(0);
		this.adresaStanovanja = "";
		this.kontaktTelefon = "";
		this.emailAdresa = "";
		this.brojIndeksa = "";
		this.datumUpisa = new Date(0);
		this.trenutnaGodinaStudija = GodinaStudija.I;
		this.statusStudenta = Status.B;
		this.prosecnaOcena = 6 + Math.round(400*Math.random())/100;
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

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
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

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public GodinaStudija getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(GodinaStudija trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
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
	
	@Override
	public String toString() {
		return this.brojIndeksa;
	}
	
}
