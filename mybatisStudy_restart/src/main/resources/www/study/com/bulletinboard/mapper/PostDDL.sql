drop table t_bulletin_board;


--게시판 : 자유게시판, 공지사항, FAQ, ...
-- id, name
create table t_bulletin_board (
	id				bigint, -- 8byte
	name			varchar2,
	primary key(id)
);
insert into t_bulletin_board (id, name)
	values(-1, '자유게시판');
	
	--게시글
-- hierarchy_id	,writer_id ,content ,post_type ,bb_id ,title
create table t_post (
	hierarchy_id	varchar(2000),
	writer_id		varchar(50),
	content			varchar(2000),
	reg_date		datetime,			--등록일 연 월 일 시 분 초 단위
	update_date		datetime,			--수정일 연 월 일 시 분 초 단위
	post_type		varchar(50),		--POST, Reply
	bb_id			bigint,
	title			varchar(500),
	primary key(hierarchy_id),
	CONSTRAINT FK_post_bb FOREIGN KEY(bb_id) REFERENCES t_bulletin_board(id),
	CONSTRAINT FK_post_party FOREIGN KEY(writer_id) REFERENCES t_party(login_id)
);

--게시글 테스트 데이타
insert into t_post (hierarchy_id, bb_id, writer_id, post_type, title, content)
	values('1', -1, 'a', 'POST', '안녕', '하세요');
insert into t_post (hierarchy_id, bb_id, writer_id, post_type, title, content)
	values('2', -1, 'a', 'POST', '호갱님', '많이 사세요');