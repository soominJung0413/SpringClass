package www.study.com.bullutineBoard.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.bullutineBoard.model.BoardVO;
import www.study.com.bullutineBoard.model.PostVO;
import www.study.com.bullutineBoard.model.ReplyVO;
import www.study.com.framework.model.Criteria;
import www.study.com.party.model.PersonVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PostPagingMapperTest {
	@Autowired
	private PostMapper mapper;

	@Test
	public void testGetPostByPaging() {
		try {
			System.out.println("getPostByPaging()");
			List<ReplyVO> listSimple = mapper.getPostByPaging(new Criteria(2,10));
			listSimple.forEach(reply -> {
				System.out.println(reply); 
				System.out.println(reply.getWriter()); 
				}); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
