drop SEQUENCE seq4hashtag;
CREATE SEQUENCE seq4hashtag;

drop table m_post2tag;
drop table t_hashtag;

--주요 단어집
--id, tag, descript
create table t_hashtag (
	id				bigint,
	tag				varchar(50),
	descript		varchar(1000),
	primary key(id)
);
--사용자의 검색 시 게시글 찾기 할 때 작동되도록
create unique index idx_tag on t_hashtag(tag);

--게시글에 등재된 핵심어
--tag_id, post_id
create table m_post2tag (
	tag_id				bigint,
	post_id				varchar(2000),
	primary key(tag_id, post_id)
);
--게시글에 달린 Tag 가져오기 할 때 작동되도록
create index idx_post2tag on m_post2tag(post_id, tag_id);

