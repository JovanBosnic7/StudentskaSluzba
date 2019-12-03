package model;

public class Predmet {
	private int sifraPredmeta;
	private String nazivPredmeta;
	private int semestar;
	private int godinaUKojojSePredmetIzvodi;
	private Profesor predmetniProfesor;

	// private ArrayList<Student> spisakStudenataKojiSlusajuPredmet
	public Predmet(int sifraPredmeta, String nazivPredmeta, int semestar, int godinaUKojojSePredmetIzvodi,
			Profesor predmetniProfesor) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaUKojojSePredmetIzvodi = godinaUKojojSePredmetIzvodi;
		this.predmetniProfesor = predmetniProfesor;
	}

	public int getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(int sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getGodinaUKojojSePredmetIzvodi() {
		return godinaUKojojSePredmetIzvodi;
	}

	public void setGodinaUKojojSePredmetIzvodi(int godinaUKojojSePredmetIzvodi) {
		this.godinaUKojojSePredmetIzvodi = godinaUKojojSePredmetIzvodi;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaUKojojSePredmetIzvodi=" + godinaUKojojSePredmetIzvodi + ", predmetniProfesor="
				+ predmetniProfesor + "]";
	}

}