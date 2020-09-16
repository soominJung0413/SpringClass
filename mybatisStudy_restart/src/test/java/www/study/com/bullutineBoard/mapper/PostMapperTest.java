package www.study.com.bullutineBoard.mapper;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.bulletinboard.mapper.PostMapper;
import www.study.com.bulletinboard.model.PostVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostMapperTest {

	@Autowired
	private PostMapper postMapper;

	@Test
	public void test_aa_아이디로게시글찾고작성자정보포함하기() {
		System.out.println("\n아이디로게시글찾고작성자정보포함하기()");
		try {
			PostVO post = postMapper.findPostWithWriter("1");

			System.out.println("아이디로 게시글과 작성자 정보 찾기 : " + post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
