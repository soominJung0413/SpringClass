/**
 * Mapper는 Mybatis에 의하여 객체가 만들어져야 합니다.
 * 따라서 root_context.xml에 등재가 필수적입니다.
 */
package www.study.com.bulletinboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.study.com.bulletinboard.model.PostVO;
import www.study.com.bulletinboard.model.ReplyVO;
import www.study.com.framework.model.Criteria;

public interface PostMapper {
	//List 조회, Single 조회, Create, update, delete
	public List<ReplyVO> getPostByPaging(@Param("criteria") Criteria criteria);
	public long countTotalPost(@Param("criteria") Criteria criteria);

	public PostVO findPostWithWriter(@Param("postId") String postId);
	
	public int createPost(@Param("post") PostVO post);
	
	public int updatePost(@Param("post") PostVO post);
	
	public int deletePost(@Param("hierarchyId") String hierarchyId);

}

