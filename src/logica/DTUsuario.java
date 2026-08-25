package logica;

/**
 * Datatype para transportar la información de un usuario entre capa lógica y de presentación.
 */
public class DTUsuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String mail;

    public DTUsuario(String nickname, String nombre,
                       String apellido, String mail) {
        setNickname(nickname);
        setNombre(nombre);
        setApellido(apellido);
        setMail(mail);
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

    @Override
    public String toString() {
        return getNickname() + " (" + getNombre() + " " + getApellido() + ")";
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private void setMail(String mail) {
        this.mail = mail;
    }
}