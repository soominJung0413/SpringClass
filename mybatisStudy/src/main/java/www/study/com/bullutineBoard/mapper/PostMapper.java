package www.study.com.bullutineBoard.mapper;

import java.util.List;

import www.study.com.bullutineBoard.model.PostVO;
import www.study.com.bullutineBoard.model.ReplyVO;

public interface PostMapper {
	public List<ReplyVO> getAll();
	public List<ReplyVO> getAllReply();
	
	public int insertPost(PostVO obj);
	public int insertReply(ReplyVO obj);
	public ReplyVO findById(String hierarchyId);
	public int updatePost(PostVO post);
}
