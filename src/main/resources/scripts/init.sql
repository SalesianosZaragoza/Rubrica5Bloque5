CREATE TABLE IF NOT EXISTS Autores (
    ID bigint auto_increment PRIMARY KEY,
    nombre varchar(100),
    fNac date
);

CREATE TABLE IF NOT EXISTS Libros (
    ID bigint auto_increment PRIMARY KEY,
    titulo varchar(100),
    isbn varchar(30),
    autorID bigint REFERENCES Autores (ID)
);

