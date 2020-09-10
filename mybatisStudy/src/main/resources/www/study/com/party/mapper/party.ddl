drop SEQUENCE seq4hash_tag;
drop SEQUENCE seq4party;

CREATE SEQUENCE seq4hash_tag;
CREATE SEQUENCE seq4party;

drop table m_party_hash_tag;
drop table t_hash_tag;
drop table t_contact_point;
drop table t_contact_point_type;
drop table t_party;


--id, name, birth_date, party_type, gender, sales_tot
create table t_party(
	id				number(10),
	name			varchar2(50),
	birth_date		date,
	party_type		varchar2(50),
	gender			varchar2(50),
	sales_tot		long,
	primary key(id)
);

insert into t_party(id, name, birth_date, party_type, gender)
	values(-10000000, '홍길동', '1500.01.01', 'PERSON', 'mail');
insert into t_party(id, name, birth_date, party_type, gender) 
	values(-10000001, '이순신', '1600.01.01', 'PERSON', 'mail');
insert into t_party(id, name, birth_date, party_type, sales_tot) 
	values(-20000000, '대한물류', '2000.01.01', 'ORGANIZATION', 2999472378235);

--연락처 유형
create table t_contact_point_type(
	name			varchar2(50) primary key,
	validation_rex  varchar2(50)
);
insert into t_contact_point_type (name) values('주소');
insert into t_contact_point_type (name) values('email');
insert into t_contact_point_type (name) values('phone');

create table t_contact_point(
	id				number(10),	-- 1:N 나는 어디에 달려있어요
	type_name		varchar2(50),
	contact_point	varchar2(50),
	primary key(id, type_name)
);

insert into t_contact_point(id, type_name, contact_point) values(-10000000, '주소', '한양');
insert into t_contact_point(id, type_name, contact_point) values(-10000000, 'email', 'old@한양.서버');

--단어집
create table t_hash_tag(
	id				number(10),
	name			varchar2(50),
	primary key(id)
);

insert into t_hash_tag(id, name) values(seq4hash_tag.nextval, '개인화');
insert into t_hash_tag(id, name) values(seq4hash_tag.nextval, '서비스');

-- 특정 개인이 즐겨찾는 정보 - 개인화 서비스
create table m_party_hash_tag(
	party_id		number(10),
	tag_id			number(10),
	primary key(party_id, tag_id),
	CONSTRAINT FK_m_partytag_Party FOREIGN KEY(party_id) REFERENCES t_party(id),
	CONSTRAINT FK_m_partytag_tag FOREIGN KEY(tag_id) REFERENCES t_hash_tag(id)
);

select id
  from t_hash_tag
 where name = '개인화';

insert into m_party_hash_tag(party_id, tag_id)
	select -10000000, id
	  from t_hash_tag
	 where name = '개인화';
insert into m_party_hash_tag(party_id, tag_id)
	select -10000000, id
	  from t_hash_tag
	 where name = '서비스';

insert into m_party_hash_tag(party_id, tag_id)
	select -10000001, id
	  from t_hash_tag
	 where name = '서비스';

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
--id, name, birth_date
create table t_simple(
	id				number(10),
	name			varchar2(50),
	birth_date		date,
	primary key(id)
);
	 