package ar.edu.unlam.pb2;

public interface Activable {
	
	public boolean agregarAlarma(Alarma alarma, Central central);
	
	public boolean agregarUsuario(Usuario usuario);
	
	public void agregarUsuarioAUnaAlarma(Configurador configurador, Integer idAlarma, Integer codConfiguracion) throws CodigoAlarmaIncorrectoException;
	
	public boolean agregarSensorAAlarma(Alarma alarma, Sensor sensor, Integer dni) throws SensorDuplicadoException;
	
	public boolean activarSensorDeAlarma(Integer identificador, Integer idAlarma, CodActivacion cod );
	
	public boolean activarDesactivarAlarma(Alarma alarma, CodActivacion cod, Configurador usuario) throws SensorDesactivadoException;

}
