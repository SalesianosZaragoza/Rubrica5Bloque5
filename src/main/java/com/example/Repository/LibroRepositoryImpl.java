package com.example.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Model.Autor;
import com.example.Model.Libro;
import com.example.connection.AbstractConnection;

@Repository
public class LibroRepositoryImpl implements LibroRepository {
    @Autowired
    private AbstractConnection manager;

    @Override
    public void insert(Libro libro) {

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("INSERT INTO Libros (titulo, isbn, autorID) VALUES (?, ?, ?)");
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getIsbn());
            statement.setInt(3, libro.getAutor().getID());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }

    @Override
    public void delete(int id) {

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("DELETE FROM Libros WHERE ID = ?");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }
    }

    @Override
    public List<Libro> findAll() {

        List<Libro> libros = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro();
                libro.setID(rs.getInt("ID"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setIsbn(rs.getString("isbn"));

                Autor autor = new Autor();
                autor.setNombre(rs.getString("nombre"));
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
    public List<Libro> getLibrosAutor(String nombreAutor) {

        List<Libro> libros = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "SELECT l.ID, l.titulo, l.isbn, A.nombre FROM Libros l INNER JOIN AUTORES A on l.AUTORID = A.ID WHERE A.NOMBRE = ?");

            statement.setString(1, nombreAutor);
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
    public List<Libro> getLibroByIsbn(String isbn) {

        List<Libro> libros = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID WHERE l.isbn = ?");

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
    public List<Libro> getLibroByTitulo(String titulo) {

        List<Libro> libros = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "SELECT l.ID, l.titulo, l.isbn, A.NOMBRE FROM Libros l INNER JOIN AUTORES A on A.ID = l.AUTORID WHERE l.titulo = ?");

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
