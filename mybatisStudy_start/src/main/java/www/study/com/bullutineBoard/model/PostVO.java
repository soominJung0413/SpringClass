package www.study.com.bullutineBoard.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import www.study.com.hashtag.model.HashtagVO;
import www.study.com.party.model.HashTagVO;
import www.study.com.party.model.PersonVO;

@Data
public class PostVO extends ReplyVO {
	@Getter
	private String title;
	private BoardVO board;
	
	private List<HashtagVO> listHashTag = new ArrayList<>();//글은 해시태그 목록값을 가짐
	
	public PostVO() {}
	
	public PostVO(PersonVO writer, String content, String title, BoardVO board) {
		super(null, writer, content);
		this.title = title;
		this.board = board;
	}
	
	
	/*"자바 인사 안부 오늘" 같은 형식 잘라서 저장할 것임
*/	public PostVO(PersonVO writer, String content, String title, BoardVO board, String allTag) {
		super(null, writer, content);
		this.title = title;
		this.board = board;
		for(String tag : allTag.split(" ")) {
			listHashTag.add(new HashtagVO(tag));
		};
	}

	@Override
	public String toString() {
		return "PostVO [" + toSimpleString() + ", title=" + title + ", board=" + board + "]";
	}
	
	
}
