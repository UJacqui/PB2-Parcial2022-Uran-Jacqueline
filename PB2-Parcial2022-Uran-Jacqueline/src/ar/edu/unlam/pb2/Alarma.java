package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Alarma {//implements Comparable<Accion>
	
	private Integer idAlarma;
	private CodActivacion cod;
	private Integer codConfiguracion;
	private String nombre;
	
	private Set<Usuario> listaUsuarios = new HashSet<>();
	private ArrayList<Sensor> listaSensores = new ArrayList<>();
	private Set<Accion> listaDeAcciones = new TreeSet<>();
	
	public Alarma(Integer idAlarma, CodActivacion cod, String nombre, Integer codConfiguracion) {
		this.idAlarma = idAlarma;
		this.cod = cod;
		this.nombre = nombre;
		this.codConfiguracion = codConfiguracion;
	}

	public Integer getCodConfiguracion() {
		return codConfiguracion;
	}

	public void setCodConfiguracion(Integer codConfiguracion) {
		this.codConfiguracion = codConfiguracion;
	}

	public Integer getIdAlarma() {
		return idAlarma;
	}

	public void setIdAlarma(Integer idAlarma) {
		this.idAlarma = idAlarma;
	}

	public CodActivacion getCod() {
		return cod;
	}

	public void setCod(CodActivacion cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean agregarUsuario(Usuario configurador, Integer codConf) throws CodigoAlarmaIncorrectoException {
		if (codConf == codConfiguracion) {
			throw new CodigoAlarmaIncorrectoException("los codigos con coinsiden");
		}
		this.listaUsuarios.add(configurador);
		return true;
	}

	

	public Boolean agregarSensor(Sensor sensor,Sensor sensor2, Alarma alarma, Usuario configurador) throws SensorDuplicadoException {
		
			if (sensor.getIdentificador().equals(sensor2.getIdentificador())) {
				throw new SensorDuplicadoException("sensores duplicados");
				
			}
			
		
		this.listaSensores.add(sensor);
		return true;
	}

	public Boolean activarSensor(Sensor sensor, Alarma alarma) throws SensorDesactivadoException {
		for (Sensor sensor2 : listaSensores) {
			if (sensor2.getEstado() == false && alarma.getCod().equals(CodActivacion.DESACTIVADO)) {
				
				throw new SensorDesactivadoException("sensor desactivado");
			}return false;
		}
		return true;
		
		
		
	}

	public void agregarAcciones(Accion accion) {
		this.listaDeAcciones.add(accion);
	}

	/*@Override
	public int compareTo(Accion o) {
		return o.getIdAcciones()) ;
	}*/
	
	

	
	
	
}
