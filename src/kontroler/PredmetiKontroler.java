package kontroler;

import model.BazaPredmeta;
import model.Predmet;

public class PredmetiKontroler {

	private static PredmetiKontroler instance=null;
	
	public static PredmetiKontroler getInstance() {
		if(instance==null) {
			instance= new PredmetiKontroler();
		}
		return instance;
	}
	
	private PredmetiKontroler() {}
	
	public void dodajPredmet(String sifra, String naziv,  String semestar,String godina) {
		
		BazaPredmeta.getInstance().dodajPredmet(sifra, naziv, semestar, godina);
	}
	public void izbrisiPredmet(int red) {
		if(red < 0) {
			return;
		}
		
		Predmet p = BazaPredmeta.getInstance().getRow(red);
		BazaPredmeta.getInstance().izbrisiPredmet(p.getSifraPredmeta());
	}
}
