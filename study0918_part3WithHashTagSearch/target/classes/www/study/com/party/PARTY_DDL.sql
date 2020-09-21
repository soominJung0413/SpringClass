drop table t_contact_point;
drop table t_contact_point_type;
drop table t_party;
drop table t_party cascade;



--UltraEdit : 열편집 기능의 강자
--login_id, pwd, name, birth_date, join_date, party_type, gender, is_alive
--탈퇴 기능 : 절대로 Delete가 아닙니다. login_id, name은 남겨두고 나머지는 몽땅 삭제
create table t_party(
	login_id		varchar(50),
	pwd				varchar(200),
	name			varchar(50),
	birth_date		date,
	join_date		date,					--가입일
	party_type		varchar(50),			--person,organization	
	gender			varchar(50),
	is_alive		boolean default true,	--현재 사용중인 계정인가?
	primary key(login_id)
);
--alter table t_party drop column is_alive;
--alter table t_party add column is_alive boolean default true;
--인덱스에 pwd 추가하는 이유는 성능 향상위함
--unique를 통해 인서트할시 하나만 있어야한다. 
--create unique index idx_loginid_party on t_party(login_id, pwd);
	
insert into t_party(login_id, pwd, name, birth_date, join_date, party_type, gender)
	values('a', 'a', '홍길동', '1500.01.01', '2000.01.01', 'PERSON', 'male');
insert into t_party(login_id, pwd, name, birth_date, join_date, party_type, gender)
	values('b', 'b', '이순신', '1500.01.01', '2000.01.01', 'PERSON', 'male');


--연락처 유형
--name, validation_rex
create table t_contact_point_type(
	name			varchar(100) primary key,
	validation_rex  varchar(100)
);
insert into t_contact_point_type (name, validation_rex) 
	values('주소', '\d{3}[\-]\d{3}');
insert into t_contact_point_type (name, validation_rex) 
	values('email', '/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i');
insert into t_contact_point_type (name, validation_rex) 
	values('hand phone', '/^\d{3}-\d{3,4}-\d{4}$/');


--Party별 연락처. 1:N 관계 연습을 위하여 
--party_id, type_name, contact_point
create table t_contact_point(
	party_id		varchar(50),		-- 1:N 나는 어디에 달려있어요
	type_name		varchar(50),
	contact_point	varchar(50),
	primary key(party_id, type_name)
);

insert into t_contact_point(party_id, type_name, contact_point) 
	values('a', '주소', '한양');
insert into t_contact_point(party_id, type_name, contact_point) 
	values('a', 'email', 'old@한양.com');
insert into t_contact_point(party_id, type_name, contact_point) 
	values('b', '주소', '한양');
insert into t_contact_point(party_id, type_name, contact_point) 
	values('b', 'email', 'old@한양.com');










	 