package www.study.com.framework.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Pair<F, S> {
	@Getter
	private F first;
	@Getter
	private S second;

	
}
