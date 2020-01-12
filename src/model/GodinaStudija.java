package model;

public enum GodinaStudija {
	I , II, III, IV, V;
	
	public String toString() {
		if(this == I)
			return "I (prva)";
		else if(this == II)
			return "II (druga)";
		else if(this == III)
			return "III (tre\u0107a)";
		else if(this == IV)
			return "IV (\u010Detvrta)";
		else if(this == V)
			return "V (peta)";
		else
			return null;
	}
}