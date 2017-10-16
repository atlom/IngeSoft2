/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author atlom
 */
public class UsuarioService {
    Conexion con;
    Connection conex;
    public UsuarioService() {
        con = new Conexion();
        conex = null;
    }

    //======================Querrys para Usuario================================
    void addUsuario(Usuario u) throws SQLException, ClassNotFoundException {
        String sql="insert into \"Usuarios\" (nombre,correo) values(?,?)";
        conex = con.conectarBD();
            
        PreparedStatement pst=conex.prepareStatement(sql);
        pst.setString(1,u.getNombre());
        pst.setString(2,u.getCorreo());   
        pst.execute();
        pst.close();
        conex.close();
        con.cerrarBD();    
    }
    //==========================================================================
    
    public void deleteUser(int id) throws ClassNotFoundException, SQLException {
        String sql="delete from \"Usuarios\" where id = ?";
        conex = con.conectarBD();
        
        PreparedStatement pst = conex.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        pst.close();
        conex.close();
        con.cerrarBD();
    }
    //==========================================================================
    
    public void editUser(int id, Usuario user) throws SQLException, ClassNotFoundException {
        String sql = "update \"Usuarios\" set nombre = ?, correo = ? where id = ?";
        conex = con.conectarBD();
        
        PreparedStatement pst = conex.prepareStatement(sql);
        pst.setString(1, user.getNombre());
        pst.setString(2, user.getCorreo());
        pst.setInt(3, id);
        pst.executeUpdate();
        pst.close();
        conex.close();
        con.cerrarBD();
    }
    //==========================================================================
    
    public ArrayList<Usuario> getUsers() throws SQLException, ClassNotFoundException {
        ArrayList<Usuario> lista = new ArrayList();
        conex = con.conectarBD();
        Statement st = conex.createStatement();
        ResultSet rs = st.executeQuery("select nombre,correo from \"Usuarios\"");
        while (rs.next()) {
            Usuario tm = new Usuario ();
            tm.setNombre(rs.getString("nombre"));
            tm.setCorreo(rs.getString("correo"));
            lista.add(tm);
        }
        conex.close();
        con.cerrarBD();
        return lista;
    }
}
