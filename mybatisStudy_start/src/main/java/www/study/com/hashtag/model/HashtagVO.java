package www.study.com.hashtag.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HashtagVO {
	private int id;
	private String tag;
	private String discript;
	
	/**
	 * 사용자의 추가적인 단어
	 * @param tag
	 */
	public HashtagVO(String tag) {
		super();
		this.tag = tag;
	}
	
	/**
	 * ORM - data load 시점에 활용됨
	 * @param id
	 * @param tag
	 * @param discript
	 */
	public HashtagVO(Integer id, String tag, String discript) {
		super();
		this.id = id;
		this.tag = tag;
		this.discript = discript;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashtagVO other = (HashtagVO) obj;
		if (discript == null) {
			if (other.discript != null)
				return false;
		} else if (!discript.equals(other.discript))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}


	
	
	
	
}
