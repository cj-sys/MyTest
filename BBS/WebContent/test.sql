select * from test;

insert into test values ('cjlee', 'jin', '1111', 100000);

CREATE TABLE BBS (
	userID varchar(20) not null,
	userPassword VARCHAR(20) not null,
	userName varchar(20) not null,
	useGender varchar(20) not null,
	userEmail varchar(50) not null,
	PRIMARY KEY (userID)
);

select * from bbs;

select * from bbss;

insert into bbs values ('gildong', '123456', '홍길동', '남자', 'gildong@naver.com');

CREATE TABLE BBSS (
	bbsID int,
	bbsTitle varchar(50),
	userID varchar(20),
	bbsDate DATE,
	bbsContent VARCHAR(2048),
	bbsAvailable INT,
	primary key(bbsID)
);

select sysdate from dual;

SELECT to_date(sysdate,'yyyy/mm/dd/hh24:miss') from dual;

select sysdate from dual;

SELECT bbsID FROM BBSS ORDER BY bbsID DESC

SELECT * FROM BBSs WHERE bbsID <1  AND bbsAvailable = 1 and rownum <= 10 ORDER BY bbsID DESC ;

SELECT * FROM (SELECT * FROM BBSS WHERE bbsID < 3 AND bbsAvailable =1) WHERE rownum <=10;

SELECT * FROM (SELECT * FROM student WHERE grade=3 ORDER BY score DESC) WHERE rownum<=10

SELECT * FROM BBSS ORDER BY bbsID desc

INSERT INTO BBSS VALUES(?,?,?,?,?,?)

SELECT * FROM BBSS WHERE bbsID < 10 AND bbsID > ? AND bbsAvailable =1





