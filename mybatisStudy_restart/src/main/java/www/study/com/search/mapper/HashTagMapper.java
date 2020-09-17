package www.study.com.search.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.study.com.search.model.HashTagVO;

public interface HashTagMapper {

	public int createHashTag(@Param("tagObj") HashTagVO tag);

	public List<HashTagVO> findExist(@Param("listHashTag") List<HashTagVO> listHashTag);

	public int createMapping2Post(@Param("hierarchyId") String hierarchyId,
			@Param("listHashTag") List<HashTagVO> listHashTag);

}
