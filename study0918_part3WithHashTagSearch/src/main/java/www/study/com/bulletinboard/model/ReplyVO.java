package www.study.com.bulletinboard.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import www.study.com.party.model.PartyVO;

public class ReplyVO {
	@Getter @Setter
	private String hierarchyId;			//계층구조에 따른 아이디
	@Getter @Setter
	private String content;				//댓글내용
	@Getter
	private Date regDate;				//등록일 년월일시분초
	@Getter
	private Date updateDate;			//등록일 년월일시분초	

	//연관된 객체 사이의 정보(연관정보)
	@Getter @Setter
	private PartyVO writer;				//작성자

	public ReplyVO() {}
	
	public ReplyVO(String content, PartyVO writer) {
		this.content = content;
		this.writer = writer;
	}

	public ReplyVO(String hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	@Override
	public String toString() {
		return "ReplyVO [hierarchyId=" + hierarchyId + ", content=" + content + ", writer=" + writer + "]";
	}
	
	protected String toStringPropOnly() {
		return "hierarchyId=" + hierarchyId + ", writer=" + writer;
	}
	
	
}
