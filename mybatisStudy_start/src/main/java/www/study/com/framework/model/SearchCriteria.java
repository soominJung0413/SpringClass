package www.study.com.framework.model;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchCriteria extends Criteria {
	private String type;
	private String keyword;

	public SearchCriteria(int pageNo, int amount, String type, String keyword) {
		super(pageNo, amount);
		this.type = type;
		this.keyword = keyword;
	}

	//변경국부성. Locality of Change.
	public SearchCriteria(SearchCriteria other, int tot) {
		super(other, tot);
		this.type = other.type;
		this.keyword = other.keyword;
	}

	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
		builder.queryParam("pageNo", pageNo);
		builder.queryParam("amount", amount);
		builder.queryParam("type", type);
		builder.queryParam("keyword", keyword);
		return builder.toUriString();
	}
	
	public String makeHiddenHTMLTags() {
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"hidden\" name='pageNo' value='" + pageNo + "'>\n");	 
		sb.append("<input type=\"hidden\" name='amount' value='" + amount + "'>\n");	 
		sb.append("<input type=\"hidden\" name='type' value='" + type + "'>\n");	 
		sb.append("<input type=\"hidden\" name='keyword' value='" + keyword + "'>");	 
		
		return sb.toString();
	}
}
