package lang.study.com;

public class InputTagBuild {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"hidden\" name='pageNo' value='" + 22 + "'>");
		System.out.println(sb.toString());
	}

}
