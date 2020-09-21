package www.lang.com;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.Token;

public class CustomizedTest {

	public static void main(String[] args) {
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		List<Token> tokens = komoran.analyze("청하는 hello 아이오아이출신입니다").getTokenList();
		for (Token token : tokens) {
			if (token.getPos().startsWith("NN") || token.getPos().startsWith("SL")) {
				System.out.print("찾은 단어는 " + token.getMorph());
				System.out.println(", 단어 품사는 " + token.getPos());
			}
		}
	}

}
