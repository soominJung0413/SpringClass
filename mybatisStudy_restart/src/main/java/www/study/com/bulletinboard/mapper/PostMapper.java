
/**
 * Mapper 는 Mybaits에 의하여 객체가 만들어 짐. << Proxy
 * 경로지정 : Root-Context에 스캐닝이 필수적임.
 */
package www.study.com.bulletinboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.study.com.bulletinboard.model.PostVO;

public interface PostMapper {

	/**
	 * 아이디로게시글찾고작성자정보포함하기
	 * 
	 * @param postId
	 * @return
	 */
	public List<PostVO> findPostWithWriter(@Param("postId") String postId);

	public PostVO findSomeByTableName(@Param("tableName") String tableName, @Param("postId") String postId);

	public List<PostVO> searchPost(@Param("arrUserSearch") String[] arrUserSearch);

}
