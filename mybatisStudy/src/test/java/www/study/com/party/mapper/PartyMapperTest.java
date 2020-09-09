package www.study.com.party.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.bullutineBoard.model.ReplyVO;
import www.study.com.party.mapper.PartyMapper;
import www.study.com.party.model.ContactPointVO;
import www.study.com.party.model.HashTagVO;
import www.study.com.party.model.PartyVO;
import www.study.com.party.model.PersonVO;
import www.study.com.party.model.PersonVO.Gender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PartyMapperTest {
	@Autowired
	private PartyMapper mapper;

	@Test
	public void testGetAll() {
		try {
			System.out.println("testGetAll()");
			List<PartyVO> listSimple = mapper.getAll();
			for (PartyVO simple : listSimple) {
				System.out.println(simple);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllWithContactPoint() {
		try {
			System.out.println("testGetAllWithContactPoint()");
			List<PartyVO> listSimple = mapper.getAllWithContactPoint();
			for (PartyVO simple : listSimple) {
				System.out.println(simple);
				for (ContactPointVO cp : simple.getListContactPoint()) {
					System.out.println(cp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllWithContactPointWithoutLoss() {
		try {
			System.out.println("testGetAllWithContactPointWithoutLoss()");
			List<PartyVO> listSimple = mapper.getAllWithContactPointWithoutLoss();
			for (PartyVO simple : listSimple) {
				System.out.println(simple);
				for (ContactPointVO cp : simple.getListContactPoint()) {
					System.out.println(cp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllWithContactPointWithoutLossAndPersonalService() {
		try {
			System.out.println("testGetAllWithContactPointWithoutLossAndPersonalService()");
			List<PartyVO> listSimple = mapper.getAllWithContactPointWithoutLossAndPersonalService();
			for (PartyVO simple : listSimple) {
				System.out.println(simple);
				for (HashTagVO tag : simple.getListHashTag()) {
					System.out.println(tag);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInsertPerson() {
		try {
			System.out.println("\ntestInsertPerson()");
			PersonVO obj = new PersonVO("허균", new Date(), PersonVO.Gender.mail);
			mapper.insertPerson(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInsertPersonHavingContactPoint() {
		try {
			System.out.println("\ntestInsertPersonHavingContactPoint()");
			PersonVO obj = new PersonVO("허균식", new Date(), PersonVO.Gender.mail);

			mapper.insertPerson(obj);

			ContactPointVO cp = new ContactPointVO("주소", "조선 한양");
			obj.addContactPoint(cp);
			cp = new ContactPointVO("phone", "999-999-999999");
			obj.addContactPoint(cp);

			mapper.insertContactPointByOneshot(obj.getListContactPoint());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
