-- 프로젝트
DROP TABLE PROJECT;

-- 부서
DROP TABLE TEAM;

-- 클라이언트
DROP TABLE CLIENT;

-- 공지사항
DROP TABLE NOTICE;

-- 사원
DROP TABLE MEMBERS;

-- 자격증
DROP TABLE CERTIFICATION;

-- 게시물
DROP TABLE BOARD;

-- 프로젝트투입원
DROP TABLE PROJ_MEM;

-- 프로세스
DROP TABLE PROCESS;

-- 작업
DROP TABLE TASK;

-- 프로젝트
CREATE TABLE PROJECT (
  PCD   VARCHAR(20) NOT NULL, -- 프로젝트코드
  CLNO  VARCHAR(20) NOT NULL, -- 클라이언트번호
  PNM   VARCHAR(50) NOT NULL, -- 프로젝트명
  GOAL  TEXT        NOT NULL, -- 목표
  CONTS TEXT        NOT NULL, -- 내용
  ST_DT DATE        NOT NULL, -- 시작일
  EN_DT DATE        NOT NULL, -- 종료일
  PRGS  INTEGER     NOT NULL, -- 진행률
  MNO   INTEGER     NULL      -- 책임자
);

-- 프로젝트 기본키
CREATE UNIQUE INDEX PK_PROJECT
  ON PROJECT ( -- 프로젝트
    PCD ASC -- 프로젝트코드
  );

-- 프로젝트 유니크 인덱스
CREATE UNIQUE INDEX UIX_PROJECT
  ON PROJECT ( -- 프로젝트
    PNM ASC -- 프로젝트명
  );

-- 프로젝트
ALTER TABLE PROJECT
  ADD
    CONSTRAINT PK_PROJECT -- 프로젝트 기본키
    PRIMARY KEY (
      PCD -- 프로젝트코드
    );

-- 프로젝트
ALTER TABLE PROJECT
  ADD
    CONSTRAINT UK_PROJECT -- 프로젝트 유니크 제약
    UNIQUE (
      PNM -- 프로젝트명
    );

-- 부서
CREATE TABLE TEAM (
  TMCD VARCHAR(20) NOT NULL, -- 부서코드
  TMNM VARCHAR(50) NOT NULL  -- 부서명
);

-- 부서 기본키
CREATE UNIQUE INDEX PK_TEAM
  ON TEAM ( -- 부서
    TMCD ASC -- 부서코드
  );

-- 부서 인덱스
CREATE INDEX IX_TEAM
  ON TEAM( -- 부서
    TMNM ASC -- 부서명
  );

-- 부서
ALTER TABLE TEAM
  ADD
    CONSTRAINT PK_TEAM -- 부서 기본키
    PRIMARY KEY (
      TMCD -- 부서코드
    );

-- 클라이언트
CREATE TABLE CLIENT (
  CLNO  VARCHAR(20) NOT NULL, -- 클라이언트번호
  CL_NM VARCHAR(50) NOT NULL, -- 이름
  TEL   VARCHAR(30) NOT NULL, -- 전화번호
  EMAIL VARCHAR(40) NOT NULL, -- 이메일
  RQ    TEXT        NOT NULL  -- 요구사항
);

-- 클라이언트 기본키
CREATE UNIQUE INDEX PK_CLIENT
  ON CLIENT ( -- 클라이언트
    CLNO ASC -- 클라이언트번호
  );

-- 클라이언트 유니크 인덱스
CREATE UNIQUE INDEX UIX_CLIENT
  ON CLIENT ( -- 클라이언트
    EMAIL ASC -- 이메일
  );

-- 클라이언트 인덱스
CREATE INDEX IX_CLIENT
  ON CLIENT( -- 클라이언트
    CL_NM ASC -- 이름
  );

-- 클라이언트
ALTER TABLE CLIENT
  ADD
    CONSTRAINT PK_CLIENT -- 클라이언트 기본키
    PRIMARY KEY (
      CLNO -- 클라이언트번호
    );

