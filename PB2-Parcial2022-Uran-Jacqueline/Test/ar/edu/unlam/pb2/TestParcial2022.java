package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestParcial2022 {

	@Test
	public void QueSePuedaRegistrarUnaAlarmaCentral() {
		
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		Administrador administrador = new Administrador(409876,"jacqui");
		Central central = new Central();
		

		
		assertTrue(central.registrarAlarma(alarma)); 
		assertTrue(administrador.agregarAlarma(alarma, central)); //alarma registrada
	}
	@Test
	public void QueSePuedaAgregarUnUsuarioConfiguradorAunaAlarma() throws CodigoAlarmaIncorrectoException {
		
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		
		Usuario configurador = new Configurador(1234,"martin");
		Central central = new Central();
		
		
		assertTrue(alarma.agregarUsuario(configurador,10));
		assertTrue(central.agregarUsuario(configurador));
		
		
		
	}
	
	@Test (expected = CodigoAlarmaIncorrectoException.class)
	public void alAgregarUnUsuarioAunAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSelanceCodigoAlarmaIncorrectoException() throws CodigoAlarmaIncorrectoException {
		
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		
		Usuario configurador = new Configurador(1234,"martin");
		
		Administrador administrador = new Administrador(409876,"jacqui");


		assertFalse(alarma.agregarUsuario(configurador, 11));
		
		
	}
	@Test (expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnSensorDuplicadoException() throws SensorDuplicadoException {
		
		Usuario configurador = new Configurador(1234,"martin");
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);

		Sensor sensor = new Sensor(22, true);
		Sensor sensor2 = new Sensor(22, true);
		
		

		Boolean valorObtenido = alarma.agregarSensor(sensor,sensor2,alarma,configurador);
		
		assertFalse(valorObtenido);
	
	}
	
	@Test 
	public void QueNoSePuedaActivarUnAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDesactivadoException, SensorDuplicadoException {
	
	
	Usuario configurador = new Configurador(1234,"martin");
	Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);

	Sensor sensor = new Sensor(22, true);
	Sensor sensor2 = new Sensor(21, false);

	
	alarma.agregarSensor(sensor,sensor2,alarma,configurador);
	
	alarma.activarSensor(sensor, alarma);
	
	assertFalse(alarma.activarSensor(sensor, alarma));
	
	}	
	
	@Test 
	public void QueparaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionEsDeTipoConguracionOrdenadasPorIdDeAccion() {
		
		Usuario configurador = new Configurador(1234,"martin");
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		Administrador administrador = new Administrador(409876,"jacqui");
		
		Accion accion = new Accion(33,"fecha",TipoConfiguracion.ACTIVACION,administrador,alarma);

//		alarma.agregarAcciones(accion);
		

	}
	
	

}
