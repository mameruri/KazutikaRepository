package test01;

public class Toridasi {

	public int TD(int value, int keta) {

		switch(keta) {
		case 1:
			value=value-value/10*10;
			break;
		default:
			value=(value/10)-(value/100*10);
			break;
		}

		return value;

	}

}
