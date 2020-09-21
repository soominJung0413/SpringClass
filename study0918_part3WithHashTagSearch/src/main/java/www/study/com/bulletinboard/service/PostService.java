package www.study.com.bulletinboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import www.study.com.bulletinboard.mapper.PostMapper;
import www.study.com.bulletinboard.model.PostVO;
import www.study.com.bulletinboard.model.ReplyVO;
import www.study.com.framework.model.Criteria;
import www.study.com.framework.util.Pair;
import www.study.com.search.mapper.HashtagMapper;
import www.study.com.search.model.HashtagVO;

@Service
public class PostService {
	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper;
	
	@Autowired
	private HashtagMapper hashtagMapper;
	
	/*
	 * class ForRet{
	 * 		AVO a;
	 * 		BVO b;
	 * ....
	 *  
	 */
	/* 여러 종류 정보를 return 해 주어야 할 때 가능한 방안들에는?
	 * 1. 반환용 객체 만듦.    10
	 * 2. Map<String, Object>  유지보수성이 극악해짐. 1
	 * 3. Pair, Triple, Quad<A, B, C, D> Pair<Pair, Triple>
	 * 
	 */
	public Pair<List<ReplyVO>, Long> getPostByPaging(Criteria criteria) {
		List<ReplyVO> list = mapper.getPostByPaging(criteria);
		long tot = mapper.countTotalPost(criteria);
		return new Pair<>(list, tot);
	}

	public void insertPost(PostVO post) {
		mapper.createPost(post);
		makeRelBetweenHashTag(post);
	}

	public ReplyVO findById(String hierarchyId) {
		return mapper.findPostWithWriter(hierarchyId);
	}

	public void updatePost(PostVO post) {
		int cnt = mapper.updatePost(post);
		makeRelBetweenHashTag(post);
	}

	public void removePost(String hierarchyId) {
		int cnt = mapper.deletePost(hierarchyId);
		hashtagMapper.clearMapping2Post(hierarchyId);
	}

	//해쉬 태그 등록과 관계 정보 수립
	private void makeRelBetweenHashTag(PostVO post) {
		hashtagMapper.clearMapping2Post(post.getHierarchyId());
		List<HashtagVO> listTag = new ArrayList<>();
		for (String tag : post.getHashtag().split(" ")) {
			listTag.add(new HashtagVO(tag, null));
		}
		List<HashtagVO> listFound = hashtagMapper.findExist(listTag);
		listTag.removeAll(listFound);
		
		List<HashtagVO> listNew = listTag;
		for (HashtagVO newTag : listNew)
			hashtagMapper.createHashtag(newTag);
		
		listNew.addAll(listFound);
		hashtagMapper.createMapping2Post(post.getHierarchyId(), listNew);
	}
}
