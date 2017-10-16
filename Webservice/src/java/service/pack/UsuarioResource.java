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
public class UsuarioResource {
    UsuarioService uservice = new UsuarioService();
    
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
        String result = "Usuario guardado: " + usuario.getNombre()+", "+usuario.getCorreo();
        return result;
    }
}
