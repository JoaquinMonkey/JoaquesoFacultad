package logica;

import java.util.Map;
import java.util.Set;

import excepciones.AnioBeneficioAnualRepetidoException;

public class ControladorBeneficioAnual implements IControladorBeneficioAnual {
	public void altaBeneficioAnual(String nicknamePaciente, int anio, int cantMed, int cantOrd)
			throws AnioBeneficioAnualRepetidoException {
		if (!esValidoAnioBeneficioAnual(nicknamePaciente, anio)) {
			throw new AnioBeneficioAnualRepetidoException("Ya existe un beneficio anual para el paciente en este año");
		}

		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		BeneficioAnual beneficioAnual = new BeneficioAnual(anio, cantMed, cantOrd);
		Paciente paciente = mu.getPaciente(nicknamePaciente);
		paciente.addBeneficioAnual(beneficioAnual);
	}

	public Set<Integer> listarBeneficiosAnuales(String nicknamePaciente) {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		Paciente paciente = mu.getPaciente(nicknamePaciente);
		Map<Integer, BeneficioAnual> beneficiosAnuales = paciente.getBeneficiosAnuales();
		return beneficiosAnuales.keySet();
	}

	public DTBeneficioAnual consultaBeneficioAnual(String nicknamePaciente, int anio) {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		Paciente paciente = mu.getPaciente(nicknamePaciente);
		Map<Integer, BeneficioAnual> beneficiosAnuales = paciente.getBeneficiosAnuales();
		BeneficioAnual beneficioAnual = beneficiosAnuales.get(anio);
		return beneficioAnual.getDTBeneficioAnual();
	}

	private boolean esValidoAnioBeneficioAnual(String nicknamePaciente, int anio) {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
		Paciente paciente = mu.getPaciente(nicknamePaciente);
		Map<Integer, BeneficioAnual> beneficiosAnuales = paciente.getBeneficiosAnuales();
		return !beneficiosAnuales.containsKey(anio);
	}

}
