package www.study.com.framework.model;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class SearchCriteria extends Criteria {
	private String keyword;

	public SearchCriteria() {}

	public SearchCriteria(int pageNo, String keyword) {
		super(pageNo);
		this.keyword = keyword;
	}

	//변경국부성. Locality of Change.
	public SearchCriteria(SearchCriteria other, long tot) {
		super(other, tot);
		this.keyword = other.keyword;
	}
	
	public String[] getArrKeyword() {
		if (keyword == null || keyword.isEmpty()) {
			return new String[] {};
		}
		return keyword.split(" ");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
		builder.queryParam("pageNo", pageNo);
		builder.queryParam("keyword", keyword);
		return builder.toUriString();
	}
	
	public String makeHiddenHTMLTags() {
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"hidden\" name='pageNo' value='" + pageNo + "'>\n");	 
		sb.append("<input type=\"hidden\" name='keyword' value='" + keyword + "'>");	 
		
		return sb.toString();
	}
}
