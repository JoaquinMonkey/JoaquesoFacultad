package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.NombreEspecialidadRepetidoException;
import logica.Especialidad;
import logica.Fabrica;
import logica.IControladorEspecialidad;
import logica.ManejadorEspecialidad;

class ControladorEspecialidadTest {

	private static IControladorEspecialidad ce;
	private static ManejadorEspecialidad me;

	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		me = ManejadorEspecialidad.getinstance();
		ce = fabrica.getIControladorEspecialidad();
	}

	@Test
	void testAltaEspecialidadOK() {
		String nombre = "pedro";
		float porcentaje_ad = 20.5f;
		String nombre2 = "pepe";
		float porcentaje_ad2 = 34.6f;

		ce.altaEspecialidad(nombre, porcentaje_ad);
		ce.altaEspecialidad(nombre2, porcentaje_ad2);

		assertTrue(me.getEspecialidades().containsKey(nombre));
		assertTrue(me.getEspecialidades().containsKey(nombre2));

		Especialidad e = me.getEspecialidades().get(nombre);
		Especialidad e2 = me.getEspecialidades().get(nombre2);

		assertEquals(e.getNombre(), nombre);
		assertEquals(e.getPorcentaje_ad(), porcentaje_ad);
		assertEquals(e2.getNombre(), nombre2);
		assertEquals(e2.getPorcentaje_ad(), porcentaje_ad2);
	}

	@Test
	void testAltaEspecialidadNombreRepetido() {
		try {
			ce.altaEspecialidad("juan", 43.3f);
		} catch (NombreEspecialidadRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}

		assertThrows(NombreEspecialidadRepetidoException.class, () -> {
			ce.altaEspecialidad("juan", 24.7f);
		});
	}
}
