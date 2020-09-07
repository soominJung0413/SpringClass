package www.study.com.orm.party.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ContactPointVO {
	
	/**
	 * 1:N 구조에 의해 List로 리턴되는 클래스
	 */
	private String typeName;
	private String contactPoint;
	
	
}
