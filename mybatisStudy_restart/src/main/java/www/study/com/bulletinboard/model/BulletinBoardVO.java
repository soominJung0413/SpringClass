package www.study.com.bulletinboard.model;

public class BulletinBoardVO {
	private Long id; // 게시판 고유번호
	private String name; // 게시판 이름

	public BulletinBoardVO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
