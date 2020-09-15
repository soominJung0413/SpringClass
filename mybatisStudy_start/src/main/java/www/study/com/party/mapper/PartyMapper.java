package www.study.com.party.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.study.com.party.model.ContactPointVO;
import www.study.com.party.model.PartyVO;
import www.study.com.party.model.PersonVO;

public interface PartyMapper {
	public List<PartyVO> getAll();
	public List<PartyVO> getAllWithContactPoint();
	public List<PartyVO> getAllWithContactPointWithoutLoss();
	public List<PartyVO> getAllWithContactPointWithoutLossAndPersonalService();
	
	public List<PartyVO> getAllPerson();
	
	public int insertPerson(PersonVO obj);
//	public int insertOrganization(OrganizationVO obj);
	
	//여러 건을 한번 DB insert all 문장으로 처리하여 -> 성능 향상
	public int insertContactPointByOneshot(@Param("listcp") List<ContactPointVO> listcp);
}
