
package service.pack;

/**
 *
 * @author Jorge Lezcano, Moisés Avalos, Juan Acuña y Joel Garcete
 */
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
