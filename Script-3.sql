
DROP TABLE IF EXISTS people CASCADE ;
DROP TABLE IF EXISTS accounts_table CASCADE ;
DROP TABLE IF EXISTS users CASCADE ;

----------------------------------------
CREATE TABLE IF NOT EXISTS  people(
people_id serial PRIMARY KEY,
first_name varchar(30)NOT null,
last_name varchar(30)NOT null
);

CREATE TABLE IF NOT EXISTS accounts_table(
account_number varchar(8) PRIMARY KEY,
balance decimal(50,2) DEFAULT 0.00
);



CREATE TABLE IF NOT EXISTS users(
user_name varchar(30) PRIMARY KEY,
user_password varchar(30)NOT NULL,
access_level varchar(15) DEFAULT 'one',
people_id integer REFERENCES people(people_id),
account_number VARCHAR(8) REFERENCES accounts_table(account_number)
);

-- insert with null objects for jdbc
--INSERT INTO users(user_name ,user_password,access_level)
--values('firstuser','firstpassword','one');
--INSERT INTO users(user_name ,user_password, access_level)
--values('seconduser','secondpassword','two');

INSERT  INTO  accounts_table AS a(account_number, balance) VALUES ('1111','1000.00');
INSERT  INTO  accounts_table AS a(account_number,balance) VALUES ('2222','2000.00');
INSERT  INTO  accounts_table AS a(account_number,balance) VALUES ('3333','6000.90');
INSERT  INTO  accounts_table AS a(account_number,balance) VALUES ('4444','890.00');


INSERT  INTO  people  (first_name , last_name) VALUES ('Rob','Zombie');
INSERT  INTO  people  (first_name , last_name) VALUES ('John','Legend');
INSERT  INTO  people  (first_name , last_name) VALUES ('Benjamin','Andre');
INSERT  INTO  people  (first_name , last_name) VALUES ('Rufio','Pirate');
-- pre made data for test
--TRUNCATE users ;
--INSERT INTO users(user_name ,user_password, access_level, account_number )
--values('firstuser','firstpassword','one','1111');
--INSERT INTO users(user_name ,user_password, access_level, account_number )
--values('seconduser','secondpassword','two','2222');

INSERT INTO users
(user_name, user_password, access_level, people_id, account_number)
VALUES('first', 'pass1', 'one', 1, '1111');

INSERT INTO users
(user_name, user_password, access_level, people_id, account_number)
values('second','pass2','two', 2, '2222');

INSERT INTO users
(user_name, user_password, access_level, people_id, account_number)
values('third','pass3','three', 3, '3333');

INSERT INTO users
(user_name, user_password, access_level, people_id, account_number)
values('fourth','pass4','one', 4, '4444');
/*UPDATE users
 * update departments set department_id=50 where department_name='IT';
SET  user_password = 'firstpassword'
 WHERE user_name = 'firstuser';*/
