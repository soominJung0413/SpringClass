package www.study.com.party.model;

public class ContactPointVO {
	private String typeName;		//연락처 종류  //ContactPointTypeVO와의 연결고리
	private String contactPoint;	//연락 정보
	
	//private PartyVO owner;			//누구에게  달려있지?

	@Override
	public String toString() {
		return "ContactPointVO [typeName=" + typeName + ", contactPoint=" + contactPoint + "]";
	}
	
	
	
}
