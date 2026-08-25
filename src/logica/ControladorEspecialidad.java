package logica;

import java.util.Map;

import excepciones.NombreEspecialidadRepetidoException;

public class ControladorEspecialidad implements IControladorEspecialidad {

	public void altaEspecialidad(String nombre, float porcentaje_ad) throws NombreEspecialidadRepetidoException {
		if (!esValidoNombreEspecialidad(nombre)) {
			throw new NombreEspecialidadRepetidoException("El nombre de la especialidad ya esta en uso");
		}
		ManejadorEspecialidad me = ManejadorEspecialidad.getinstance();
		me.crearEspecialidad(nombre, porcentaje_ad);
	}

	private boolean esValidoNombreEspecialidad(String nombre) {
		boolean esValido = false;

		ManejadorEspecialidad me = ManejadorEspecialidad.getinstance();
		Map<String, Especialidad> se = me.getEspecialidades();
		Especialidad e = se.get(nombre);
		if (e == null) { // nombre no esta en especialidades
			esValido = true;
		}

		return esValido;
	}
}
