package logica;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Paciente extends Usuario {

    private LocalDate fechaNac;
    private LocalDate fechaIng;
    private int ci;
    private Set<String> antecedentes;
    private Map<Integer, BeneficioAnual> beneficiosAnuales;

    public Paciente(
            String nickname,
            String nombre,
            String apellido,
            String mail,
            LocalDate fechaNac,
            LocalDate fechaIng,
            int ci,
            Set<String> antecedentes) {

        super(nickname, nombre, apellido, mail);

        this.fechaNac = fechaNac;
        this.fechaIng = fechaIng;
        this.ci = ci;
        this.antecedentes = antecedentes;
        this.beneficiosAnuales = new HashMap<Integer, BeneficioAnual>();
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public LocalDate getFechaIng() {
        return fechaIng;
    }

    public int getCI() {
        return ci;
    }

    public Set<String> getAntecedentes() {
        return antecedentes;
    }

	public Map<Integer, BeneficioAnual> getBeneficiosAnuales() {
		return beneficiosAnuales;
	}
    
	public void addBeneficioAnual(BeneficioAnual ba) {
		this.beneficiosAnuales.put(ba.getAnio(), ba);
	}
}