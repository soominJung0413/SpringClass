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
import www.study.com.party.model.PersonVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PostMapperTest {
	@Autowired
	private PostMapper mapper;

	//@Test
	public void testGetAll() {
		try {
			System.out.println("testGetAll()");
			List<ReplyVO> listSimple = mapper.getAll();
			for (ReplyVO simple : listSimple) {
				System.out.println(simple);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAllReply() {
		try {
			System.out.println("\ngetAllReply()");
			List<ReplyVO> listSimple = mapper.getAllReply();
			for (ReplyVO simple : listSimple) {
				System.out.print(simple);
				System.out.println(simple.getWriter());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void insertPost() {
		try {
			System.out.println("\ninsertPost..........");
			
			PersonVO writer =  new PersonVO();
			writer.setId(-10000000);
			BoardVO board = new BoardVO(-1, null);
			PostVO post = new PostVO(writer, "프로그램으로 넣기", "생성", board);
			mapper.insertPost(post);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertReply() {
		try {
			System.out.println("\ninsertReply..........");
			
			PersonVO writer =  new PersonVO();
			writer.setId(-10000001);
			ReplyVO parent = new ReplyVO();
			parent.setHierarchyId("2");

			ReplyVO reply = new ReplyVO(parent, writer, "프로그램으로 댓글 넣기");
			mapper.insertReply(reply);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
