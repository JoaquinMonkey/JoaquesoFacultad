package logica;

import java.util.Map;

public class ControladorEspecialidad implements IControladorEspecialidad {
	public boolean esValidoNombreEspecialidad(String nombre) {
		boolean esValido = false;

		ManejadorEspecialidad me = ManejadorEspecialidad.getinstance();
		Map<String, Especialidad> se = me.getEspecialidades();
		Especialidad e = se.get(nombre);
		if (e == null) { // nombre no esta en especialidades
			esValido = true;
		}

		return esValido;
	}

	public void altaEspecialidad(String nombre, float porcentaje_ad) {
		ManejadorEspecialidad me = ManejadorEspecialidad.getinstance();
		me.crearEspecialidad(nombre, porcentaje_ad);
	}

}
