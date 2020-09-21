 /* Composite Pattern에 따른 상하 구성 관계는 기본적으로 Path Query에 의하여
 * 개발이 가능하다. Oracle의 경우 start with connected by이다.
 * 하지만 구성 관계의 Level이 깊어질 수록 성능을 보장하기 힘들다. 
 * 이에 객체 상하관계 전체를 primary key로 구성하여 Like 절을 위주로 활용한다.
 * 객체 ID를 숫자 기반으로 만들어내되 그 길이를 좀더 줄여서 표현하기 위하여 
 * Alpha-Numeric만을 사용한 최대 축약형은 제공되지 않으므로 62진법(10 + 26[대문자] + 26[소문자])에
 * 따른 문자열 표현을 만들기 위하여 개발함   
 */ 
CREATE OR REPLACE FUNCTION to62(intNum bigint) RETURNS VARCHAR AS $$
declare
  res VARCHAR(100) := '';
  quot bigint;
  rema integer;
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
$$ LANGUAGE plpgsql;	

select * from to62(63);

--정렬 맞추기 위하여 테스트
create table TTT (
    val varchar(10)
);

insert into TTT values('100');
insert into TTT values('2');
insert into TTT values('a');
insert into TTT values('b');
insert into TTT values('A');
insert into TTT values('B');

select * from TTT order by val;
100
2
a
A
b
B
