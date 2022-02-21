create table IF NOT EXISTS Authors(
	ID bigint auto_increment PRIMARY KEY,
	name VARCHAR(50)
);

create table IF NOT EXISTS Books(
	ID bigint auto_increment PRIMARY KEY,
	title VARCHAR(25) NOT NULL,
	isbn VARCHAR(13),
	authorId INT NOT NULL,
	FOREIGN KEY (authorId) REFERENCES Authors(id)
);