package model;

import java.util.ArrayList;

public class BazaPredmeta {
	public static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	protected ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;

	private BazaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		this.kolone = new ArrayList<String>();
		kolone.add("\u0160ifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("Semestar");
		kolone.add("Godina u kojoj se izvodi");
		kolone.add("Profesor");
		kolone.add("Studenti");
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public Boolean dodajPredmet(Predmet p) {
		for (Predmet pr : this.predmeti)
			if (p.getSifraPredmeta().equals(pr.getSifraPredmeta()))
				return false;

		this.predmeti.add(p);
		return true;

	}

	public boolean izmeniPredmet(int row, Predmet p) {

		if (row < 0 || row > predmeti.size())
			return false;

		for (int i = 0; i < predmeti.size(); i++)
			if (p.getSifraPredmeta().equals(predmeti.get(i).getSifraPredmeta()) && i != row)
				return false;

		predmeti.set(row, p);

		return true;

	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getKolone() {
		return kolone.size();
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

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public void izbrisiPredmet(String sifra) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().matches(sifra)) {
				predmeti.remove(p);
				izbrisiPredmetSaProfesora(p);
				izbrisiPredmetSaStudenta(p);
				break;
			}
		}
	}

	public void izbrisiPredmetSaProfesora(Predmet p) {
		for (Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
			for (int i = 0; i < profesor.getPredmeti().size(); i++) {
				if (p == profesor.getPredmeti().get(i)) {
					profesor.getPredmeti().remove(i);
				
				}
			}
		}

	}

	public void izbrisiPredmetSaStudenta(Predmet p) {
		for (Student student : BazaStudenata.getInstance().getStudenti()) {
			for (int i = 0; i < student.getSpisakPredmeta().size(); i++) {
				if (p == student.getSpisakPredmeta().get(i)) {
					student.getSpisakPredmeta().remove(i);
				}
			}
		}

	}

	public void dodajStudenta(int row, Student s) {
		if (row < 0 || row > predmeti.size())
			return;

		for (Student stud : predmeti.get(row).getSpisakStudenataKojiSlusajuPredmet())
			if (stud == s)
				return;

		predmeti.get(row).getSpisakStudenataKojiSlusajuPredmet().add(s);

	}

	public void izbrisiStudenta(int row, int idx) {
		if (row < 0 || row > predmeti.size())
			return;

		Predmet p = predmeti.get(row);

		if (idx < 0 || idx > p.getSpisakStudenataKojiSlusajuPredmet().size())
			return;

		p.getSpisakStudenataKojiSlusajuPredmet().remove(idx);

	}

	public void izbrisiProfesora(int row) {
		if (row < 0 || row > predmeti.size())
			return;

		Predmet p = predmeti.get(row);

		p.setPredmetniProfesor(null);
	}

	public void dodajProfesora(int row, Profesor p) {
		if (row < 0 || row > predmeti.size())
			return;

		predmeti.get(row).setPredmetniProfesor(p);

	}

	public void izbrisiStudentaSaSvihPredmeta(Student student) {
		for(int i = 0; i < predmeti.size(); i++) {
			Predmet p = predmeti.get(i);
			for(int j = 0; j < p.getSpisakStudenataKojiSlusajuPredmet().size(); j++) {
				Student s = p.getSpisakStudenataKojiSlusajuPredmet().get(j);
				if(student == s)
					izbrisiStudenta(i, j);
			}
		}
			
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return predmet.getSemestar();
		case 3:
			return predmet.getGodinaUKojojSePredmetIzvodi().toString();

		default:
			return null;

		}
	}
}
