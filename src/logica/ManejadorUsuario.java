package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuario {
	private Map<String, Usuario> usuarios;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuarios = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        usuarios.put(usu.getNickname(), usu);
    }

    public Usuario obtenerUsuario(String nickname) {
        return usuarios.get(nickname);
    }

    public Usuario[] getUsuarios() {
        if (usuarios.isEmpty())
            return null;
        else {
        	Collection<Usuario> usrs = usuarios.values();
            Object[] o = usrs.toArray();
            Usuario[] res = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                res[i] = (Usuario) o[i];
            }

            return res;
        }
    }

}
