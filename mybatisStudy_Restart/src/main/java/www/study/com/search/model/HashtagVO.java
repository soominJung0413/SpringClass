package www.study.com.search.model;

public class HashtagVO {

	private long id;
	private String tag; // 검색어,핵심어
	private String descript; // 설명

	public HashtagVO(String tag, String descript) {
		this.tag = tag;
		this.descript = descript;
	}

	@Override
	public String toString() {
		return "HashtagVO [id=" + id + ", tag=" + tag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
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
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

}

//@Override
//public int hashCode() {
//	final int prime = 31;
//	int result = 1;
//	result = prime * result + ((tag == null) ? 0 : tag.hashCode());
//	return result;
//}
