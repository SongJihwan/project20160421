/*클라이언트 데이터*/

insert into CLIENT values('SJW01','송지환1','1111-1111','song1@client.com','잘좀 만들어 주세요1');
insert into CLIENT values('SJW02','송지환2','1111-1112','song2@client.com','잘좀 만들어 주세요2');
insert into CLIENT values('SJW03','송지환3','1111-1113','song3@client.com','잘좀 만들어 주세요3');
insert into CLIENT values('SJW04','송지환4','1111-1114','song4@client.com','잘좀 만들어 주세요4');
insert into CLIENT values('SJW05','송지환5','1111-1115','song5@client.com','잘좀 만들어 주세요5');

/*프로세스 데이터*/

insert into PROCESS values('PR1','PM');
insert into PROCESS values('PR2','프로세스명2');
insert into PROCESS values('PR3','프로세스명3');
insert into PROCESS values('PR4','프로세스명4');
insert into PROCESS values('PR5','프로세스명5');

/*부서 데이터*/

insert into TEAM values('TMCD1','개발팀');
insert into TEAM values('TMCD2','영업팀');
insert into TEAM values('TMCD3','품질팀');
insert into TEAM values('TMCD4','인사팀');
insert into TEAM values('TMCD5','재무팀');

/*사원 데이터*/

insert into MEMBERS values('111111','TMCD1','송지환1','song1@members.com',10,'1111-1111','부장','1111','PR1');
insert into MEMBERS values('111112','TMCD2','송지환2','song2@members.com',3,'1111-1111','대리','1111','PR2');
insert into MEMBERS values('111113','TMCD3','송지환3','song3@members.com',5,'1111-1111','과장','1111','PR3');
insert into MEMBERS values('111114','TMCD4','송지환4','song4@members.com',7,'1111-1111','차장','1111','PR4');
insert into MEMBERS values('111115','TMCD5','송지환5','song5@members.com',9,'1111-1111','부장','1111','PR5');
insert into MEMBERS values('111116','TMCD5','송지환6','song6@members.com',2,'1111-1111','사원','1111','PR1');
insert into MEMBERS values('111117','TMCD4','송지환7','song7@members.com',4,'1111-1111','대리','1111','PR2');
insert into MEMBERS values('111118','TMCD3','송지환8','song8@members.com',6,'1111-1111','과장','1111','PR3');
insert into MEMBERS values('111119','TMCD2','송지환9','song9@members.com',8,'1111-1111','차장','1111','PR4');
insert into MEMBERS values('111110','TMCD1','송지환10','son10g@members.com',10,'1111-1111','부장','1111','PR5');

/*자격증 데이터*/

insert into CERTIFICATION values('CNO1','정보처리기사','2014-01-01','111111');
insert into CERTIFICATION values('CNO2','요리사','2014-01-01','111111');
insert into CERTIFICATION values('CNO3','화훼기능사','2014-01-01','111111');
insert into CERTIFICATION values('CNO4','정보처리기사','2014-01-01','11112');
insert into CERTIFICATION values('CNO4','정보처리기사','2014-01-01','111112');
insert into CERTIFICATION values('CNO6','정보처리기사','2014-01-01','111113');
insert into CERTIFICATION values('CNO7','정보처리기사','2014-01-01','111114');
insert into CERTIFICATION values('CNO8','정보처리기사','2014-01-01','111115');
insert into CERTIFICATION values('CNO9','정보처리기사','2014-01-01','111116');
insert into CERTIFICATION values('CNO10','정보처리기사','2014-01-01','111110');

/*프로젝트 데이터*/

insert into PROJECT values('PC1','SJW01','프로젝트명1','잘만들자1','내용1','2016-04-21','2017-04-20',30,'111111');
insert into PROJECT values('PC2','SJW02','프로젝트명2','잘만들자2','내용2','2016-04-21','2017-04-20',40,'111111');
insert into PROJECT values('PC3','SJW03','프로젝트명3','잘만들자3','내용3','2016-04-21','2017-04-20',50,'111111');
insert into PROJECT values('PC4','SJW04','프로젝트명4','잘만들자4','내용4','2016-04-21','2017-04-20',60,'111111');
insert into PROJECT values('PC5','SJW05','프로젝트명5','잘만들자5','내용5','2016-04-21','2017-04-20',70,'111111');

/*프로젝트 투입원*/

insert into PROJ_MEM values('111111','PC1','PR1');
insert into PROJ_MEM values('111111','PC2','PR1');
insert into PROJ_MEM values('111111','PC3','PR1');
insert into PROJ_MEM values('111111','PC4','PR1');
insert into PROJ_MEM values('111111','PC5','PR1');

/*공지사항 데이터*/
 
insert into NOTICE values('1','2016-04-21','송지환1',1,null,null,null);
insert into NOTICE values('2','2016-04-22','송지환1',2,null,null,null);
insert into NOTICE values('3','2016-04-23','송지환1',3,null,null,null);
insert into NOTICE values('4','2016-04-24','송지환1',4,null,null,null);
insert into NOTICE values('5','2016-04-25','송지환1',5,null,null,null);

/*작업 데이터*/

insert into TASK values('IDNO01','PC1','세부작업1','파일경로1','개발유형1','111111','PR1');
insert into TASK values('IDNO02','PC2','세부작업2','파일경로2','개발유형2','111111','PR1');
insert into TASK values('IDNO03','PC3','세부작업3','파일경로3','개발유형3','111111','PR1');
insert into TASK values('IDNO04','PC4','세부작업4','파일경로4','개발유형4','111111','PR1');
insert into TASK values('IDNO05','PC5','세부작업5','파일경로5','개발유형5','111111','PR1');

/* 게시물 데이터*/

insert into BOARD values('BNO1',null,'2016-04-21',1,'내용1','제목1','생성자1','111111','PC1','PR1');
insert into BOARD values('BNO2',null,'2016-04-22',2,'내용2','제목2','생성자2','111111','PC2','PR1');
insert into BOARD values('BNO3',null,'2016-04-23',3,'내용3','제목3','생성자3','111111','PC3','PR1');
insert into BOARD values('BNO4',null,'2016-04-24',4,'내용4','제목4','생성자4','111111','PC4','PR1');
insert into BOARD values('BNO5',null,'2016-04-25',5,'내용5','제목5','생성자5','111111','PC5','PR1');


