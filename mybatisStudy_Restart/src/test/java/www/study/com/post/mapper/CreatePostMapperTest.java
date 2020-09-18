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
import www.study.com.party.model.PartyVO;
import www.study.com.party.model.PersonVO;
import www.study.com.search.mapper.HashtagMapper;
import www.study.com.search.model.HashtagVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//테스트 순서는 이름 오름차순으로
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreatePostMapperTest {

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private HashtagMapper hashtagMapper;

	@Test
	public void test_bb_createPostWithHashtag() {
		try {

			PartyVO writer = new PersonVO("a", null);
			PostVO post = new PostVO(-1, "JUnit 테스트 제목", "즐거운 개발자", writer);
			post.setStrHashtag("Junig 테스트 제목 개발자");
			postMapper.createPost(post);

			post.setStrHashtag("가을 낙엽");
			List<HashtagVO> listHashtag = post.getMutableListHashtagString(); // .getListHashtagString();
			List<HashtagVO> listFound = hashtagMapper.findExist(listHashtag);
			listHashtag.removeAll(listFound);

			for (HashtagVO tag : listHashtag) {
				hashtagMapper.createHashtag(tag);
			}

			listHashtag.addAll(listFound);
			hashtagMapper.createMapping2Post(post.getHierarchyId(), listHashtag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
