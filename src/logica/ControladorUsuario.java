package logica;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

public class ControladorUsuario implements IControladorUsuario {

    public ControladorUsuario() {
    }

   
   
     //ESTAS FUNCIONES SON VIEJAS HAY QUE BORRARLAS DESPUES
    @Override
    public void registrarUsuario(
            String nombre,
            String apellido,
            String ci)
            throws UsuarioRepetidoException {

        
          //Este método queda solamente para compatibilidad.
         
         
        throw new UnsupportedOperationException(
                "registrarUsuario legacy no implementado");
    }

    @Override
    public DataUsuario verInfoUsuario(String ci)
            throws UsuarioNoExisteException {

      

        throw new UsuarioNoExisteException(
                "Consulta legacy no implementada");
    }

    @Override
    public DataUsuario[] getUsuarios()
            throws UsuarioNoExisteException {

        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario[] usrs = mu.getUsuarios();

        if (usrs == null) {
            throw new UsuarioNoExisteException(
                    "No existen usuarios registrados");
        }

        DataUsuario[] resultado =
                new DataUsuario[usrs.length];

        for (int i = 0; i < usrs.length; i++) {

            Usuario u = usrs[i];

            String ci = "";

            if (u instanceof Paciente) {
                Paciente p = (Paciente) u;
                ci = String.valueOf(p.getCI());
            }

            resultado[i] = new DataUsuario(
                    u.getNombre(),
                    u.getApellido(),
                    ci
            );
        }

        return resultado;
    }



     
     // FUNCIONES NUEVAS
    
    @Override
    public DTUsuario[] listarUsuarios()
            throws UsuarioNoExisteException {

        ManejadorUsuario mu =
                ManejadorUsuario.getinstance();

        Usuario[] usrs = mu.getUsuarios();

        if (usrs == null) {
            throw new UsuarioNoExisteException(
                    "No existen usuarios registrados");
        }

        DTUsuario[] resultado =
                new DTUsuario[usrs.length];

        for (int i = 0; i < usrs.length; i++) {

            Usuario u = usrs[i];

            resultado[i] = new DTUsuario(
                    u.getNickname(),
                    u.getNombre(),
                    u.getApellido(),
                    u.getMail()
            );
        }

        return resultado;
    }

    @Override
    public DTUsuario seleccionarUsuario(String nickname)
            throws UsuarioNoExisteException {

        ManejadorUsuario mu =
                ManejadorUsuario.getinstance();

        Usuario u = mu.obtenerUsuario(nickname);

        if (u == null) {
            throw new UsuarioNoExisteException(
                    "El usuario " + nickname + " no existe"
            );
        }

        if (u instanceof Paciente) {

            Paciente p = (Paciente) u;

            return new DTPaciente(
                    p.getNickname(),
                    p.getNombre(),
                    p.getApellido(),
                    p.getMail(),
                    p.getFechaNac(),
                    p.getFechaIng(),
                    p.getCI(),
                    p.getAntecedentes()
            );

        } else if (u instanceof Medico) {

            Medico m = (Medico) u;

            return new DTMedico(
                    m.getNickname(),
                    m.getNombre(),
                    m.getApellido(),
                    m.getMail(),
                    m.getNumReg(),
                    m.getMesUL(),
                    m.getPorcentajeAd(),
                    m.getWeb()
            );
        }

        throw new UsuarioNoExisteException(
                "Tipo de usuario desconocido"
        );
    }
}
