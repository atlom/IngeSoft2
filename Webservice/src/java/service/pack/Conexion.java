/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author atlom
 */
public class Conexion {
    Connection con;
    String user;
    String pass;
    String host;
    String database;
    public Conexion () {
        con = null;
        user = "postgres";
        pass = "postgres";
        host = "localhost:5432";
        database = "AgendaP";
    }
    
    public Connection conectarBD() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://"+host+"/"+database;
        con = DriverManager.getConnection(url, user, pass);
        return con;      
    }
    
    public void cerrarBD() throws SQLException {
        con.close();
    }
}
