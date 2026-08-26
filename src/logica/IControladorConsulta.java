package logica;

import java.util.Set;

public interface IControladorConsulta {

	Set<String> consultarDiaConsulta(String nombre);

	Set<String> listarDiasConsulta();

	Set<String> listarConsultas(String dia);

	Set<DTReservaResumen> listarReservasPaciente(String paciente);

}
