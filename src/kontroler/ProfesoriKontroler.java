package kontroler;

import model.BazaProfesora;
import model.Profesor;

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
		
		public void izbrisiProfesora(int red) {
			if(red<0) {
				return;
			}
			Profesor p = BazaProfesora.getInstance().getRow(red);
			BazaProfesora.getInstance().izbrisiProfesora(p.getBrojLicneKarte());
		}
	}

