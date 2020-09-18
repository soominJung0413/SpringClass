package www.study.com.post.mapper;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.bulletinboard.mapper.PostMapper;
import www.study.com.bulletinboard.model.PostVO;
import www.study.com.bulletinboard.model.ReplyVO;
import www.study.com.framework.model.SearchCriteria;
import www.study.com.search.mapper.HashtagMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//테스트 순서는 이름 오름차순으로
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostMapperTest {

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private HashtagMapper hashtagMapper;

	/**
	 * 아이디로게시글찾기작성자정보와함께
	 */
//	@Test
	public void test_aa_findPostWithWriter() {
		try {
			PostVO post = postMapper.findPostWithWriter("a1");
			System.out.println(post);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시글 등록시 N:M 관계 정보 생성을 위하여 HashTag 정보 목록까지 함께 등록
	 */
//	@Test
	/*
	 * public void test_bb_createPostWithHashtag() { try { PostVO post = new
	 * PostVO("가1", "오늘도 어렵게"); post.setTitle("안녕"); PartyVO writer = new
	 * PersonVO("a", null); post.setWriter(writer); post.setStrHashtag("가을 낙엽");
	 * List<HashtagVO> listHashtag = post.getMutableListHashtagString(); //
	 * .getListHashtagString(); List<HashtagVO> listFound =
	 * hashtagMapper.findExist(listHashtag); listHashtag.removeAll(listFound);
	 * 
	 * for (HashtagVO tag : listHashtag) { hashtagMapper.createHashtag(tag); }
	 * 
	 * listHashtag.addAll(listFound);
	 * hashtagMapper.createMapping2Post(post.getHierarchyId(), listHashtag);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	@Test
	public void test_ab_searchPost() {
		try {
			SearchCriteria criteria = new SearchCriteria(1, "가을, 봄");

			List<ReplyVO> listSearchResult = postMapper.getPostByPaging(criteria);

			for (ReplyVO post : listSearchResult) {
				System.out.println(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
