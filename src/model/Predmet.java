package model;

public class Predmet {
	private String sifraPredmeta;
	private String nazivPredmeta;
	private String semestar;
	private String godinaUKojojSePredmetIzvodi;
	private Profesor predmetniProfesor;

	// private ArrayList<Student> spisakStudenataKojiSlusajuPredmet
	public Predmet(String sifraPredmeta, String nazivPredmeta, String semestar, String godinaUKojojSePredmetIzvodi,
			Profesor predmetniProfesor) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaUKojojSePredmetIzvodi = godinaUKojojSePredmetIzvodi;
		this.predmetniProfesor = predmetniProfesor;
	}

	public Predmet(String sifraPredmeta2, String nazivPredmeta2, String semestar2, String godinaUKojojSePredmetIzvodi2) {
			
			super();
		this.sifraPredmeta = sifraPredmeta2;
		this.nazivPredmeta = nazivPredmeta2;
		this.semestar = semestar2;
		this.godinaUKojojSePredmetIzvodi = godinaUKojojSePredmetIzvodi2;
		
	}
	

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String getGodinaUKojojSePredmetIzvodi() {
		return godinaUKojojSePredmetIzvodi;
	}

	public void setGodinaUKojojSePredmetIzvodi(String godinaUKojojSePredmetIzvodi) {
		this.godinaUKojojSePredmetIzvodi = godinaUKojojSePredmetIzvodi;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	public String getProfesor() {
		return this.predmetniProfesor.toString();
	}

	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaUKojojSePredmetIzvodi=" + godinaUKojojSePredmetIzvodi + ", predmetniProfesor="
				 + "]";
	}

}

