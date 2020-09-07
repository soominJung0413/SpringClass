package www.study.com.orm.party.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
public abstract class PartyVO {
	
	private int id;
	private String name;
	private Date birthDate;
	
	/** 연락처 목록(1:N 관계로 가져옴) */
	private List<ContactPointVO> listContactPoint;
	
	/** 개인화 서비스 처리 용도 목록(N:M 관계로 가져옴 , 두개다 다수의 데이터가 존재함, 따라서 중간매개 테이블도 있다.) */
	private List<HashTagVO> listHashTag;
	
}
