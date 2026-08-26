package logica;

import java.util.Set;

import excepciones.AnioBeneficioAnualRepetidoException;

public interface IControladorBeneficioAnual {
	public abstract void altaBeneficioAnual(String nicknamePaciente, int anio, int cantMed, int cantOrd) throws AnioBeneficioAnualRepetidoException;

	public abstract Set<Integer> listarBeneficiosAnuales(String nicknamePaciente);

	public abstract DTBeneficioAnual consultaBeneficioAnual(String nicknamePaciente, int anio);
}
