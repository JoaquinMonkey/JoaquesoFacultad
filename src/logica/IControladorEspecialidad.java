package logica;

import excepciones.NombreEspecialidadRepetidoException;

public interface IControladorEspecialidad {
	public abstract void altaEspecialidad(String nombre, float porcentaje_ad) throws NombreEspecialidadRepetidoException;
}
