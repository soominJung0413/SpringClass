drop table t_contact_point;
drop table t_contact_point_type;
drop table t_party;


--UltraEdit --- 열편집 기능이 매우 뛰어남
--login_id, pwd, name, birth_date, party_type, gender
create table t_party(
   login_id      varchar(50),
   pwd            varchar(200),
   name         varchar(50),
   birth_date      date,
   --가입일  join_date
   join_date date, 
   party_type      varchar(50),
   gender         varchar(50),
   primary key(login_id)
);


insert into t_party(login_id, pwd, name, birth_date, join_date, party_type, gender)
   values('a', 'a','홍길동', '1500.01.01', '2000.01.01', 'PERSON', 'male');


--연락처 유형
-- name, validation_rex
create table t_contact_point_type(
   name         varchar(50) primary key,
   validation_rex  varchar(50)
);

insert into t_contact_point_type (name) values('주소');
insert into t_contact_point_type (name) values('email');
insert into t_contact_point_type (name) values('phone');

--Party별 연락처. 1:N관계 연습을 위하여 별도로 분리
--party_id, type_name, contact_point
create table t_contact_point(
   party_id      varchar(50),   -- 1:N 나는 어디에 달려있어요
   type_name      varchar(50),
   contact_point   varchar(50),
   primary key(party_id, type_name)
);

insert into t_contact_point(party_id, type_name, contact_point) 
   values('a', '주소', '한양');
insert into t_contact_point(party_id, type_name, contact_point) 
   values('a', 'email', 'old@한양.com');