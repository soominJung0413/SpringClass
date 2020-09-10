package www.study.com.bullutineBoard.model;

import lombok.Data;
import lombok.Getter;
import www.study.com.party.model.PartyVO;
import www.study.com.party.model.PersonVO;

@Data
public class ReplyVO {
	private static final char HID_DELI = '-';
	@Getter
	private String hierarchyId;
	private PersonVO writer;
	@Getter
	private String content;
	
	private ReplyVO parent;
	
	public ReplyVO() {}

	public ReplyVO(ReplyVO parent, PersonVO writer, String content) {
		this.parent = parent;
		this.writer = writer;
		this.content = content;
	}

	public char getHidDeli() {
		return HID_DELI;
	}
	
	public PartyVO getWriter() {
		return writer;
	}

	public ReplyVO getParent() {
		return parent;
	}

	public void setHierarchyId(String hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	@Override
	public String toString() {
		return "ReplyVO [hierarchyId=" + hierarchyId + ", writer=" + writer + ", content=" + content + "]";
	}
	
	
	protected String toSimpleString() {
		return "hierarchyId=" + hierarchyId;
	}
}
