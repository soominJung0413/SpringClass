drop SEQUENCE seq4post;
CREATE SEQUENCE seq4post;

drop table t_post;
drop table t_bulletin_board;

--게시판 : 자유게시판, 공지사항, FAQ, ...
create table t_bulletin_board (
	id				number(10),
	name			varchar2(50),
	primary key(id)
);
insert into t_bulletin_board (id, name)
	values(-1, '자유게시판');

--게시글
create table t_post (
	hierarchy_id	varchar2(2000),
	writer_id		number(10),
	content			varchar2(2000),
	post_type		varchar2(50),		--POST, REPLY
	bb_id			number(10),
	title			varchar2(500),
	primary key(hierarchy_id),
	CONSTRAINT FK_post_bb FOREIGN KEY(bb_id) REFERENCES t_bulletin_board(id),
	CONSTRAINT FK_post_party FOREIGN KEY(writer_id) REFERENCES t_party(id)
);

--게시글 테스트 데이타
insert into t_post (hierarchy_id, bb_id, writer_id, post_type, title, content)
	values('1', -1, -10000000, 'POST', '안녕', '하세요');
insert into t_post (hierarchy_id, bb_id, writer_id, post_type, title, content)
	values('2', -1, -20000000, 'POST', '호갱님', '많이 사세요');
--댓글 테스트 데이타
insert into t_post (hierarchy_id, writer_id, content)
	values('1-3', -10000001, 'U 2');
insert into t_post (hierarchy_id, writer_id, content)
	values('1-3-4', -10000000, '답변주심에 감사를...');	
	
--원글에 달려있는 모든 댓글을 한번에 조회. Composite Pattern에 따른 개발 방법
SELECT LEVEL, id, title, content
  FROM t_post
 START WITH id = -100
CONNECT BY PRIOR  id = parent_id;

--원글에 달려있는 모든 댓글을 한번에 조회. Composite Pattern에 따른 성능도 좋은 개발 방법
SELECT *
  FROM t_post
 where hierarchy_id like '1%';
 
 /* Composite Pattern에 따른 상하 구성 관계는 기본적으로 Path Query에 의하여
 * 개발이 가능하다. Oracle의 경우 start with connected by이다.
 * 하지만 구성 관계의 Level이 깊어질 수록 성능을 보장하기 힘들다. 
 * 이에 객체 상하관계 전체를 primary key로 구성하여 Like 절을 위주로 활용한다.
 * 객체 ID를 숫자 기반으로 만들어내되 그 길이를 좀더 줄여서 표현하기 위하여 
 * Alpha-Numeric만을 사용한 최대 축약형은 제공되지 않으므로 62진법(10 + 26[대문자] + 26[소문자])에
 * 따른 문자열 표현을 만들기 위하여 개발함   
 */ 
CREATE OR REPLACE FUNCTION to62(intNum number)
  RETURN VARCHAR
IS
  res VARCHAR2(100) := '';
  quot number;
  rema number;
BEGIN
	quot := intNum;
	WHILE quot > 0 LOOP
		rema := mod(quot, 62);
		quot := FLOOR(quot / 62);

		IF rema < 10 THEN
			res := chr(ASCII('0') + rema) || res;
		ELSIF rema < 36 THEN
			res := chr(ASCII('A') + (rema - 10)) || res;
		ELSE
			res := chr(ASCII('a') + (rema - 36)) || res;
		END IF;
	END LOOP;
	RETURN res;
END;

select to62(3845) from dual;

62 3845
     62   1
     1    0
     
     
     








