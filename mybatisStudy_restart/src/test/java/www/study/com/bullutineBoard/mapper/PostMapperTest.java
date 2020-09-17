package www.study.com.bullutineBoard.mapper;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.bulletinboard.mapper.PostMapper;
import www.study.com.bulletinboard.model.BulletinBoardVO;
import www.study.com.bulletinboard.model.PostVO;
import www.study.com.party.model.PersonVO;
import www.study.com.search.mapper.HashTagMapper;
import www.study.com.search.model.HashTagVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostMapperTest {

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private HashTagMapper hashTagMapper;

//	@Test
	public void test_aa_아이디로게시글찾고작성자정보포함하기() {
		System.out.println("\n아이디로게시글찾고작성자정보포함하기()");
		try {
			List<PostVO> post = postMapper.findPostWithWriter("1");

			System.out.println("아이디로 게시글과 작성자 정보 찾기 : " + post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 테이블 명칭을 파라메터로 줄테니 거기서 찾아서 정보를 주세요.
//	@Test
	public void test_bb_findSomeByTableName() {
		System.out.println("\nfindSomeByTableName()");
		try {
			PostVO post = postMapper.findSomeByTableName("t_post", "가1");

			System.out.println("아이디로 게시글과 작성자 정보 찾기 : " + post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시글을 등록함에 있어 N :M 관계정보 생성을 위하여 해쉬태그 정보 목록까지 등록한다.
	 */
//	@Test
	public void test_cc_createPostWithHashTag() {
		System.out.println("\ncreatePostWithHashTag()");
		try {
			PostVO post = new PostVO("가2", "오늘도 어렵게");

			BulletinBoardVO boardVO = new BulletinBoardVO(-1L, null);
			post.setTitle("안녕");
			post.setBoard(boardVO);
			PersonVO personVO = new PersonVO("a", null);
			post.setWriter(personVO);

			post.setListHashTagString("가을 낙엽");
			List<HashTagVO> listHashTag = post.getMutableListHashTagString();// 변경가능하게 새로운 리스트 생성
			List<HashTagVO> listFound = hashTagMapper.findExist(listHashTag);
			listFound.forEach(item -> System.out.println(item));
			listHashTag.removeAll(listFound);// equal 메서드 재정의 해야만 비교할 수가 있다!!

			for (HashTagVO checkVo : listHashTag) {
				hashTagMapper.createHashTag(checkVo);
			}

			listHashTag.addAll(listFound);
			hashTagMapper.createMapping2Post(post.getHierarchyId(), listHashTag);// 글번호에 따른 해시테그 목록

			System.out.println("아이디로 게시글과 작성자 정보 찾기 : " + post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_ab_searchPost() {
		System.out.println("\n test_ab_searchPost()");
		try {
			String userSearch = "봄 여름 가을 겨울";
			String[] arrUserSearch = userSearch.split(" ");
			List<PostVO> listSearchResult = postMapper.searchPost(arrUserSearch);

			for (PostVO post : listSearchResult) {
				System.out.println(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
