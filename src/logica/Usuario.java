package logica;

/**
 * Representa a un usuario en el sistema con nombre, apellido y cédula de identidad.
 * @author TProg2017
 *
 */
public abstract class Usuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String mail;

    public Usuario(String nickname, String nombre,
                   String apellido, String mail) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }
}
