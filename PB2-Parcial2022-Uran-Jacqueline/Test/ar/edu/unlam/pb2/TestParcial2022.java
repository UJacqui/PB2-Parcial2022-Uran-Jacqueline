package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Set;

import org.junit.Test;

public class TestParcial2022 {

	@Test
	public void QueSePuedaRegistrarUnaAlarmaCentral() {
		
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		Administrador administrador = new Administrador(409876,"jacqui");
		Central central = new Central();
		
		assertTrue(administrador.agregarAlarma(alarma, central)); //alarma registrada
	}
	@Test
	public void QueSePuedaAgregarUnUsuarioConfiguradorAunaAlarma() throws CodigoAlarmaIncorrectoException {
		
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		Configurador configurador = new Configurador(1234,"martin");
		
		Administrador administrador = new Administrador(12345,"jacqui");
		Central central = new Central();
		
		administrador.agregarAlarma(alarma, central);
		
		administrador.agregarUsuarioAUnaAlarma(configurador, 01, 11);
		
		assertEquals(1, alarma.getListaUsuarios().size());
						
	}
	
	@Test (expected = CodigoAlarmaIncorrectoException.class)
	public void alAgregarUnUsuarioAunAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSelanceCodigoAlarmaIncorrectoException() throws CodigoAlarmaIncorrectoException {
		
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		Configurador configurador = new Configurador(1234,"martin");
		
		Administrador administrador = new Administrador(12345,"jacqui");
		Central central = new Central();
		
		administrador.agregarAlarma(alarma, central);		
		administrador.agregarUsuarioAUnaAlarma(configurador, 01, 12);
		
		
	}
	@Test (expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnSensorDuplicadoException() throws SensorDuplicadoException {
		
		Administrador administrador = new Administrador(12345,"jacqui");
		Configurador configurador = new Configurador(1234,"martin");
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);

		Sensor sensor = new Sensor(22, true);
		Sensor sensor2 = new Sensor(22, true);
		
		administrador.agregarSensorAAlarma(alarma, sensor, configurador.getDni());
		administrador.agregarSensorAAlarma(alarma, sensor2, configurador.getDni());
			
	}
	
	@Test (expected = SensorDesactivadoException.class)
	public void QueNoSePuedaActivarUnAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDesactivadoException, SensorDuplicadoException {
	
	
		Administrador administrador = new Administrador(12345,"jacqui");
		Configurador configurador = new Configurador(1234,"martin");
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);

		Sensor sensor = new Sensor(22, true);
		Sensor sensor2 = new Sensor(23, false);
		
		administrador.agregarSensorAAlarma(alarma, sensor, configurador.getDni());
		administrador.agregarSensorAAlarma(alarma, sensor2, configurador.getDni());
		
		administrador.activarDesactivarAlarma(alarma, CodActivacion.ACTIVADO, configurador);

	
	}	
	
	@Test 
	public void QueparaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionEsDeTipoConguracionOrdenadasPorIdDeAccion() {
		
		Usuario configurador = new Configurador(1234,"martin");
		Alarma alarma = new Alarma(01,CodActivacion.DESACTIVADO, "pop", 11);
		Administrador administrador = new Administrador(409876,"jacqui");
		
		Accion accion = new Accion(33,"fecha",TipoConfiguracion.ACTIVACION,administrador,alarma);
		Accion accion1 = new Accion(30,"fecha",TipoConfiguracion.ACTIVACION,administrador,alarma);
		Accion accion2 = new Accion(34,"fecha",TipoConfiguracion.ACTIVACION,administrador,alarma);

		alarma.agregarAcciones(accion);
		alarma.agregarAcciones(accion1);
		alarma.agregarAcciones(accion2);
		
		Set<Accion> accionesOrdenadas = alarma.obtenerAccionesOrdenadasPorId();
		
		for (Accion accion3 : accionesOrdenadas) {
			System.out.println(accion.getIdAcciones());
		}
	}
}
