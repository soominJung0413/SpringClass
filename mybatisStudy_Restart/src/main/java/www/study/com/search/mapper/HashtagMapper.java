package www.study.com.search.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.study.com.search.model.HashtagVO;

public interface HashtagMapper {

	public int createHashtag(@Param("tagObj") HashtagVO tag);

	public List<HashtagVO> findExist(@Param("listHashtag") List<HashtagVO> listHashtag);

	public void createMapping2Post(@Param("hierarchyId") String hierarchyId, @Param("listHashtag") List<HashtagVO> listHashtag);

}
