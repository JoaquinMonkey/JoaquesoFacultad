package logica;
//ESTE HAY QUE BORRARLO DESPUES, ES DE LA DEMO
public class DataUsuario {

    private String nombre;
    private String apellido;
    private String cedulaIdentidad;

    public DataUsuario() {
        this.nombre = "";
        this.apellido = "";
        this.cedulaIdentidad = "";
    }

    public DataUsuario(String nombre, String apellido, String cedulaIdentidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    @Override
    public String toString() {
        return getCedulaIdentidad()
                + " (" + getNombre()
                + " " + getApellido() + ")";
    }
}