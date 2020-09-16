
/**
 * Mapper 는 Mybaits에 의하여 객체가 만들어 짐. << Proxy
 * 경로지정 : Root-Context에 스캐닝이 필수적임.
 */
package www.study.com.bulletinboard.mapper;

import org.apache.ibatis.annotations.Param;

import www.study.com.bulletinboard.model.PostVO;

public interface PostMapper {

	public PostVO findPostWithWriter(@Param("postId")String postId);

}
