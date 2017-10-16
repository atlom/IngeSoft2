/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.pack;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author atlom
 */

@Path("usuario")
public class Resource {
    Service uservice = new Service();
    
    @GET
    @Path("/getusers")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> getUsers() throws ClassNotFoundException, SQLException {
        return uservice.getUsers();
    }
    
    @POST
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String addUser(Usuario u) throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        usuario.setNombre(u.getNombre());
        usuario.setCorreo(u.getCorreo());
        uservice.addUsuario(usuario);
        String result = "Nuevo usuario creado: " + usuario.getNombre()+", "+usuario.getCorreo();
        return result;
    }
    
    @DELETE
    @Path("/deleteuser")
    @Produces("text/plain")
    public String deleteUser(@QueryParam("id") int id) throws ClassNotFoundException, SQLException {
        uservice.deleteUser(id);
        String result = "Usuario eliminado correctamente!";
        return result;
    }
    
    @PUT
    @Path("/edituser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String editUser(@QueryParam("id") int id, Usuario user) throws SQLException, ClassNotFoundException {
        uservice.editUser(id, user);
        String result = "Usuario modificado correctamente!";
        return result;
    }
}
