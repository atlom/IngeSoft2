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

    //======================Service para Usuario================================
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
    
    public void deleteUser(int id) throws ClassNotFoundException, SQLException {
        String sql="delete from \"Usuarios\" where id_usuario = ?";
        conex = con.conectarBD();
        
        PreparedStatement pst = conex.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        pst.close();
        conex.close();
        con.cerrarBD();
    }
    
    public void editUser(int id, Usuario user) throws SQLException, ClassNotFoundException {
        String sql = "update \"Usuarios\" set nombre = ?, correo = ? where id_usuario = ?";
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
    
    public ArrayList<Usuario> getUsers() throws SQLException, ClassNotFoundException {
        ArrayList<Usuario> lista = new ArrayList();
        conex = con.conectarBD();
        Statement st = conex.createStatement();
        ResultSet rs = st.executeQuery("select id_usuario,nombre,correo from \"Usuarios\"");
        while (rs.next()) {
            Usuario tm = new Usuario ();
            tm.setId_usuario(rs.getInt("id_usuario"));
            tm.setNombre(rs.getString("nombre"));
            tm.setCorreo(rs.getString("correo"));
            lista.add(tm);
        }
        conex.close();
        con.cerrarBD();
        return lista;
    }
    
    public Usuario isUser(String correo) throws ClassNotFoundException, SQLException {
        conex = con.conectarBD();
        Usuario user = new Usuario();
        Statement st = conex.createStatement();
        ResultSet rs = st.executeQuery("select id_usuario, nombre, correo from \"Usuarios\" where correo = '"+correo+"'");
        if (rs.next()) {
            user.setId_usuario(rs.getInt(1));
            user.setNombre(rs.getString(2));
            user.setCorreo(rs.getString(3));
        }
        else {
            user = null;
        }
        return user;
    }
    
    //===================Services para Hijos====================================
    
    void addHijo(int id,Hijo h) throws SQLException, ClassNotFoundException {
        String sql="insert into \"Hijos\" (nombre, apellido, fecha_nacimiento, lugar_nacimiento, \n" +
"            sexo, nacionalidad, direccion, departamento, municipio, barrio, \n" +
"            referencia_domicilio, responsable, telefono_contacto, seguro_medico, \n" +
"            alergia, id_usuario) values(?, ?, ?, ?, ?, \n" +
"            ?, ?, ?, ?, ?, ?, \n" +
"            ?, ?, ?, ?, \n" +
"            ?)";
        conex = con.conectarBD();       
        PreparedStatement pst=conex.prepareStatement(sql);
        pst.setString(1,h.getNombre());
        pst.setString(2,h.getApellido());
        //Cambia el String fecha al formato Date SQL
        java.sql.Date date = java.sql.Date.valueOf(h.getFechaNacimiento());
        pst.setDate(3, date);
        //
        pst.setString(4, h.getLugarNacimiento());
        pst.setString(5, h.getSexo());
        pst.setString(6, h.getNacionalidad());
        pst.setString(7, h.getDireccion());
        pst.setString(8, h.getDepartamento());
        pst.setString(9, h.getMunicipio());
        pst.setString(10, h.getBarrio());
        pst.setString(11,h.getReferenciaDomicilio());
        pst.setString(12, h.getResponsable());
        pst.setString(13, h.getTelefonoContacto());
        pst.setString(14, h.getSeguroMedico());
        pst.setString(15, h.getAlergia());
        pst.setInt(16, id);
        pst.execute();
        pst.close();
        conex.close();
        con.cerrarBD();    
    }
}