-- 클라이언트
ALTER TABLE CLIENT
  ADD
    CONSTRAINT UK_CLIENT -- 클라이언트 유니크 제약
    UNIQUE (
      EMAIL -- 이메일
    );

-- 공지사항
CREATE TABLE NOTICE (
  NNO   INTEGER     NOT NULL, -- 공지사항번호
  CR_DT DATE        NOT NULL, -- 생성일
  WRT   VARCHAR(50) NOT NULL, -- 작성자
  VIEWS INTEGER     NULL,     -- 조회수
  MNO   INTEGER     NULL,     -- 사번
  PCD   VARCHAR(20) NULL,     -- 프로젝트코드
  PNO   VARCHAR(20) NULL      -- 역할
);

-- 공지사항 기본키
CREATE UNIQUE INDEX PK_NOTICE
  ON NOTICE ( -- 공지사항
    NNO ASC -- 공지사항번호
  );

-- 공지사항
ALTER TABLE NOTICE
  ADD
    CONSTRAINT PK_NOTICE -- 공지사항 기본키
    PRIMARY KEY (
      NNO -- 공지사항번호
    );

-- 사원
CREATE TABLE MEMBERS (
  MNO   INTEGER     NOT NULL, -- 사번
  TMCD  VARCHAR(20) NOT NULL, -- 부서코드
  MNM   VARCHAR(50) NOT NULL, -- 이름
  EMAIL VARCHAR(40) NOT NULL, -- 이메일
  YEARS INTEGER     NOT NULL, -- 연차
  TEL   VARCHAR(30) NOT NULL, -- 전화번호
  POSIT VARCHAR(50) NOT NULL, -- 직급
  PWD   VARCHAR(20) NOT NULL, -- 비밀번호
  PNO   VARCHAR(20) NULL      -- 직책
);

-- 사원 기본키
CREATE UNIQUE INDEX PK_MEMBERS
  ON MEMBERS ( -- 사원
    MNO ASC -- 사번
  );

-- 사원 유니크 인덱스
CREATE UNIQUE INDEX UIX_MEMBERS
  ON MEMBERS ( -- 사원
    EMAIL ASC -- 이메일
  );

-- 사원 인덱스
CREATE INDEX IX_MEMBERS
  ON MEMBERS( -- 사원
    MNM ASC -- 이름
  );

-- 사원
ALTER TABLE MEMBERS
  ADD
    CONSTRAINT PK_MEMBERS -- 사원 기본키
    PRIMARY KEY (
      MNO -- 사번
    );

-- 사원
ALTER TABLE MEMBERS
  ADD
    CONSTRAINT UK_MEMBERS -- 사원 유니크 제약
    UNIQUE (
      EMAIL -- 이메일
    );

-- 자격증
CREATE TABLE CERTIFICATION (
  CNO  VARCHAR(20) NOT NULL, -- 자격증번호
  CNM  VARCHAR(50) NOT NULL, -- 자격증명
  C_DT DATE        NOT NULL, -- 취득일
  MNO  INTEGER     NULL      -- 사번
);

-- 자격증 기본키
CREATE UNIQUE INDEX PK_CERTIFICATION
  ON CERTIFICATION ( -- 자격증
    CNO ASC -- 자격증번호
  );

-- 자격증 인덱스
CREATE INDEX IX_CERTIFICATION
  ON CERTIFICATION( -- 자격증
    CNM ASC -- 자격증명
  );

-- 자격증
ALTER TABLE CERTIFICATION
  ADD
    CONSTRAINT PK_CERTIFICATION -- 자격증 기본키
    PRIMARY KEY (
      CNO -- 자격증번호
    );

-- 게시물
CREATE TABLE BOARD (
  BNO   VARCHAR(20) NOT NULL, -- 게시물번호
  id    VARCHAR(20) NULL,     -- 작업번호
  CR_DT DATE        NOT NULL, -- 생성일
  VIEWS INTEGER     NULL,     -- 조회수
  CONTS TEXT        NOT NULL, -- 내용
  TITLE VARCHAR(50) NOT NULL, -- 제목
  WRT   VARCHAR(50) NOT NULL, -- 생성자
  MNO   INTEGER     NULL,     -- 사번
  PCD   VARCHAR(20) NULL,     -- 프로젝트코드
  PNO   VARCHAR(20) NULL      -- 역할
);

