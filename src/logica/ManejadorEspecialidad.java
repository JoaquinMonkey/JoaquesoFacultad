package logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorEspecialidad {
	private Map<String, Especialidad> especialidades;
	private static ManejadorEspecialidad instancia = null;

	private ManejadorEspecialidad() {
		especialidades = new HashMap<String, Especialidad>();
	}

	public static ManejadorEspecialidad getinstance() {
		if (instancia == null)
			instancia = new ManejadorEspecialidad();
		return instancia;
	}

	public void crearEspecialidad(String nombre, float porcentaje_ad) {
		Especialidad e = new Especialidad(nombre, porcentaje_ad);
		especialidades.put(nombre, e);
	}

	public Map<String, Especialidad> getEspecialidades() {
		return especialidades;
	}
}
