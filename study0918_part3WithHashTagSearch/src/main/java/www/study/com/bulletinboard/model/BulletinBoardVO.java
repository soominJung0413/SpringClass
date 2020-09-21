package www.study.com.bulletinboard.model;

public class BulletinBoardVO {
	private long id; 			//아이디
	private String name;		//이름(게시판)
	
	public BulletinBoardVO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