-- 게시물 기본키
CREATE UNIQUE INDEX PK_BOARD
  ON BOARD ( -- 게시물
    BNO ASC -- 게시물번호
  );

-- 게시물 인덱스
CREATE INDEX IX_BOARD
  ON BOARD( -- 게시물
    TITLE ASC -- 제목
  );

-- 게시물
ALTER TABLE BOARD
  ADD
    CONSTRAINT PK_BOARD -- 게시물 기본키
    PRIMARY KEY (
      BNO -- 게시물번호
    );

-- 프로젝트투입원
CREATE TABLE PROJ_MEM (
  MNO INTEGER     NOT NULL, -- 사번
  PCD VARCHAR(20) NOT NULL, -- 프로젝트코드
  PNO VARCHAR(20) NOT NULL  -- 역할
);

-- 프로젝트투입원 기본키
CREATE UNIQUE INDEX PK_PROJ_MEM
  ON PROJ_MEM ( -- 프로젝트투입원
    MNO ASC, -- 사번
    PCD ASC, -- 프로젝트코드
    PNO ASC  -- 역할
  );

-- 프로젝트투입원
ALTER TABLE PROJ_MEM
  ADD
    CONSTRAINT PK_PROJ_MEM -- 프로젝트투입원 기본키
    PRIMARY KEY (
      MNO, -- 사번
      PCD, -- 프로젝트코드
      PNO  -- 역할
    );

-- 프로세스
CREATE TABLE PROCESS (
  PNO VARCHAR(20) NOT NULL, -- 프로세스번호
  PNM VARCHAR(50) NOT NULL  -- 프로세스명
);

-- 프로세스 기본키
CREATE UNIQUE INDEX PK_PROCESS
  ON PROCESS ( -- 프로세스
    PNO ASC -- 프로세스번호
  );

-- 프로세스
ALTER TABLE PROCESS
  ADD
    CONSTRAINT PK_PROCESS -- 프로세스 기본키
    PRIMARY KEY (
      PNO -- 프로세스번호
    );

-- 작업
CREATE TABLE TASK (
  id     VARCHAR(20)  NOT NULL, -- 작업번호
  PCD    VARCHAR(20)  NULL,     -- 프로젝트코드
  DT_PC  TEXT         NULL,     -- 세부작업
  FL_RT  VARCHAR(255) NULL,     -- 파일경로
  DE_TYP TEXT         NULL,     -- 개발유형
  MNO    INTEGER      NULL,     -- 담당자
  PNO    VARCHAR(20)  NULL      -- 역할
);

-- 작업 기본키
CREATE UNIQUE INDEX PK_TASK
  ON TASK ( -- 작업
    id ASC -- 작업번호
  );

-- 작업
ALTER TABLE TASK
  ADD
    CONSTRAINT PK_TASK -- 작업 기본키
    PRIMARY KEY (
      id -- 작업번호
    );

-- 프로젝트
ALTER TABLE PROJECT
  ADD
    CONSTRAINT FK_CLIENT_TO_PROJECT -- 클라이언트 -> 프로젝트
    FOREIGN KEY (
      CLNO -- 클라이언트번호
    )
    REFERENCES CLIENT ( -- 클라이언트
      CLNO -- 클라이언트번호
    );

-- 프로젝트
ALTER TABLE PROJECT
  ADD
    CONSTRAINT FK_MEMBERS_TO_PROJECT -- 사원 -> 프로젝트
    FOREIGN KEY (
      MNO -- 책임자
    )
    REFERENCES MEMBERS ( -- 사원
      MNO -- 사번
    );

