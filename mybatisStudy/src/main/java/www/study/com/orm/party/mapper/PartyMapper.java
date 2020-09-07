package www.study.com.orm.party.mapper;

import java.util.List;

import www.study.com.orm.party.model.PartyVO;

public interface PartyMapper {
	
	public List<PartyVO> getAll();
	
	public List<PartyVO> getAllWithContactPoint();
	
	public List<PartyVO> getAllWithContactPointWithoutLoss();
	
	public List<PartyVO> getAllWithContactPointWithoutLossAndPersonalService();
	
	public List<PartyVO> getAllPerson(); 
	
}
