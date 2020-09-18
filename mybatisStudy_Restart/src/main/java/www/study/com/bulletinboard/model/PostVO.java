package www.study.com.bulletinboard.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import www.study.com.party.model.PartyVO;
import www.study.com.search.model.HashtagVO;

@Setter
@Getter
public class PostVO extends ReplyVO {
	private String title; // 제목
	private long boardId; // 게시판

	private List<String> listHashtagString = new ArrayList<String>(); // "봄 여름 가을"

	public PostVO(int boardId, String title, String content, PartyVO writer) {
		super(content, writer);
		this.boardId = boardId;
		this.title = title;
	}

	/**
	 * Called by Mybatis
	 * 
	 * @param loginId
	 * @param pwd
	 */
	public PostVO(String hierarchyId) {
		super(hierarchyId);
	}

	/* 주어진 정보로 모든 필요한 것이 제공이되면 이를 받는 곳에서 처리 */
	public void setStrHashtag(String strHashtag) {
		for (String aHashtag : strHashtag.split(" ")) {
			listHashtagString.add(aHashtag);
		}
	}

	/**
	 * Mutable : 받은 쪽에서 마음대로 추가,삭제하더라도 나에게는 영향이 없다.
	 * 
	 * @return
	 */
	public List<HashtagVO> getMutableListHashtagString() {
		List<HashtagVO> ret = new ArrayList<>();
		for (String aStr : listHashtagString) {
			ret.add(new HashtagVO(aStr, null));
		}
		return ret;
	}

	@Override
	public String toString() {
		return "PostVO [" + toStringPropOnly() + ", title=" + title + ",  toString()=" + super.toString() + "]";
	}

}
