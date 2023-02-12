package com.example.b5r5request.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.b5r5request.connection.AbstractConnection;
import com.example.b5r5request.model.Autor;

@Repository
public class ListRepositoryAutor implements IRepositoryAutor {

    @Autowired
    public AbstractConnection manager;

    @Override
    public void insert(Autor autor) {
        Connection conn = manager.open();
        PreparedStatement preparedStatement  = null;
        try{
            preparedStatement = conn.prepareStatement("INSERT INTO Autores (nombre, fnac) VALUES (?, ?)");
            preparedStatement.setString(1, autor.getNombre());
            preparedStatement.setDate(2, autor.getfNac());
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
    public List<Autor> findAll() {
        List<Autor> todosAutores = new ArrayList<>();
        
        Connection conn = manager.open();
        PreparedStatement preparedStatement  = null;
        try{
            preparedStatement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Autor autor = new Autor();
                autor.setID(resultSet.getInt(1));
                autor.setNombre(resultSet.getString(2));
                autor.setfNac(resultSet.getDate(3));
                todosAutores.add(autor);
            }
        } catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
        } finally{
            manager.close(preparedStatement);
            manager.close(conn);
        }

        return todosAutores;
    }


    @Override
    public List<Autor> findByFnac(Date fnac) {
        List<Autor> autores = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement preparedStatement  = null;
        try{
            preparedStatement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a WHERE a.FNAC = ?");
            preparedStatement.setDate(1, fnac);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Autor autor = new Autor();
                autor.setID(resultSet.getInt("ID"));
				autor.setNombre(resultSet.getString("nombre"));
				autor.setfNac(Date.valueOf(resultSet.getString("fNac")));
				autores.add(autor);
            }

        } catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
        } finally{
            manager.close(preparedStatement);
            manager.close(conn);
        }
        return autores;
    }

    
    @Override
    public List<Autor> findByNombre(String nombre) {
        List<Autor> autores = new ArrayList<>();

        Connection conn = manager.open();
        PreparedStatement preparedStatement  = null;
        try{
            preparedStatement = conn.prepareStatement("SELECT a.ID, a.nombre, a.fNac FROM Autores a WHERE a.NOMBRE = ?");
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Autor autor = new Autor();
				autor.setID(resultSet.getInt("ID"));
				autor.setNombre(resultSet.getString("nombre"));
				autor.setfNac(Date.valueOf(resultSet.getString("fNac")));
				autores.add(autor);
            }

        } catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
        } finally{
            manager.close(preparedStatement);
            manager.close(conn);
        }


        return autores;
    }
    
}
