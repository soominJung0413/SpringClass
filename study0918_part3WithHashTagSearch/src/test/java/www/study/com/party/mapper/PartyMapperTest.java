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
//테스트 순서는 이름 오름차순으로
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PartyMapperTest {
	
	@Autowired
	private PartyMapper partyMapper;
	
	@Test
	public void test_aa_사용자아이디바탕으로찾기() {
		try {
			System.out.println("test_aa_사용자아이디바탕으로찾기");
			PartyVO party =  partyMapper.findPartyByLoginId("a");
			System.out.println(party);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 사용자를연락처까지함께아이디바탕으로찾기
	 */
	@Test
	public void test_ab_사용자를연락처까지함께아이디바탕으로찾기() {
		try {
			System.out.println("test_ab_사용자를연락처까지함께아이디바탕으로찾기");
			//Method Signiture 
			PartyVO party =  partyMapper.findPartyWithContactPointByLoginId("a");
			System.out.println(party);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test_zz_사용자탈퇴() {
		try {
			System.out.println("test_zz_사용자탈퇴");
			//Method Signiture 
			int cnt =  partyMapper.secessionParty("b");
			System.out.println("" + cnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//private void aaa() {}
	//public void bbb() {}
}







