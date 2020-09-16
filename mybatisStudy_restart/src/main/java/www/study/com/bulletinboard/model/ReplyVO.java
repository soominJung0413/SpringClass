package www.study.com.bulletinboard.model;

import www.study.com.party.model.PartyVO;

public class ReplyVO {
	private String hierarchyId;// 계층구조에 따른 아이디
	private String content;// 게시글 내용
	
	//연관된 객체사이의 정보. = 연관정보 <<<<<
	private PartyVO writer; // 1 이 되는 녀석 / 작성자

	@Override
	public String toString() {
		return "ReplyVO [hierarchyId=" + hierarchyId + ", content=" + content + ", writer=" + writer + "]";
	}//각자 불릴 수 있는 함수이므로 자식용을 따로 만든다.
	
	protected String toStringPropOnly() {
		return "ReplyVO [hierarchyId=" + hierarchyId + ", writer=" + writer + "]";
	}
	
}
