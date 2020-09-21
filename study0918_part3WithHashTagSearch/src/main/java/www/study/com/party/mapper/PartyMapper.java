package www.study.com.party.mapper;

import org.apache.ibatis.annotations.Param;

import www.study.com.party.model.PartyVO;

public interface PartyMapper {
	
	//가시성, 명시화 
	/** 사용자아이디바탕으로찾기 */
	public PartyVO findPartyByLoginId(@Param("loginId") String loginId);
	/** 사용자를연락처까지함께아이디바탕으로찾기 */
	public PartyVO findPartyWithContactPointByLoginId(@Param("loginId") String loginId);
	/** 사용자탈퇴 */
	public int secessionParty(@Param("loginId") String loginId);

}
