package www.study.com.bulletinboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import www.study.com.bulletinboard.mapper.PostMapper;
import www.study.com.bulletinboard.model.ReplyVO;
import www.study.com.framework.model.Criteria;
import www.study.com.framework.util.Pair;

@Service
public class PostService {
	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper;

	public Pair<List<ReplyVO>, Long> getPostByPaging(Criteria criteria) {
		List<ReplyVO> list = mapper.getPostByPaging(criteria);
		long tot = mapper.countTotalPost(criteria);
		return new Pair<>(list, tot);
	};
}
