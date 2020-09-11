package lang.study.com;

import java.util.Arrays;

public class StringSplit {

	public static void main(String[] args) {
		 String str = "TODO Auto-generated method stub";
		 
		 String[] strArr = str.split(" ");
		 Arrays.stream(strArr).forEach(strIndex -> System.out.println(strIndex) );
	}

}
