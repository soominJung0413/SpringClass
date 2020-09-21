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
import www.study.com.search.model.HashtagVO;

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
	@Test
	public void test_aa_findPostWithWriter() {
		try {
			PostVO post =  postMapper.findPostWithWriter("가1");
			System.out.println(post);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_ab_searchPost() {
		try {
			SearchCriteria cri = new SearchCriteria(1, "가을 봄");

			List<ReplyVO> listSerachResult = postMapper.getPostByPaging(cri);
		
			for (ReplyVO post : listSerachResult) {
				System.out.println(post);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
