package komponente;

import java.util.Comparator;

import model.Student;

public class ComparatorStudenti implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		ComparatorZaSortiranje comp = new ComparatorZaSortiranje();
		return comp.compare(o1.getBrojIndeksa(), o2.getBrojIndeksa());
	}

}
