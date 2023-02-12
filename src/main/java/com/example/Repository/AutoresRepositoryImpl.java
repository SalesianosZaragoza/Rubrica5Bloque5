package com.example.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Model.Autor;
import com.example.connection.AbstractConnection;

@Repository
public class AutoresRepositoryImpl implements AutoresRepository {
    @Autowired
    private AbstractConnection manager;

    @Override
    public void insert(Autor autor) {

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("INSERT INTO Autores (nombre, fNac) VALUES (?, ?)");
            statement.setString(1, autor.getNombre());
            statement.setDate(2, autor.getfNac());
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
            statement = conn.prepareStatement("DELETE FROM Autores WHERE ID = ?");
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
    public List<Autor> findAll() {

        List<Autor> autores = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Autor autor = new Autor();
                autor.setID(rs.getInt("ID"));
                autor.setNombre(rs.getString("nombre"));
                autor.setfNac(Date.valueOf(rs.getString("fNac")));

                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }

        return autores;
    }

    @Override
    public List<Autor> findByNombre(String nombreAutor) {

        List<Autor> autores = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a WHERE a.NOMBRE = ?");
            statement.setString(1, nombreAutor);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Autor autor = new Autor();
                autor.setID(rs.getInt("ID"));
                autor.setNombre(rs.getString("nombre"));
                autor.setfNac(Date.valueOf(rs.getString("fNac")));

                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }

        return autores;
    }

    @Override
    public List<Autor> findByDate(Date fNac) {

        List<Autor> autores = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a WHERE a.FNAC = ?");
            statement.setDate(1, fNac);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Autor autor = new Autor();
                autor.setID(rs.getInt("ID"));
                autor.setNombre(rs.getString("nombre"));
                autor.setfNac(Date.valueOf(rs.getString("fNac")));

                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            manager.close(statement);
            manager.close(conn);
        }

        return autores;
    }
}
