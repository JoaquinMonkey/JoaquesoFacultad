package logica;

import java.util.Set;
import java.util.HashSet;

public class ControladorConsultas implements IControladorConsulta {

	@Override
	public Set<String> consultarDiaConsulta(String nombre) {
		Set<String> ret = new HashSet<>();
		return ret;
	}

	@Override
	public Set<String> listarDiasConsulta() {
		Set<String> ret = new HashSet<>();
		return ret;
	}

	@Override
	public Set<String> listarConsultas(String dia) {
		Set<String> ret = new HashSet<>();
		return ret;
	}

	@Override
	public Set<DTReservaResumen> listarReservasPaciente(String paciente) {
		ManejadorUsuario mU = ManejadorUsuario.getinstance();
		Paciente p = mU.getPaciente(paciente);
		Set<Reserva> res = p.getReservas();
		Set<DTReservaResumen> ret = new HashSet<>();
		for (Reserva r : res)
			ret.add(r.getDTResumen());
		return ret;

	}

}
