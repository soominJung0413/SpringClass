package www.study.com.orm.party.model;

import lombok.Data;

@Data
public class PersonVO extends PartyVO {
	private enum Gender{male, female}
	private Gender gender;
}
