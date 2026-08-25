package logica;

public interface IControladorEspecialidad {
	public abstract boolean esValidoNombreEspecialidad(String nombre);

	public abstract void altaEspecialidad(String nombre, float porcentaje_ad);
}
