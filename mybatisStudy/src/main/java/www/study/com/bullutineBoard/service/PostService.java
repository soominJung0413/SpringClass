package www.study.com.bullutineBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import www.study.com.bullutineBoard.mapper.PostMapper;
import www.study.com.bullutineBoard.model.PostVO;
import www.study.com.bullutineBoard.model.ReplyVO;
import www.study.com.framework.model.Criteria;
import www.study.com.framework.util.Pair;

@Service
public class PostService {
	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper;

	public List<ReplyVO> getAll() {
		return mapper.getAll();
	}
	public List<ReplyVO> getAllReply() {
		return mapper.getAllReply();
	}
	
	public Pair<List<ReplyVO>, Integer> getPostByPaging(Criteria criteria){
		return new Pair<>(mapper.getPostByPaging(criteria), mapper.countTotalPost(criteria));
	};
	
	public int insertPost(PostVO obj) {
		return mapper.insertPost(obj);
	}
	
	public int insertReply(ReplyVO obj) {
		return mapper.insertReply(obj);
	}
	
	public ReplyVO findById(String hierarchyId) {
		return mapper.findById(hierarchyId);
	}
	
	public int updatePost(PostVO post) {
		return mapper.updatePost(post);
	}
	
	public void removePost(PostVO post) {
		mapper.removePost(post);
	}

}
