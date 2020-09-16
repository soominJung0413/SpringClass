package www.study.com.party.mapper;

import org.apache.ibatis.annotations.Param;

import www.study.com.party.model.PartyVO;

public interface PartyMapper {
	
	//아이디 기준 가입자 찾기 
	public PartyVO findPartyByLoginId(@Param("loginId")String loginId);
	
	//아이디 기준 연락처포함한 가입자 찾기
	public PartyVO findPartyWithContactPointByLoginId(@Param("loginId")String loginId);
	
	

}
