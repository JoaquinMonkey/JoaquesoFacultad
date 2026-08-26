package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuario {
	private Map<String, Usuario> usuariosPorMail;
	private Map<String, Usuario> usuariosPorNick;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuariosPorMail = new HashMap<String, Usuario>();
        usuariosPorNick = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        usuariosPorNick.put(usu.getNickname(), usu);
        usuariosPorMail.put(usu.getMail(), usu);
    }

    public Usuario obtenerUsuario(String nickname) {
        return usuariosPorNick.get(nickname);
    }

    public Usuario[] getUsuarios() {
        if (usuariosPorNick.isEmpty())
            return null;
        else {
        	Collection<Usuario> usrs = usuariosPorNick.values();
            Object[] o = usrs.toArray();
            Usuario[] res = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                res[i] = (Usuario) o[i];
            }

            return res;
        }
        
    }
    
    public Map<String, Paciente> getPacientes() {
    	Usuario[] su = getUsuarios();
    	Map<String, Paciente> sp = new HashMap<String, Paciente>();
    	for (Usuario u: su) {
    		if (u instanceof Paciente) {
    			Paciente p = (Paciente) u;
    			sp.put(p.getNickname(), p);
    		}
    	}
    	return sp;
    }

}
