package ar.edu.unlam.pb1.finalAgosto;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCallCenter {

	@Test
	public void queSePuedaCrearEmpresa() {
		Empresa actual = new Empresa();
	
		assertNotNull(actual);
	}
	
	@Test
	public void queSePuedaIncorporarZonaDeCobertura() {
		Empresa actual = new Empresa();
		boolean valorEsperado = actual.agregarNuevaZonaDeCobertura(12);
		assertTrue(valorEsperado);
	}
	
	@Test
	public void queSePuedaDarDeAltaUnNuevoContacto() {
		Empresa actual = new Empresa();
		Contacto contactoNuevo = new Contacto();
		
		boolean valorObtenido = actual.agregarNuevoContacto(contactoNuevo);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaRealizarUnaLlamada() {
		Contacto contactoNuevo = new Contacto();
		Llamada nuevaLlamada = new Llamada(true," ");
		
		assertTrue(contactoNuevo.registrarNuevaLlamada(nuevaLlamada));
		
	}
	
	@Test
	public void queSePuedaVerInformacionDeContacto() {
		Empresa actual = new Empresa();
		Contacto nuevo = new Contacto("Juan");
		
		actual.agregarNuevoContacto(nuevo);
		
		assertEquals(actual.buscarPorNombre("Juan"), nuevo);	
		
	}

}
