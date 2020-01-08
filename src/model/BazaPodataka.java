package model;

import java.io.*;
import java.util.ArrayList;

public class BazaPodataka {

	private BazaStudenata bazaStudenata;
	private BazaProfesora bazaProfesora;
	private BazaPredmeta bazaPredmeta;
	
	public BazaPodataka() {
		bazaStudenata = BazaStudenata.getInstance();
		bazaProfesora = BazaProfesora.getInstance();
		bazaPredmeta = BazaPredmeta.getInstance();
	}
	
	public void LoadFromFile() {
		ObjectInputStream ois = null;
		try {
		ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("podaci/bazaPodataka.ser")));
		bazaStudenata.studenti = (ArrayList<Student>) ois.readObject();
		bazaProfesora.profesori = (ArrayList<Profesor>) ois.readObject();
		bazaPredmeta.predmeti = (ArrayList<Predmet>) ois.readObject();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveToFile() {
		ObjectOutputStream oos = null;
		try {
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("podaci/bazaPodataka.ser")));
		oos.writeObject(bazaStudenata.studenti);
		oos.writeObject(bazaProfesora.profesori);
		oos.writeObject(bazaPredmeta.predmeti);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
