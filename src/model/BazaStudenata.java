package model;
import java.util.ArrayList;

public class BazaStudenata {

		private static BazaStudenata instance = null;

		public static BazaStudenata getInstance() {
			if (instance == null) {
				instance = new BazaStudenata();
			}
			return instance;
		}

		private ArrayList<Student> studenti;
		private ArrayList<String> kolone;

		private BazaStudenata() {
		
			this.studenti = new ArrayList<Student>();
			this.kolone = new ArrayList<String>();
			this.kolone.add("Indeks");
			this.kolone.add("Ime");
			this.kolone.add("Prezime");
			this.kolone.add("Godina studija");
			this.kolone.add("Status");
			this.kolone.add("Prosek");
			this.studenti.add(new Student("Aleksandar", "Stevanovic", "17.11.1998.", "Metlic 10", "+381654328987", "", "ra-176-2017", "", GodinaStudija.III, Status.B, 9.00));
		}

		public ArrayList<Student> getStudenti() {
			return studenti;
		}

		public Boolean dodajStudenta(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String brojIndeksa, GodinaStudija trenutnaGodinaStudija, Status statusStudenta) {
				for(Student s : this.studenti)
					if(brojIndeksa.equals(s.getBrojIndeksa()))
						return false;
				
				studenti.add(new Student(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, " ", brojIndeksa, "", trenutnaGodinaStudija, statusStudenta, 0.0));
				return true;
		}
		
		public Boolean izmeniStudenta(int row, String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon, String brojIndeksa /*String datumUpisa*/, GodinaStudija trenutnaGodinaStudija, Status statusStudenta) {
			if(row < 0 || row > studenti.size())
				return false;

			for(int i = 0; i < studenti.size(); i++)
				if(brojIndeksa.equals(studenti.get(i).getBrojIndeksa()) && i != row)
					return false;
			
			Student s = studenti.get(row);
			s.setIme(ime);
			s.setPrezime(prezime);
			s.setDatumRodjenja(datumRodjenja);
			s.setAdresaStanovanja(adresaStanovanja);
			s.setKontaktTelefon(kontaktTelefon);
			s.setBrojIndeksa(brojIndeksa);
			s.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
			s.setStatusStudenta(statusStudenta);
			return true;
			
		}
		
		public void setStudenti(ArrayList<Student> studenti) {
			this.studenti = studenti;
		}

		public int getBrojKolona() {
			return 6;
		}

		public String getImeKolone(int index) {
			return this.kolone.get(index);
		}

		public Student getRow(int rowIndex) {
			return this.studenti.get(rowIndex);
		}

		public String getVrednostPolja(int row, int column) {
			Student student = this.studenti.get(row);
			switch (column) {
			case 0:
				return student.getBrojIndeksa();
			case 1:
				return student.getIme();
			case 2:
				return student.getPrezime();
			case 3:
				return student.getTrenutnaGodinaStudija().toString();
			case 4:
				return student.getStatusStudenta() == Status.B ? "Budzet" : "Samofinansiranje";
			case 5:
				return Double.toString(student.getProsecnaOcena());
			default:
				return null;
			}
		}
}