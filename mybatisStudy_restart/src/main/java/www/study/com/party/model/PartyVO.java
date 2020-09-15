package www.study.com.party.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 스프링 MVC 가 객체를 생성할때는 아무것도 없는 생성자가 필요함
public abstract class PartyVO {
	// 상위 클래스 항목 조차도 private 설정하는 이유는 캡슐화 ,은닉, 모듈화
	private String loginId; // 사용자 아이디
	private String pwd; // 사용자 암호
	private String name; // 이름
	private Date birthDate; // 생일 창립일
	private Date joinDate; // 가입일

	private List<ContactPointVO> listContactPoint;

	// 마이바티스 생성자 호출을 위한 생성자
	public PartyVO(String loginId, String pwd) {
		this.loginId = loginId;
		this.pwd = pwd;
	}

	// 직렬화 시 연속 재귀 호출으로 무한루프에 빠져서 시스템날라감 . toString() 꼭 확인
	// 객체 정보를 문자열로 표현, JSON에서 주요하게 활용 됨
	@Override
	public String toString() {
		return "PartyVO [loginId=" + loginId + ", pwd=" + pwd + ", name=" + name + ", birthDate=" + birthDate
				+ ", joinDate=" + joinDate + ", listContactPoint=" + listContactPoint + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public List<ContactPointVO> getListContactPoint() {
		return listContactPoint;
	}

	public void setListContactPoint(List<ContactPointVO> listContactPoint) {
		this.listContactPoint = listContactPoint;
	}

}
