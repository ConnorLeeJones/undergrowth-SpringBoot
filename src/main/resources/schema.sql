CREATE SEQUENCE hibernate_sequence;


CREATE TABLE USER (
                       ID INT NOT NULL AUTO_INCREMENT,
                       USERNAME VARCHAR2(255) NOT NULL DEFAULT '',
                       PASSWORD VARCHAR(255) NOT NULL DEFAULT '',
                       FIRST_NAME VARCHAR2(255) DEFAULT '',
                       LAST_NAME VARCHAR2(255) DEFAULT '',
                       USER_PROFILE OBJECT,
                       PRIMARY KEY (ID));

INSERT INTO USER (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME) VALUES ( 'user', 'pass', 'test', 'person' );


CREATE TABLE USER_PROFILE (
                        ID INT NOT NULL AUTO_INCREMENT,
                        DESCRIPTION VARCHAR2(255) DEFAULT '',
                        ZIPCODE VARCHAR(255) DEFAULT '',
                        LINKS VARCHAR2(255) DEFAULT '',
                        USER OBJECT,
                        EMAIL VARCHAR2(255) DEFAULT '',
                        PRIMARY KEY (ID));

INSERT INTO USER_PROFILE (DESCRIPTION, ZIPCODE, LINKS, EMAIL) VALUES ( 'test description', '11111', 'www.com', 'email' );
