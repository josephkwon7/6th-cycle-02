INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (1, 'javajigi', 'test', '자바지기', 'javajigi@gmail.com');
INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES (2, 'sanjigi', 'test', '산지기', 'sanjigi@gmail.com');

INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENT, CREATE_DATE, COUNT_OF_ANSWER) VALUES (1, 1, '국내에서 Ruby on Rails와 Play가 ', 'Ruby on Rails(이하 RoR)는', CURRENT_TIMESTAMP(), 0);
INSERT INTO QUESTION (ID, WRITER_ID, TITLE, CONTENT, CREATE_DATE, COUNT_OF_ANSWER) VALUES (2, 2, '산지기가 쓴 글', '산지기는 군생활 때 나의 별명. 자바지기의 유래는 산지기', CURRENT_TIMESTAMP(), 0);