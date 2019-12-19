package kontroler;

import komponente.TabbedPane;
import model.BazaStudenata;
import model.GodinaStudija;
import model.Status;

public class StudentiKontroler {

private static StudentiKontroler instance = null;
	
	public static StudentiKontroler getInstance() {
		if (instance == null) {
			instance = new StudentiKontroler();
		}
		return instance;
	}
	
	private StudentiKontroler() {}
	
	public void dodajStudenta(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String brojIndeksa /*String datumUpisa*/, GodinaStudija trenutnaGodinaStudija, Status statusStudenta) {
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, brojIndeksa, trenutnaGodinaStudija, statusStudenta);
		TabbedPane.getInstance().azurirajPrikaz();
	}
	
}
