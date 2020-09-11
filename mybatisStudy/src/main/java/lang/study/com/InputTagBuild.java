package lang.study.com;

import www.study.com.framework.model.SearchCriteria;

public class InputTagBuild {

	public static void main(String[] args) {
		SearchCriteria criteria = new SearchCriteria();
		criteria.setAmount(10);
		criteria.setPageNo(1);
		criteria.setType("T");
		criteria.setKeyword("테스트");
		System.out.println(criteria.makeHiddenHTMLTags());
	}

}
