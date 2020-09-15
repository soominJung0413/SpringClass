package www.study.com.party.model;

import lombok.Data;

@Data
public class ContactPointVO {
	private int partyId;
	private String typeName;
	private String contactPoint;
	
	public ContactPointVO() {}
	
	public ContactPointVO(String typeName, String contactPoint) {
		this.typeName = typeName;
		this.contactPoint = contactPoint;
	}

	@Override
	public String toString() {
		return "ContactPointVO [typeName=" + typeName + ", contactPoint=" + contactPoint + "]";
	}

	public void setId(int id) {
		this.partyId = id;
	}
}
