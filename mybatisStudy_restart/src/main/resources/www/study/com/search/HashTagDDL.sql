-- 검색이라는 프레임워크를 짜는 틀
m_PD_Tag
	targetTable_name -- 테이블 의 수정 삭제 추가에도 대처할 수 있는 방법
	tad_id			
	target			VARCHAR(20000_) -- 숫자도 문자열로 조작가능하므로 이방법이 이로움
	
drop index idx_tag
drop SEQUENCE seq4hashtag;
CREATE SEQUENCE seq4hashtag;

drop table m_post2tag;
drop table t_hashtag;

--주요 단어 집
--id, tag, descript
create table t_hashtag (
	id				bigint,
	tag			varchar(50),
	descript 	varchar(1000),
	primary key(id)--동음이의어 문제로 tag단어는 PK는 불가함
);
create unique index  idx_tag on t_hashtag(tag);--검색을 위해서 인덱스를 추가해줌

--게시글에 등재된 핵심단어
create table m_post2tag (
	tag_id		bigint,
	post_id 	varchar(2000),
	primary key(tag_id, post_id) --단어로 글을 찾아 들어가는 순서
);
create index idx_post2tag on m_post2tag(post_id, tag_id); --인덱스로 모든 정보를 가져올 수있게되므로 인덱스만 거침 조인결과에 인덱스를 고려해야함

