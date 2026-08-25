package logica;
import java.time.LocalDate;

public class DTReservaResumen {
	private String consulta;
	private LocalDate fecha;
	private int numero;

	public DTReservaResumen(String consulta, LocalDate fecha, int numero) {
		this.consulta = consulta;
		this.fecha = fecha;
		this.numero = numero;
	}
	
	public String getConsulta() {
		return this.consulta;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public int getNumero() {
		return this.numero;
	}
}