-- 공지사항
ALTER TABLE NOTICE
  ADD
    CONSTRAINT FK_PROJ_MEM_TO_NOTICE -- 프로젝트투입원 -> 공지사항
    FOREIGN KEY (
      MNO, -- 사번
      PCD, -- 프로젝트코드
      PNO  -- 역할
    )
    REFERENCES PROJ_MEM ( -- 프로젝트투입원
      MNO, -- 사번
      PCD, -- 프로젝트코드
      PNO  -- 역할
    );

-- 사원
ALTER TABLE MEMBERS
  ADD
    CONSTRAINT FK_TEAM_TO_MEMBERS -- 부서 -> 사원
    FOREIGN KEY (
      TMCD -- 부서코드
    )
    REFERENCES TEAM ( -- 부서
      TMCD -- 부서코드
    );

-- 사원
ALTER TABLE MEMBERS
  ADD
    CONSTRAINT FK_PROCESS_TO_MEMBERS -- 프로세스 -> 사원
    FOREIGN KEY (
      PNO -- 직책
    )
    REFERENCES PROCESS ( -- 프로세스
      PNO -- 프로세스번호
    );

-- 자격증
ALTER TABLE CERTIFICATION
  ADD
    CONSTRAINT FK_MEMBERS_TO_CERTIFICATION -- 사원 -> 자격증
    FOREIGN KEY (
      MNO -- 사번
    )
    REFERENCES MEMBERS ( -- 사원
      MNO -- 사번
    );

-- 게시물
ALTER TABLE BOARD
  ADD
    CONSTRAINT FK_TASK_TO_BOARD -- 작업 -> 게시물
    FOREIGN KEY (
      id -- 작업번호
    )
    REFERENCES TASK ( -- 작업
      id -- 작업번호
    );

-- 게시물
ALTER TABLE BOARD
  ADD
    CONSTRAINT FK_PROJ_MEM_TO_BOARD -- 프로젝트투입원 -> 게시물
    FOREIGN KEY (
      MNO, -- 사번
      PCD, -- 프로젝트코드
      PNO  -- 역할
    )
    REFERENCES PROJ_MEM ( -- 프로젝트투입원
      MNO, -- 사번
      PCD, -- 프로젝트코드
      PNO  -- 역할
    );

-- 프로젝트투입원
ALTER TABLE PROJ_MEM
  ADD
    CONSTRAINT FK_PROJECT_TO_PROJ_MEM -- 프로젝트 -> 프로젝트투입원
    FOREIGN KEY (
      PCD -- 프로젝트코드
    )
    REFERENCES PROJECT ( -- 프로젝트
      PCD -- 프로젝트코드
    );

-- 프로젝트투입원
ALTER TABLE PROJ_MEM
  ADD
    CONSTRAINT FK_MEMBERS_TO_PROJ_MEM -- 사원 -> 프로젝트투입원
    FOREIGN KEY (
      MNO -- 사번
    )
    REFERENCES MEMBERS ( -- 사원
      MNO -- 사번
    );

-- 프로젝트투입원
ALTER TABLE PROJ_MEM
  ADD
    CONSTRAINT FK_PROCESS_TO_PROJ_MEM -- 프로세스 -> 프로젝트투입원
    FOREIGN KEY (
      PNO -- 역할
    )
    REFERENCES PROCESS ( -- 프로세스
      PNO -- 프로세스번호
    );

-- 작업
ALTER TABLE TASK
  ADD
    CONSTRAINT FK_PROJECT_TO_TASK -- 프로젝트 -> 작업
    FOREIGN KEY (
      PCD -- 프로젝트코드
    )
    REFERENCES PROJECT ( -- 프로젝트
      PCD -- 프로젝트코드
    );

-- 작업
ALTER TABLE TASK
  ADD
    CONSTRAINT FK_PROJ_MEM_TO_TASK -- 프로젝트투입원 -> 작업
    FOREIGN KEY (
      MNO, -- 담당자
      PCD, -- 프로젝트코드
      PNO  -- 역할
    )
    REFERENCES PROJ_MEM ( -- 프로젝트투입원
      MNO, -- 사번
      PCD, -- 프로젝트코드
      PNO  -- 역할
    );