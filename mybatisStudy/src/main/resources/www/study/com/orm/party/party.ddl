drop sequence seq4_tag;
create sequence seq4_tag;

drop table m_party_hash_tag;
drop table t_hash_tag;
drop TABLE t_contact_point;
drop table t_contact_point_type;
drop table t_party;

--id, name, birth_date,party_type,gender,sales_tot
CREATE TABLE t_party(
	id 				number(10),
	name 			varchar2(50),
	birth_date  	date,
	party_type		varchar2(50),
	gender 			varchar2(50),
	sales_tot		long,
	primary key(id)
);


insert into t_party(id, name, birth_date,party_type,gender) 
	values(-1000000,'홍길동','1500.01.01','PERSON', 'male');
insert into t_party(id, name, birth_date,party_type,gender) 
	values(-1000001,'이순신','1600.01.01','PERSON','male');
	insert into t_party(id, name, birth_date, party_type, sales_tot) 
	values(-2000000,'대한물류','2000.01.01','ORGANIZATION',2999472378235);


--연락처 유형 
CREATE TABLE t_contact_point_type(
	name				varchar2(50) primary key,
	validation_rex		varchar2(50)
);

INSERT INTO t_contact_point_type (name) VALUES('email');
INSERT INTO t_contact_point_type (name) VALUES('address');
INSERT INTO t_contact_point_type (name) VALUES('phone');


CREATE TABLE t_contact_point(
	id 				number(10),   --1:N 구조 나는 어디에 달려있어요
	type_name		varchar2(50),
	t_contact_point	varchar2(50),
	primary key(id, type_name)
);

insert into t_contact_point(id, type_name, t_contact_point) values(-1000000,'주소','한영');
insert into t_contact_point(id, type_name, t_contact_point) values(-1000000,'email','old@한양.서버');



--단어 집.
CREATE TABLE t_hash_tag(
	id 			number(10),  
	name		varchar2(50),
	primary key(id)
);

insert into t_hash_tag (id, name) values(seq4_tag.nextval,'개인화');
insert into t_hash_tag (id, name) values(seq4_tag.nextval,'서비스');

-- 특정 개인이 즐겨찾는 정보 - 개인화 서비스
CREATE TABLE m_party_hash_tag(
	party_id 	number(10),  
	tag_id 		number(10),
	primary key(party_id, tag_id),
	constraint fk_m_partytag_party foreign key (party_id) references t_party(id),
	constraint fk_m_partytag_tag foreign key (tag_id) references t_hash_tag(id)
);

select id
 from t_hash_tag
where name = '개인화';

insert into m_party_hash_tag (party_id,tag_id)
	select -1000000, id
	 from t_hash_tag
	where name = '개인화';
	
insert into m_party_hash_tag (party_id,tag_id)
	select -1000001, id
	 from t_hash_tag
	where name = '서비스';
	
insert into m_party_hash_tag (party_id,tag_id)
	select -1000001, id
	 from t_hash_tag
	where name = '개인화';
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	--id, name, birth_date
CREATE TABLE t_simple(
	id 				number(10),
	name 			varchar2(50),
	birth_date  	date,
	primary key(id)
);
