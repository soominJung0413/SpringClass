package www.study.com.bullutineBoard.mapper;

import java.util.List;

import www.study.com.bullutineBoard.model.PostVO;
import www.study.com.bullutineBoard.model.ReplyVO;
import www.study.com.framework.model.Criteria;

public interface PostMapper {
	//태그에 따른 글 목록
	public List<PostVO> findPostBySearch(String[] arrSeachWords);
	
	public List<ReplyVO> getAll();
	public List<ReplyVO> getAllReply();
	public int countTotalPost(Criteria criteria);
	public List<ReplyVO> getPostByPaging(Criteria criteria);
	
	public ReplyVO findById(String hierarchyId);
	
	public int insertPost(PostVO obj);
	public int insertReply(ReplyVO obj);
	
	public int updatePost(PostVO post);
	
	public void removePost(PostVO post);

}
