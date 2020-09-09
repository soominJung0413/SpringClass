package lang.study.com;

public class Radix {

	public static void main(String[] args) {
		int x = 342354212;
		System.out.println("" + x);
		System.out.println(Integer.toString(x, Character.MAX_RADIX));
	}

}
