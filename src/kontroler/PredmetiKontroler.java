package kontroler;

import komponente.TabbedPane;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import model.Student;

public class PredmetiKontroler {

	private static PredmetiKontroler instance = null;

	public static PredmetiKontroler getInstance() {
		if (instance == null) {
			instance = new PredmetiKontroler();
		}
		return instance;
	}

	private PredmetiKontroler() {
	}

	public boolean dodajPredmet(Predmet p) {
		boolean povratnaVrednost = BazaPredmeta.getInstance().dodajPredmet(p);
		TabbedPane.getInstance().azurirajPrikzazPredmeta();
		return povratnaVrednost;
	}

	public Boolean izmeniPredmet(int row, Predmet p) {
		Boolean povratnaVrednost = BazaPredmeta.getInstance().izmeniPredmet(row, p);
		TabbedPane.getInstance().azurirajPrikzazPredmeta();

		return povratnaVrednost;
	}

	public void dodajStudenta(int row, Student student) {
		BazaPredmeta.getInstance().dodajStudenta(row, student);
	}

	public void izbrisiStudenta(int row, int index) {
		BazaPredmeta.getInstance().izbrisiStudenta(row, index);
	}

	public void izbrisiProfesora(int row) {
		BazaPredmeta.getInstance().izbrisiProfesora(row);
	}

	public void dodajProfesora(int row, Profesor profesor) {
		BazaPredmeta.getInstance().dodajProfesora(row, profesor);
	}

	public void izbrisiPredmet(int red) {
		if (red < 0) {
			return;
		}

		Predmet p = BazaPredmeta.getInstance().getRow(red);
		BazaPredmeta.getInstance().izbrisiPredmet(p.getSifraPredmeta());
	}
}
