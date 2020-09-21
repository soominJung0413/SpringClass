package www.study.com.search.service;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.Token;

public class HashTagService {
	private static Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
	
	public static String analysisTarget(String analysisTarget) {
		StringBuilder sb = new StringBuilder();
		List<Token> tokens = komoran.analyze(analysisTarget).getTokenList();
		for (Token token : tokens) {
			if (token.getPos().startsWith("NN") || token.getPos().startsWith("SL")) {
				sb.append(token.getMorph()).append(' ');
			}
		}
		return sb.toString();
	}

}
