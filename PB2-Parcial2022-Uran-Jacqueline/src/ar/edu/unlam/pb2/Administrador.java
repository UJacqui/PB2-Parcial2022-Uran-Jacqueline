package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Administrador extends Usuario implements Activable {
	
	private Set<Alarma> listaAlarma = new HashSet<>();
	
	public Administrador(Integer dni, String nombre) {
		super(dni, nombre);
	}

	@Override
	public boolean agregarAlarma(Alarma alarma, Central central) {
		this.listaAlarma.add(alarma);
		central.registrarAlarma(alarma);
		return true;
	}
	
	public Integer cantAlarmasRegistradas () {
		return listaAlarma.size();
	}


	@Override
	public boolean agregarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void agregarUsuarioAUnaAlarma(Configurador configurador, Integer idAlarma, Integer codConfiguracion) throws CodigoAlarmaIncorrectoException {
		
		for (Alarma alarma : listaAlarma) {
			
			if(alarma.getIdAlarma().equals(idAlarma)) {
				alarma.agregarUsuario(configurador, codConfiguracion);
			}
		}
		
	}

	@Override
	public boolean agregarSensorAAlarma(Alarma alarma, Sensor sensor, Integer dni) throws SensorDuplicadoException {
		alarma.agregarSensor(alarma, sensor, dni);
		return true;
	}

	@Override
	public boolean activarSensorDeAlarma(Integer identificador, Integer idAlarma, CodActivacion cod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean activarDesactivarAlarma(Alarma alarma, CodActivacion cod, Configurador usuario) throws SensorDesactivadoException {
		
		alarma.activarAlarma(alarma, cod, usuario);
		return false;
	}
	
	

}
