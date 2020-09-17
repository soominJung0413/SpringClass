package www.study.com.bulletinboard.model;

import java.util.ArrayList;
import java.util.List;

import www.study.com.search.model.HashTagVO;

public class PostVO extends ReplyVO {
	private String title; // 글 제목

	private List<String> listHashTagString = new ArrayList<String>(); // "봄 여름 여름 가을"

	// 연관된 객체사이의 정보. = 연관정보 <<<<<
	private BulletinBoardVO board; // 게시판 타입

	public PostVO(String hierarchyId, String content) {
		super(hierarchyId, content);
	}

	@Override
	public String toString() {
		return "PostVO [title=" + title + ", board=" + board + ", " + super.toStringPropOnly();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BulletinBoardVO getBoard() {
		return board;
	}

	public void setBoard(BulletinBoardVO board) {
		this.board = board;
	}

	// 주어진 정보로 모든 필요한 것이 제공되면 이름이 받는 곳에서 처리한다.
	public void setListHashTagString(String strHashTagString) {
		for (String aHashTag : strHashTagString.split(" ")) {
			listHashTagString.add(aHashTag);
		}
	}

	// Mutable : 변경하다 <<< 마음대로 바꿀 수 있다. / Immutable : 변경불가능한
	/**
	 * Mutable 받는 쪽에서 마음대로 추가하더라도 나에게는 영향이 없다.
	 * 
	 * @return
	 */
	public List<HashTagVO> getMutableListHashTagString() {
		List<HashTagVO> ret = new ArrayList<>();
		for (String aStr : listHashTagString) {
			ret.add(new HashTagVO(aStr, null));
		}
		return ret; // 리스트를 주어서 새로만들 수 도 있다. 언제나 새로 받아줘야하기에 값을 마음껏 바꿀 수 있어야한다.
	}

}
