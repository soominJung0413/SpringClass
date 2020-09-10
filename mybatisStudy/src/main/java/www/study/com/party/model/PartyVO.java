package www.study.com.party.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
/*
 * POJO plain(순전한) old java object
 * Default Constructor 필수 있어야합니다.
 * get~, set~ 함수가 있어야 함
 */
@Data
public abstract class PartyVO {
	private int id;
	private String name;
	private Date birthDate;
	
	/** 연락처 목록(1:N - 나에게 여러 개가 있습니다.) */
	private List<ContactPointVO> listContactPoint;
	
	/** 개인화 서비스 처리 용도 목록(N:M - 나에게 여러 개가 있습니다. 그런데 너에게도 여러개가 있습니다. 따라서 중간 매개 테블도 있어요) */
	private List<HashTagVO> listHashTag;
	
	public PartyVO() {}
	
	public PartyVO(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
		listContactPoint = new ArrayList<>();
	}

	public void addContactPoint(ContactPointVO obj) {
		obj.setId(id);
		listContactPoint.add(obj);
	}
	
	public List<ContactPointVO> getListContactPoint() {
		return listContactPoint;
	}

	public List<HashTagVO> getListHashTag() {
		return listHashTag;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setListContactPoint(List<ContactPointVO> listContactPoint) {
		this.listContactPoint = listContactPoint;
	}

	public void setListHashTag(List<HashTagVO> listHashTag) {
		this.listHashTag = listHashTag;
	}

	@Override
	public String toString() {
		return "PartyVO [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
