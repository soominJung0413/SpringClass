package www.study.com.bullutineBoard.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import www.study.com.party.model.HashTagVO;

@Data
@NoArgsConstructor
public class BoardVO {
	private int id;
	private String name;
	
	
	public BoardVO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
