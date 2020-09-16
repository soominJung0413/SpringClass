package www.study.com.bulletinboard.model;

public class PostVO extends ReplyVO{
	private String title; // 글 제목	
	
	//연관된 객체사이의 정보. = 연관정보 <<<<<
	private BulletinBoardVO board; // 게시판 타입

	@Override
	public String toString() {
		return "PostVO [title=" + title + ", board=" + board + ", " + super.toStringPropOnly() ;
	}
	
	
}
