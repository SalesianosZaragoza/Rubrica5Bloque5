create table IF NOT EXISTS Authors(
	id IDENTITY PRIMARY KEY NOT NULL,
	name VARCHAR(50),
	birthday DATE
);

create table IF NOT EXISTS Books(
	id IDENTITY PRIMARY KEY NOT NULL ,
	title VARCHAR(50),
	isbn VARCHAR(13),
	authorID INT,
	FOREIGN KEY (authorID) REFERENCES Authors(id)
); 
