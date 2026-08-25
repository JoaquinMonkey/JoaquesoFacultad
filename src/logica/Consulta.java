package logica;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class Consulta {
	private String nombre;
	private LocalDate fecha;
	private int nro_sala;
	private int nros_disp;
	private Map<String, Reserva> reservas;
	private Medico medico;
	private Dia_consulta diaConsulta;
	
	public Consulta(String nombre, LocalDate fecha, int nro_sala, int nros_disp) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.nro_sala = nro_sala;
		this.nros_disp = nros_disp;
		this.reservas = new HashMap<>();
	}
}
