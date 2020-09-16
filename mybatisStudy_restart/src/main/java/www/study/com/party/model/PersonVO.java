package www.study.com.party.model;



public class PersonVO extends PartyVO {
	
	
	private String gender; // 성별
	
	public PersonVO() {
	}
	
	public PersonVO(String loginId, String pwd) {
		super(loginId, pwd);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PersonVO ["+super.toStringPropOnly()+", gender=" + gender + "]";
	}
	
	
	
}
