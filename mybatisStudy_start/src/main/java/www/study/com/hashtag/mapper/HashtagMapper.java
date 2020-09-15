package www.study.com.hashtag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.study.com.hashtag.model.HashtagVO;

public interface HashtagMapper {
	
	//List read, Single Detail read, Create, update, delete
	
	//MyBatis XML에서 이름을 명시적으로 사용 하기 위한 에노테이션
	// 명시적, 가독성 고려.
	public List<HashtagVO> findExists(@Param("listTag")List<HashtagVO> listTag);

	public void createTag(HashtagVO obj);
	
	//parameter 개수가 2개이상일시 필수적으로 @Param 에노테이션 필요
	public void createMappingPostTag(@Param("mapId") String id, @Param("listTag") List<HashtagVO> listTag);
	
	
}
