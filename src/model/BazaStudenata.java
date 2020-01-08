package model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BazaStudenata {

		private static BazaStudenata instance = null;

		public static BazaStudenata getInstance() {
			if (instance == null) {
				instance = new BazaStudenata();
			}
			return instance;
		}

		protected ArrayList<Student> studenti;
		private ArrayList<String> kolone;

		private BazaStudenata() {
		
			this.studenti = new ArrayList<Student>();
			this.kolone = new ArrayList<String>();
			this.kolone.add("Indeks");
			this.kolone.add("Ime");
			this.kolone.add("Prezime");
			this.kolone.add("Datum rodjenja");
			this.kolone.add("Adresa");
			this.kolone.add("Broj telefona");
			this.kolone.add("Email adresa");
			this.kolone.add("Datum upisa");
			this.kolone.add("Godina studija");
			this.kolone.add("Status");
			this.kolone.add("Prosek");
			this.kolone.add("Predmeti");

		}

		public ArrayList<Student> getStudenti() {
			return studenti;
		}

		public Boolean dodajStudenta(Student student) {
				for(Student s : this.studenti)
					if(student.getBrojIndeksa().equals(s.getBrojIndeksa()))
						return false;
				
				studenti.add(student);
				return true;
		}
		
		public Boolean izmeniStudenta(int row, Student student) {
			if(row < 0 || row >= studenti.size())
				return false;

			for(int i = 0; i < studenti.size(); i++)
				if(student.getBrojIndeksa().equals(studenti.get(i).getBrojIndeksa()) && i != row)
					return false;
			
			Student s = studenti.get(row);
			s.setBrojIndeksa(student.getBrojIndeksa());
			s.setIme(student.getIme());
			s.setPrezime(student.getPrezime());
			s.setAdresaStanovanja(student.getAdresaStanovanja());
			s.setKontaktTelefon(student.getKontaktTelefon());
			s.setStatusStudenta(student.getStatusStudenta());
			s.setTrenutnaGodinaStudija(student.getTrenutnaGodinaStudija());
			s.setEmailAdresa(student.getEmailAdresa());
			s.setDatumRodjenja(student.getDatumRodjenja());
			s.setDatumUpisa(student.getDatumUpisa());
			return true;
			
		}
		
		public void izbrisiStudenta(int row) {
			if(row < 0 || row >= studenti.size())
				return;
			
			this.studenti.remove(row);
		}
		
		public void setStudenti(ArrayList<Student> studenti) {
			this.studenti = studenti;
		}

		public int getBrojKolona() {
			return kolone.size();
		}

		public String getImeKolone(int index) {
			return this.kolone.get(index);
		}

		public Student getRow(int rowIndex) {
			return this.studenti.get(rowIndex);
		}

		public Student pronadjiPoIndeksu(String indeks) {
			Student student = null;
			for(Student s : studenti)
				if(s.getBrojIndeksa().equalsIgnoreCase(indeks)) {
					student = s;
					break;
				}
			return student;
		}
		
		public void dodajPredmet(Student student, Predmet predmet) {
			for(Predmet p : student.getSpisakPredmeta())
				if(p == predmet)
					return;
			
			student.getSpisakPredmeta().add(predmet);
		}
		
		public void izbrisiPredmet(Student student, Predmet predmet) {
			if(student == null)
				return;
			
			student.getSpisakPredmeta().remove(predmet);
		}
		
		public String getVrednostPolja(int row, int column) {
			Student student = this.studenti.get(row);
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
			switch (column) {
			case 0:
				return student.getBrojIndeksa();
			case 1:
				return student.getIme();
			case 2:
				return student.getPrezime();
			case 3:
				return df.format(student.getDatumRodjenja());
			case 4:
				return student.getAdresaStanovanja();
			case 5:
				return student.getKontaktTelefon();
			case 6:
				return student.getEmailAdresa();
			case 7:
				return df.format(student.getDatumUpisa());
			case 8:
				return student.getTrenutnaGodinaStudija().toString();
			case 9:
				return student.getStatusStudenta() == Status.B ? "Budzet" : "Samofinansiranje";
			case 10:
				return Double.toString(student.getProsecnaOcena());
			default:
				return null;
			}
		}
}