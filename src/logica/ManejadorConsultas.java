package logica;

	import java.util.Collection;
	import java.util.HashMap;
	import java.util.Map;

	public class ManejadorConsultas {
		private Map<String, Consulta> consultas;
	    private static ManejadorConsultas instancia = null;

	    private ManejadorConsultas() {
	        consultas = new HashMap<String, Consulta>();
	    }

	    public static ManejadorConsultas getinstance() {
	        if (instancia == null)
	            instancia = new ManejadorConsultas();
	        return instancia;
	    }
}
