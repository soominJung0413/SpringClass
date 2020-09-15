package www.study.com.party.model;

import java.util.Date;

import lombok.Data;

@Data
public class PersonVO extends PartyVO {
	public enum Gender {mail, femail}
	private Gender gender;
	
	public PersonVO() {}
	
	public PersonVO(String name, Date birthDate, Gender gender) {
		super(name, birthDate);
		this.gender = gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PersonVO [gender=" + gender + ", toString()=" + super.toString() + "]";
	}
	
	
}
