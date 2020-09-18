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
	
	/*
	 * 여러정보를 제네릭클래스로 모듈화하여 하나의 클래스로 리턴하는 방법이다. 방안이 무엇일까.
	 * 1. 반환용 객체를 만든다.									-- 클래스가 필드 값을 가지는 구조, 유연성이 너무 떨어진다. / 10점.
	 * 2. Map 구조에 <String, Object> .					-- 객체의 유형이 Object로 통일되어 캐스팅을 일일히 해야한다. 즉 유지보수성이 극악이다. / 1점
	 * 3. 수만큼의 제네릭 클래스로 모듈화한다.			-- Pair<Pair, Pair> 4개 Pair / Pair<Pair, Type> / Pair<AVO, Pair<BVO, Pair<CVO, DVO>.... 재사용성과 확장기능이 뛰어나며 유지보수성이 좋다. 
	 */
	public Pair<List<ReplyVO>, Integer> getPostByPaging(Criteria criteria) {
		return new Pair<>(mapper.getPostByPaging(criteria), mapper.countTotalPost(criteria));
	}

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
