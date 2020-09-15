package www.study.com.hashtag.mapper;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import www.study.com.bullutineBoard.mapper.PostMapper;
import www.study.com.bullutineBoard.model.PostVO;
import www.study.com.hashtag.model.HashtagVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//테스트 순서 정하는 에노테이션 이름 오름차순
@Log4j
public class HashtagMapperTest {
	
	@Autowired
	private HashtagMapper hashtagMapper;
	
	@Autowired
	private PostMapper postMapper;


//	@Test
	public void test_ccc_createPost() {
		try {
		System.out.println("\ntest_ccc_createPost()");
		PostVO postVo = new PostVO(null,"행복한 하루 보내고 있습니다.","즐거운 학습",null,"자바 안부 인사 오늘");
		List<HashtagVO> listTagOfPost = postVo.getListHashTag();
		List<HashtagVO> hashTagVos = hashtagMapper.findExists(listTagOfPost);
		hashTagVos.forEach( item -> System.out.println("데이터베이스에 저장된단어 : "+item) );
		
		//관리되던 단어와 짝을 지어야하는데 , 새롭게 발견된 단어들은 만들고 짝을 지어야함
		listTagOfPost.removeAll(hashTagVos);//중첩되는 단어 삭제
		//removeAll 의 삭제할 비교조건은 equal메서드 기준임 
		
		listTagOfPost.forEach( item -> System.out.println("삭제되고 남은 애들"+item));
		
		for( HashtagVO obj : listTagOfPost) {
			hashtagMapper.createTag(obj);
		}
		//삭제되고 남은 애들 인서트
		hashTagVos.addAll(listTagOfPost);
		hashtagMapper.createMappingPostTag("5U", hashTagVos);
		
		assertThat(hashTagVos.size(), Is.is(2));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_ddd_searchPost() {
		try {
		System.out.println("\ntest_ddd_searchPost");
		
		String searchWords = "자바 오늘 강아지";
		
		String[] arrSeachWords = searchWords.split(" ");
		
		List<PostVO> listPost = postMapper.findPostBySearch(arrSeachWords);
		
		listPost.forEach( item -> System.out.println(item.toString()) );
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
