package www.study.com.bullutineBoard.model;

import lombok.Data;
import lombok.Getter;
import www.study.com.party.model.PartyVO;
import www.study.com.party.model.PersonVO;

@Data
public class PostVO extends ReplyVO {
	@Getter
	private String title;
	private BoardVO board;
	
	public PostVO() {}
	
	public PostVO(PersonVO writer, String content, String title, BoardVO board) {
		super(null, writer, content);
		this.title = title;
		this.board = board;
	}

	@Override
	public String toString() {
		return "PostVO ["+toSimpleString()+", title=" + title + ", board=" + board + "]";
	}
	
	
}
