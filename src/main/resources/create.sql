create table IF NOT EXISTS Autores(
	codAutor IDENTITY PRIMARY KEY NOT NULL,
	nombre VARCHAR(25) NOT NULL,
	fechaNac VARCHAR(25) NOT NULL
);

create table IF NOT EXISTS Libros(
	id IDENTITY PRIMARY KEY NOT NULL ,
	titulo VARCHAR(25) NOT NULL,
	isbn VARCHAR(13) NOT NULL,
	codAutor INT NOT NULL,
	FOREIGN KEY (codAutor) REFERENCES Autores(codAutor)
);