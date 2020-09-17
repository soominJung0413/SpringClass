package www.study.com.bulletinboard.model;

import java.util.Date;

import www.study.com.party.model.PartyVO;

public class ReplyVO {
	private String hierarchyId;// 계층구조에 따른 아이디
	private String content;// 게시글 내용
	private Date regDate;
	private Date updateDate;

	private PostVO board;

	// 연관된 객체사이의 정보. = 연관정보 <<<<<
	private PartyVO writer; // 1 이 되는 녀석 / 작성자

	public ReplyVO(String hierarchyId, String content) {
		this.hierarchyId = hierarchyId;
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReplyVO [hierarchyId=" + hierarchyId + ", content=" + content + ", writer=" + writer + "]";
	}// 각자 불릴 수 있는 함수이므로 자식용을 따로 만든다.

	protected String toStringPropOnly() {
		return "ReplyVO [hierarchyId=" + hierarchyId + ", writer=" + writer + "]";
	}

	public String getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(String hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public PartyVO getWriter() {
		return writer;
	}

	public void setWriter(PartyVO writer) {
		this.writer = writer;
	}

}
