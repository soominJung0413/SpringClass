drop t_post;
drop t_bulletin_board;



--게시판 : 자유게시판, 공지사항, FAQ, ...
--id, name
create table t_bulletin_board (
	id				bigint, 			--long
	name			varchar(50),
	primary key(id)
);
insert into t_bulletin_board (id, name)
	values(-1, '자유게시판');
	
	
--게시글
--hierarchy_id, writer_id, content, post_type, bb_id, title		
create table t_post (
	hierarchy_id	varchar(2000),
	writer_id		varchar(50),
	content			varchar(2000),
	reg_date		timestamp default current_timestamp,			--등록일 년월일시분초
	update_date		timestamp default current_timestamp,			--수정일 년월일시분초
	post_type		varchar(50),		--POST, Reply
	bb_id			bigint,
	title			varchar(500),
	primary key(hierarchy_id)
);

alter table add t_post	CONSTRAINT FK_post_bb FOREIGN KEY(bb_id) REFERENCES t_bulletin_board(id);
alter table add t_post	CONSTRAINT FK_post_party FOREIGN KEY(writer_id) REFERENCES t_party(login_id);

--게시글 테스트 데이타
insert into t_post (hierarchy_id, bb_id, writer_id, post_type, title, content)
	values('가1', -1, 'a', 'POST', '안녕', '하세요');
insert into t_post (hierarchy_id, bb_id, writer_id, post_type, title, content)
	values('가2', -1, 'a', 'POST', '고갱님', '많이 사세요');








