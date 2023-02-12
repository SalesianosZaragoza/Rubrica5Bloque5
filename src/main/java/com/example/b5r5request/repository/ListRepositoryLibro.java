package com.example.b5r5request.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.b5r5request.connection.AbstractConnection;
import com.example.b5r5request.model.Autor;
import com.example.b5r5request.model.Libro;

@Repository
public class ListRepositoryLibro implements IRepositoryLibro {

    @Autowired
    public AbstractConnection manager;

    @Override
    public void insert(Libro libro) {
        Connection conn = manager.open();
        PreparedStatement preparedStatement  = null;
        try{
            preparedStatement = conn.prepareStatement("INSERT INTO Libros (titulo, isbn, autorID) VALUES (?, ?, ?)");
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getIsbn());
            preparedStatement.setInt(3, libro.getAutor().getID());
            preparedStatement.executeUpdate();
        } catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
        } finally{
            manager.close(preparedStatement);
            manager.close(conn);
        }
    }



    @Override
    public List<Libro> findAll() {
        List<Libro> libros = new ArrayList<>();
        
        Connection conn = manager.open();
        PreparedStatement preparedStatement  = null;
        try{
            preparedStatement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Libro libro = new Libro();
				libro.setID(resultSet.getInt("ID"));
				libro.setTitulo(resultSet.getString("titulo"));
				libro.setIsbn(resultSet.getString("isbn"));

				Autor autor = new Autor();
				autor.setNombre(resultSet.getString("nombre"));
				libro.setAutor(autor);

				libros.add(libro);
            }
        } catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
        } finally{
            manager.close(preparedStatement);
            manager.close(conn);
        }

        return libros;
    }

    @Override
    public List<Libro> findByAutor(String nomAutor) {
        List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn, A.nombre FROM Libros l INNER JOIN AUTORES A on l.AUTORID = A.ID WHERE A.NOMBRE = ?");

			statement.setString(1, nomAutor);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setNombre(rs.getString("nombre"));

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setAutor(autor);

				libros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return libros;
    }

    @Override
    public List<Libro> findByIsbn(String isbn) {
        List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID WHERE l.isbn = ?");

			statement.setString(1, isbn);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setNombre(rs.getString("nombre"));

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setAutor(autor);

				libros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return libros;
    }

    @Override
    public List<Libro> findbyTitulo(String titulo) {
        List<Libro> libros = new ArrayList<>();

		Connection conn = manager.open();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement("SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID WHERE l.titulo = ?");

			statement.setString(1, titulo);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setNombre(rs.getString("nombre"));

				Libro libro = new Libro();
				libro.setID(rs.findColumn("ID"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setAutor(autor);

				libros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(statement);
			manager.close(conn);
		}

		return libros;
    }
    
}
