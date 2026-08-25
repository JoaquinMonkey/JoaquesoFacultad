package logica;

import java.time.LocalDate;

public class Reserva {
	private LocalDate fecha;
	private int numero;
	private float costo;
	private boolean uso_benef;
	private Paciente paciente;
	private Consulta consulta;
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	public int getNumero() {
		return this.numero;
	}
	public float getCosto() {
		return this.costo;
	}
	public Paciente getPaciente() {
		return this.paciente;
	}
	public Consulta getConsulta() {
		return this.consulta;
	}
	
	public DTReservaResumen getDTResumen() {
		DTReservaResumen dtr = new DTReservaResumen(this.consulta.getNombre(), this.fecha, this.numero);
		return dtr;
	}
}
