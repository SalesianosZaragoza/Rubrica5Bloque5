create table IF NOT EXISTS Author(
    AutorID INT IDENTITY,
    name varchar(25),
    FechaNac date,
    PRIMARY KEY (AutorID)
);

create table IF NOT EXISTS Books(
    BookID INT,
    Titulo varchar(30),
    isbn varchar(40),
    Autor INT,
    PRIMARY KEY (petName),
    FOREIGN KEY (Autor) REFERENCES OWNER(AutorID)
);