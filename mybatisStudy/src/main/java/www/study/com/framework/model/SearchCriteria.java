package www.study.com.framework.model;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchCriteria extends Criteria {
	private String type;
	private String keyword;
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}

	public SearchCriteria(SearchCriteria other,int tot) {//넘겨야하는 객체가 상속관계일때 사용하는 방법, 객체 안의 생성자에서 생성자의 변경점을 관리함.
		super(other,tot);
		this.type = other.type;
		this.keyword = other.keyword;
	}
	
	public SearchCriteria(int pageNo, int amount, String type, String keyword) {
		super(pageNo, amount);
		this.type = type;
		this.keyword = keyword;
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
		builder.queryParam("pageNo", this.pageNo).queryParam("amount", this.amount).queryParam("type", this.type).queryParam("keyword", this.keyword);
		return builder.toUriString();
	}
	
	public String makeHiddenHTMLTags() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("<input type=\'hidden\' name=\'pageNo\' value=\'");
		strBuilder.append(this.pageNo);
		strBuilder.append("\'>");
		strBuilder.append("<input type=\'hidden\' name=\'amount\' value=\'");
		strBuilder.append(this.amount);
		strBuilder.append("\'>");
		strBuilder.append("<input type=\'hidden\' name=\'type\' value=\'");
		strBuilder.append(this.type);
		strBuilder.append("\'>");
		strBuilder.append("<input type=\'hidden\' name=\'keyword\' value=\'");
		strBuilder.append(this.keyword);
		strBuilder.append("\'>");
		
		return strBuilder.toString();
	}
}
