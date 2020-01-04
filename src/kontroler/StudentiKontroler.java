package kontroler;

import komponente.TabbedPane;
import model.BazaStudenata;
import model.GodinaStudija;
import model.Status;
import model.Student;

public class StudentiKontroler {

private static StudentiKontroler instance = null;
	
	public static StudentiKontroler getInstance() {
		if (instance == null) {
			instance = new StudentiKontroler();
		}
		return instance;
	}
	
	private StudentiKontroler() {}
	
	public Boolean dodajStudenta(Student student) {
		Boolean povratnaVrednost = BazaStudenata.getInstance().dodajStudenta(student);
		TabbedPane.getInstance().azurirajPrikaz();
		return povratnaVrednost;
	}
	
	public Boolean izmeniStudenta(int row, Student student) {
		Boolean povratnaVrednost = BazaStudenata.getInstance().izmeniStudenta(row, student);
		TabbedPane.getInstance().azurirajPrikaz();
		return povratnaVrednost;
	}
	
	public Student pronadjiPoIndeksu(String indeks) {
		Student s = BazaStudenata.getInstance().pronadjiPoIndeksu(indeks);
		return s;
	}
	
	public void izbrisiStudenta(int row) {
		BazaStudenata.getInstance().izbrisiStudenta(row);
		TabbedPane.getInstance().azurirajPrikaz();
	}
}
