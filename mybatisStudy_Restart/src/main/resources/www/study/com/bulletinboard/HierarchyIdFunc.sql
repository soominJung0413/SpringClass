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

--postgresql
create or replace function to62 (intNum int)
returns varchar as $$
declare 
	res varchar(100) := '';
	quot Integer;
	rema Integer;
begin
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
end;
$$ language plpgsql;
