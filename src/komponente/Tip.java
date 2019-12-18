package komponente;

public enum Tip {
	STUDENT, PROFESOR, PREDMET;

	public static Tip getTip(int i) {

		Tip t = null;
		if (i == 0)
			t = Tip.STUDENT;
		else if (i == 1)
			t = Tip.PROFESOR;
		else if (i == 2)
			t = Tip.PREDMET;
		return t;
	}
}