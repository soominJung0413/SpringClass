package www.study.com.party.mapper;

import org.apache.ibatis.annotations.Param;

import www.study.com.party.model.PartyVO;

public interface PartyMapper {

	/**
	 * 아이디 기준 가입자 찾기
	 * 
	 * @param loginId
	 * @return
	 */
	public PartyVO findPartyByLoginId(@Param("loginId") String loginId);

	/**
	 * 아이디 기준 연락처포함한 가입자 찾기
	 * 
	 * @param loginId
	 * @return
	 */
	public PartyVO findPartyWithContactPointByLoginId(@Param("loginId") String loginId);

	/**
	 * 사용자 탈퇴
	 * 
	 * @param loginId
	 * @return
	 */
	public int secessionParty(@Param("loginId") String loginId);

	/**
	 * 탈퇴유저 연락처 삭제
	 * 
	 * @param loginId
	 * @return
	 */
	public int deleteContactPointById(@Param("loginId") String loginId);

}
