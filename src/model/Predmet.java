package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {
	private static final long serialVersionUID = -8961322483451450597L;
	private String sifraPredmeta;
	private String nazivPredmeta;
	private String semestar;
	private GodinaStudija godinaUKojojSePredmetIzvodi;
	private Profesor predmetniProfesor;

	private ArrayList<Student> spisakStudenataKojiSlusajuPredmet;
	public Predmet(String sifraPredmeta, String nazivPredmeta, String semestar, GodinaStudija godinaUKojojSePredmetIzvodi,
			Profesor predmetniProfesor) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaUKojojSePredmetIzvodi = godinaUKojojSePredmetIzvodi;
		this.predmetniProfesor = predmetniProfesor;
		this.spisakStudenataKojiSlusajuPredmet = new ArrayList<Student>();
	}

	public Predmet(String sifraPredmeta2, String nazivPredmeta2, String semestar2, GodinaStudija godinaUKojojSePredmetIzvodi2) {
			
			super();
		this.sifraPredmeta = sifraPredmeta2;
		this.nazivPredmeta = nazivPredmeta2;
		this.semestar = semestar2;
		this.godinaUKojojSePredmetIzvodi = godinaUKojojSePredmetIzvodi2;
		
	}
	

	public Predmet() {
	super();	// TODO Auto-generated constructor stub
	this.spisakStudenataKojiSlusajuPredmet = new ArrayList<Student>();
	this.predmetniProfesor = new Profesor();
	}
	
	public ArrayList<Student> getSpisakStudenataKojiSlusajuPredmet() {
		return spisakStudenataKojiSlusajuPredmet;
	}

	public void setSpisakStudenataKojiSlusajuPredmet(ArrayList<Student> spisakStudenataKojiSlusajuPredmet) {
		this.spisakStudenataKojiSlusajuPredmet = spisakStudenataKojiSlusajuPredmet;
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

	public GodinaStudija getGodinaUKojojSePredmetIzvodi() {
		return godinaUKojojSePredmetIzvodi;
	}

	public void setGodinaUKojojSePredmetIzvodi(GodinaStudija godinaUKojojSePredmetIzvodi) {
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
		
		String imePrezime = "";
		if(predmetniProfesor != null) 
			imePrezime=predmetniProfesor.getIme() + " " + predmetniProfesor.getPrezime();
		
		return "\u0160ifra predmeta : " + sifraPredmeta + ", Naziv predmeta : " + nazivPredmeta + ", Semestar : " + semestar
				+ ", Godina u kojoj se predmet izvodi : " + godinaUKojojSePredmetIzvodi + ", Predmetni profesor : " + imePrezime;
				
	}

	public void obrisiProfesora(Profesor p) {
		// TODO Auto-generated method stub
		if(p == predmetniProfesor) {
			predmetniProfesor=null;
		}
	}

}

