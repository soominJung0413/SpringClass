--각각 만드는 방식 : 조인이 많으며 정규화가 될 가능성이 높음, 트렌젝션이 빈번할 것 같음 
--설계자가 어떻게 인덱싱을 걸고 쿼리를 조절하느냐가 속도면에서 핵심일 것 같아보여서, 능력에 달린 듯함.
-- 성능 최악 / 유지보수 최상 << 업무 복잡도 높을 수록 유리
CREATE TABLE A(
	id bigint, --long 
	name varchar(500) --이름
	primary key(id)
)
create table b(
	id bigint, --long 
	b1 varchar(100),
	b2 varchar(100),
	constraint fk_B_A foreign key(id) references A(id)
)

create table c(
	id bigint, --long 
	c1 varchar(100),
	c2 varchar(100)
	constraint fk_C_A foreign key(id) references A(id)
)

create table d(
	id bigint, --long 
	d1 varchar(100),
	d2 varchar(100),
	constraint fk_D_A foreign key(id) references D(id)
)

create table E(
	id bigint, --long 
	e1 varchar(100),
	e2 varchar(100),
	constraint fk_E_A foreign key(id) references E(id)
)

--Bottom :  성능탑 / 유지보수점 중간 
--확장기능을 가진 클래스를 가지고 구성됨, 하나의 확장클래스의 데이터정보를 가지고 있어 객체화하기 편함
-- 상속 관계 안에서는 트렌젝션이 일어날 가능성이 낮아보임
create table B(
	id bigint, --long 
	name varchar(500), --이름
	b1 varchar(100),
	b2 varchar(100)
)

create table D(
	id bigint, --long 
	name varchar(500), --이름
	c1 varchar(100),
	c2 varchar(100),
	d1 varchar(100),
	d2 varchar(100)
)
create table E(
id bigint, --long 
	name varchar(500), --이름
	c1 varchar(100),
	c2 varchar(100),
	e1 varchar(100),
	e2 varchar(100)
)

--Top  << 조인이 없고 트랜젝션이 없을 듯함. 비정규화된 정보가 다수 있을 듯함.  성능 구림.. / 유지보수 최악
create table A(
	id bigint, --long 
	name varchar(500), --이름
	-- discriminator 구분자 <<
	table_type varchar(200), 
	b1 varchar(100),
	b2 varchar(100),
	c1 varchar(100),
	c2 varchar(100),
	d1 varchar(100),
	d2 varchar(100),
	e1 varchar(100),
	e2 varchar(100)
)


-- 구간구간 Top 방식과 테이블 each를 섞어 쓰면 업무복잡도가 높고 상속관계 깊을때 유리한 모델이다.

-- 호출하는 쪽 : 인자 Arg / 호출당하는 쪽 : Parameter