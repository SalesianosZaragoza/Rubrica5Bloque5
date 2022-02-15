CREATE TABLE IF NOT EXIST Autores (
    ID bigint auto_increment PRIMARY KEY,
    nombre varchar(50),
    fNac date
);

CREATE TABLE IF NOT EXIST Libros (
    ID bigint auto_increment PRIMARY KEY,
    titulo varchar(50),
    isbn varchar(50),
    autorID bigint
    CONSTRAINT FK_Autor_Libro FOREIGN KEY (autorID)
        REFERENCES Autores (ID)
);

