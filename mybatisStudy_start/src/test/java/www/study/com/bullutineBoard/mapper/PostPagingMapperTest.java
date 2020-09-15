package www.study.com.bullutineBoard.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.bullutineBoard.model.ReplyVO;
import www.study.com.framework.model.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PostPagingMapperTest {
	@Autowired
	private PostMapper mapper;

	//@Test
	public void testSearch() {
		try {
			System.out.println("\ntestSearch()");
			List<ReplyVO> listSimple = mapper.getPostByPaging(new SearchCriteria(2, 10, "T", "한글"));
			listSimple.forEach(simple -> {
				System.out.print(simple);
				System.out.println(simple.getWriter());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchByNoCondition() {
		try {
			System.out.println("\nSearchByNoCondition()");
			List<ReplyVO> listSimple = mapper.getPostByPaging(new SearchCriteria(2, 10, "C", "그램"));
			listSimple.forEach(simple -> {
				System.out.print(simple);
				System.out.println(simple.getWriter());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
