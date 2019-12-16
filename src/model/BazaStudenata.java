package model;
import java.util.ArrayList;
import java.util.List;

public class BazaStudenata {

		private static BazaStudenata instance = null;

		public static BazaStudenata getInstance() {
			if (instance == null) {
				instance = new BazaStudenata();
			}
			return instance;
		}

		private List<Student> studenti;
		private List<String> kolone;

		private BazaStudenata() {
		
			this.studenti = new ArrayList<Student>();
			this.kolone = new ArrayList<String>();
			this.kolone.add("Indeks");
			this.kolone.add("Ime");
			this.kolone.add("Prezime");
			this.kolone.add("Godina studija");
			this.kolone.add("Status");
			this.kolone.add("Prosek");

		}

		public List<Student> getStudenti() {
			return studenti;
		}

		public void setStudenti(List<Student> studenti) {
			this.studenti = studenti;
		}

		public int getBrojKolona() {
			return 6;
		}

		public String getImeKolone(int index) {
			return this.kolone.get(index);
		}

		public Student getVrsta(int rowIndex) {
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
				return Integer.toString(student.getTrenutnaGodinaStudija());
			case 4:
				return student.getStatusStudenta() == Status.B ? "Budzet" : "Samofinansiranje";
			case 5:
				return Double.toString(student.getProsecnaOcena());
			default:
				return null;
			}
		}
}