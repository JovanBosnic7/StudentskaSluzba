package kontroler;

import model.BazaPredmeta;

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

}
