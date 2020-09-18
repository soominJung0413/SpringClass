/**
 * Mapper는 Mybatis에 의하여 객체가 만들어져야 합니다.
 * 따라서 root_context.xml에 등재가 필수적입니다.
 */
package www.study.com.bulletinboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.study.com.bulletinboard.model.PostVO;
import www.study.com.bulletinboard.model.ReplyVO;

public interface PostMapper {
	public PostVO findPostWithWriter(@Param("postId") String postId);

	//public List<PostVO> searchPost(@Param("arrUserSearch") String[] arrUserSearch);
	public List<ReplyVO> searchPost(@Param("arrUserSearch") String[] arrUserSearch);

}

