package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.AnioBeneficioAnualRepetidoException;
import excepciones.NombreEspecialidadRepetidoException;
import logica.BeneficioAnual;
import logica.DTBeneficioAnual;
import logica.Especialidad;
import logica.Fabrica;
import logica.IControladorBeneficioAnual;
import logica.IControladorEspecialidad;
import logica.ManejadorEspecialidad;
import logica.ManejadorUsuario;
import logica.Paciente;

class ControladorBeneficioAnualTest {

	private static IControladorBeneficioAnual cba;
	private static ManejadorUsuario mu;
	private static String nickname;
	private static String nickname2;
	private static String nickname3;
	private static String nickname4;

	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		mu = ManejadorUsuario.getinstance();
		cba = fabrica.getIControladorBeneficioAnual();
		nickname = "pedro";
		nickname2 = "juan";
		nickname3 = "alvaro";
		mu.addUsuario(new Paciente(nickname, "asd", "asd2", "asd3", LocalDate.now(), LocalDate.now(), 12345678, new HashSet<String>()));
		mu.addUsuario(new Paciente(nickname2, "asd", "asd2", "asd3", LocalDate.now(), LocalDate.now(), 12345678, new HashSet<String>()));
		mu.addUsuario(new Paciente(nickname3, "asd", "asd2", "asd3", LocalDate.now(), LocalDate.now(), 12345678, new HashSet<String>()));
		mu.addUsuario(new Paciente(nickname4, "asd", "asd2", "asd3", LocalDate.now(), LocalDate.now(), 12345678, new HashSet<String>()));
	}

	@Test
	void testAltaBeneficioAnualOK() {
		int anio = 2014;
		int cantMed = 2;
		int cantOrd = 12;
		int anio2 = 2018;
		int cantMed2 = 5;
		int cantOrd2 = 15;

		cba.altaBeneficioAnual(nickname, anio, cantMed, cantOrd);
		cba.altaBeneficioAnual(nickname, anio2, cantMed2, cantOrd2);

		Map<String, Paciente> pacientes = mu.getPacientes();
		Paciente paciente = pacientes.get(nickname);
		Map<Integer, BeneficioAnual> beneficiosAnuales = paciente.getBeneficiosAnuales();
		assertTrue(beneficiosAnuales.containsKey(anio));
		assertTrue(beneficiosAnuales.containsKey(anio2));

		BeneficioAnual ba1 = beneficiosAnuales.get(anio);
		BeneficioAnual ba2 = beneficiosAnuales.get(anio2);

		assertEquals(ba1.getAnio(), anio);
		assertEquals(ba1.getCantMed(), cantMed);
		assertEquals(ba1.getCantOrd(), cantOrd);
		assertEquals(ba2.getAnio(), anio2);
		assertEquals(ba2.getCantMed(), cantMed2);
		assertEquals(ba2.getCantOrd(), cantOrd2);
	}

	@Test
	void testAltaBeneficioAnualNicknameRepetido() {
		try {
			cba.altaBeneficioAnual(nickname, 2048, 15, 24);
		} catch (AnioBeneficioAnualRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}

		assertThrows(AnioBeneficioAnualRepetidoException.class, () -> {
			cba.altaBeneficioAnual(nickname, 2048, 123, 23);
		});
	}
	
	@Test
	void testListarBeneficiosAnualesOK() {
		int anio = 2014;
		int anio2 = 2018;
		int anio3 = 2011;

		cba.altaBeneficioAnual(nickname2, anio, 123, 23);
		cba.altaBeneficioAnual(nickname2, anio2, 12, 42);
		cba.altaBeneficioAnual(nickname2, anio3, 1, 3);

		Set<Integer> lista = cba.listarBeneficiosAnuales(nickname2);
		assertEquals(lista.size(), 3);
		assertTrue(lista.contains(anio));
		assertTrue(lista.contains(anio2));
		assertTrue(lista.contains(anio3));
	}
	
	@Test
	void testListarBeneficiosAnualesVacio() {
		Set<Integer> lista = cba.listarBeneficiosAnuales(nickname3);
		assertEquals(lista.size(), 0);
	}
	
	@Test
	void testConsultaBeneficioAnualOK() {
		int anio = 2014;
		int anio2 = 2018;
		int cantMed2 = 12;
		int cantOrd2 = 42;
		int anio3 = 2011;

		cba.altaBeneficioAnual(nickname4, anio, 123, 23);
		cba.altaBeneficioAnual(nickname4, anio2, cantMed2, cantOrd2);
		cba.altaBeneficioAnual(nickname4, anio3, 1, 3);

		DTBeneficioAnual dtba = cba.consultaBeneficioAnual(nickname4, anio2);
		assertEquals(dtba.getAnio(), anio2);
		assertEquals(dtba.getCantMed(), cantMed2);
		assertEquals(dtba.getCantOrd(), cantOrd2);
	}
}
