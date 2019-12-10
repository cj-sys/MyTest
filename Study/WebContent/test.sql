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

insert into bbs values ('gildong', '123456', '홍길동', '남자', 'gildong@naver.com');