package kontroler;

import komponente.TabbedPane;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import model.Student;

public class ProfesoriKontroler {
	
	private static ProfesoriKontroler instance = null;

	public static ProfesoriKontroler getInstance() {
		if (instance == null) {
			instance = new ProfesoriKontroler();
		}
		return instance;
	}
		
		private ProfesoriKontroler() {
			
		}
		
		public Boolean dodajProfesora(Profesor profesor) {
			Boolean povratnaVrednost = BazaProfesora.getInstance().dodajProfesora(profesor);
			TabbedPane.getInstance().azurirajPrikazProfesora();
			return povratnaVrednost;
		}
		
		public Boolean izmeniProfesora(int row, Profesor profesor) {
			Boolean povratnaVrednost = BazaProfesora.getInstance().izmeniProfesora(row, profesor);
			TabbedPane.getInstance().azurirajPrikazProfesora();
			return povratnaVrednost;
		}
		
		public void izbrisiProfesora(int red) {
			if(red<0) {
				return;
			}
			Profesor p = BazaProfesora.getInstance().getRow(red);
			BazaProfesora.getInstance().izbrisiProfesora(p.getBrojLicneKarte());
			TabbedPane.getInstance().azurirajPrikazProfesora();
		}
	}

