package logica;

import java.time.LocalTime;

public class Dia_consulta {
	private String nombre;
	private String descripcion;
	private int dia_sem;
	private LocalTime hora_inicio;
	private Clinica clinica;
	
	public Dia_consulta(String nombre, String descripcion, int dia_sem, LocalTime hora_inicio,Clinica clinica) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dia_sem = dia_sem;
		this.hora_inicio = hora_inicio;
		this.clinica = clinica;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDesc() {
		return this.descripcion;
	}
	
	public int getDiaSem() {
		return this.dia_sem;
	}
	
	public LocalTime getHoraInicio() {
		return this.hora_inicio;
	}
	
	public Clinica getClinica() {
		return this.clinica;
	}
}
