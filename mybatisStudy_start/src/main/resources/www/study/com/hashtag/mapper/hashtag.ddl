drop SEQUENCE seq4hashtag;
CREATE SEQUENCE seq4hashtag;

drop table m_post2tag;
drop table t_hashtag;

--주요 단어 집
--id, tag, descript
create table t_hashtag (
	id				number(10),
	aid				number(10),--분류
	eid				number(10),--소유
	tag			varchar2(50),
	descript varchar(1000),
	primary key(id)--동음이의어 문제로 tag단어는 PK는 불가함
);
create index idx_tag on t_hashtag(tag, id);--검색을 위해서 인덱스를 추가해줌

create table t_Rhashtag (
	fid				number(10),
	sid				number(10),--분류
);

--게시글에 등재된 핵심단어
create table m_post2tag (
	tag_id	number(10),
	post_id varchar2(2000),
	primary key(tag_id, post_id) --단어로 글을 찾아 들어가는 순서
);
create index idx_post2tag on m_post2tag(post_id, tag_id); --인덱스로 모든 정보를 가져올 수있게되므로 인덱스만 거침 조인결과에 인덱스를 고려해야함

