package www.study.com.party.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor	//화면에서 입력한 정보를 바탕으로 HTTP를 통하여 서버로 넘어올때 활용됩니다.
public class OrganizationVO extends PartyVO {
	
	
	public OrganizationVO(String loginId, String pwd) {
		super(loginId, pwd);
	}

	
	
}
