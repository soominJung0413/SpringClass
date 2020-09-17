package www.study.com.party.mapper;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.party.model.PartyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PartyMapperTest {

	@Autowired
	private PartyMapper partyMapper;

//	@Test
	public void test_aa_사용자아이디바탕으로찾기() {
		System.out.println("\n사용자아이디바탕으로찾기()");
		try {
			PartyVO party = partyMapper.findPartyByLoginId("a");

			System.out.println("사용자 : " + party.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void test_ab_사용자를연락처까지함께아이디로찾아내기() {
		System.out.println("\n사용자를연락처까지함께아이디로찾아내기()");
		// Method Signiture
		try {
			PartyVO party = partyMapper.findPartyWithContactPointByLoginId("a");

			System.out.println("사용자 + 연락처 : " + party);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_ab_사용자탈퇴() {
		System.out.println("\n사용자탈퇴()");
		// Method Signiture
		try {
			int cnt = partyMapper.secessionParty("b");
			int cntCp = partyMapper.deleteContactPointById("b");

			System.out.println("사용자 탈퇴컬럼커리 : " + (cnt == 1) + " / " + (cntCp == 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
