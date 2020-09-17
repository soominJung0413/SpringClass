package www.study.com.search.model;

public class HashTagVO {

	private Long id;
	private String tag; // 핵심어
	private String descript; // 설명

	public HashTagVO(String tag, String descript) {
		this.tag = tag;
		this.descript = descript;
	}

	@Override
	public String toString() {
		return "HashTagVO [id=" + id + ", tag=" + tag + ", descript=" + descript + "]";
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
		HashTagVO other = (HashTagVO) obj;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
