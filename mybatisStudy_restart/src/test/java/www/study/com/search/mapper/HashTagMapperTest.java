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

import www.study.com.search.model.HashTagVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HashTagMapperTest {

	@Autowired
	private HashTagMapper hashTagMapper;

//	@Test
	public void testExists() {
		System.out.println(hashTagMapper);
	}

	// R C U D 순 으로 개발
	@Test
	public void test_bb_createByBrutal() {
		try {
			List<HashTagVO> tagList = new ArrayList<>();
			tagList.add(new HashTagVO("안녕", null));
			tagList.add(new HashTagVO("자바", null));
			tagList.add(new HashTagVO("기저귀", null));
			tagList.add(new HashTagVO("강아지", null));

			tagList.add(new HashTagVO("헬로", null));
			tagList.add(new HashTagVO("가을", null));
			tagList.add(new HashTagVO("행복", null));
			tagList.add(new HashTagVO("겨울", null));
			// 고민거리 .. 상충이라 같이 적용 불가함
			// 등록하자마자 ID가 필요한 경우가 있음
			// 반복문을 활용하지 않고 MyBatis 의 forEach 태그를 통해 성능 향상을 꾀하는 방법.

			for (HashTagVO tag : tagList) {
				int cnt = hashTagMapper.createHashTag(tag);
				System.out.println(tag);
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
