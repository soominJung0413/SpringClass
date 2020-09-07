package www.study.com.orm.party.mapper;

import static org.junit.Assert.*;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import www.study.com.orm.party.mapper.PartyMapper;
import www.study.com.orm.party.model.PartyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PartyMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private PartyMapper partyMapper;
	
//	@Test
	public void testExist() {
		assertThat(partyMapper, IsNull.notNullValue());
		log.info(partyMapper);
	}

	
//	@Test
	public void testGetAll() {
		log.info("testGetAll()");
		List<PartyVO> listParty = partyMapper.getAll();
		
		listParty.forEach(party -> log.info(party) );
	}
	
//	@Test
	public void testGetAllWithContactPoint() {
		List<PartyVO> listParty = partyMapper.getAllWithContactPoint();
		
		listParty.forEach(party -> log.info(party)  );
	}
	
	
//	@Test
	public void testGetAllWithContactPointWithoutLoss() {
		log.info("testGetAllWithContactPointWithoutLoss()");
		List<PartyVO> listParty = partyMapper.getAllWithContactPointWithoutLoss();
		
		listParty.forEach(party -> log.info(party)  );
	}
	
	@Test
	public void testGetAllWithContactPointWithoutLossAndPersonalService() {
		log.info("testGetAllWithContactPointWithoutLossAndPersonalService()");
		List<PartyVO> listParty = partyMapper.getAllWithContactPointWithoutLossAndPersonalService();
		
		listParty.forEach(party -> log.info(party.getId()+" / "+party.getName()+" / "+party.getBirthDate()+" / "+" / "+party.getListContactPoint()+" / "+party.getListHashTag()
		+" / "+party)  );
		
	}
}
