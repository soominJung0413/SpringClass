package www.study.com.search.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.study.com.bulletinboard.model.PostVO;
import www.study.com.search.model.HashtagVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//테스트 순서는 이름 오름차순으로
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HashtagMapperTest {
	
	@Autowired
	private HashtagMapper hashtagMapper;
	
	/**
	 * 목록으로 주어진 정보 일괄 등록
	 */
	@Test
	public void test_bb_createByBrutal() {
		try {
			List<HashtagVO> list = new ArrayList<>();
			list.add(new HashtagVO("여름", null));
			list.add(new HashtagVO("가을", null));
			list.add(new HashtagVO("행복", null));
			list.add(new HashtagVO("겨울", null));

			//고민거리 
			//등록하자마자 ID가 필요한 경우
			//반복문을 활용하지 않고 Mybatis의 내부 반복문을 통하여 성능을 높일 것임
			for (HashtagVO tag : list) {
				int cnt = hashtagMapper.createHashtag(tag);  //몇개 생성했는지
				System.out.println(tag);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
	
}







