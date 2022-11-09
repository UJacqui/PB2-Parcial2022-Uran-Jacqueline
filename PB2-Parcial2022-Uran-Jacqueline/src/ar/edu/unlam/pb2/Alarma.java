package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Alarma {
	
	private Integer idAlarma;
	private CodActivacion cod;
	private Integer codConfiguracion;
	private String nombre;
	private ArrayList<Sensor> listaSensores = new ArrayList<>();
	private Set<Accion> listaDeAcciones = new TreeSet<>();
	private Set<Usuario> listaUsuarios = new HashSet<>();
	
	
	
	public Set<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(Set<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	
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

	public Boolean agregarUsuario(Configurador configurador, Integer codConf) throws CodigoAlarmaIncorrectoException {
		
		if (codConf != codConfiguracion) {
			throw new CodigoAlarmaIncorrectoException("los codigos no coinciden");
		}
		this.listaUsuarios.add(configurador);
		return true;
	}

	

	public Boolean agregarSensor(Alarma alarma, Sensor sensor, Integer dni) throws SensorDuplicadoException {
		
		for (Sensor sensor1 : listaSensores) {
			
			if(sensor1.getIdentificador() == sensor.getIdentificador()) {
				throw new SensorDuplicadoException("sensores duplicados");
								
			}
		}
		
		alarma.agregarALaListaDeSensores(sensor);
		return true;
					
		
	}
	
	public void agregarALaListaDeSensores(Sensor e) {
		this.listaSensores.add(e);
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
	
	

	public boolean activarAlarma(Alarma alarma, CodActivacion cod2, Configurador usuario) throws SensorDesactivadoException {
		
		
		for (Sensor sensor : listaSensores) {
			if(sensor.getEstado() == false) {
				throw new SensorDesactivadoException("sensor desactivado");
			}
		}
				
		return true;
		
	}
	
	public Set<Accion> obtenerAccionesOrdenadasPorId(){
		Set<Accion> accionesOrdenadasId = new TreeSet<>(new OrdenAccionesPorId()); 
		accionesOrdenadasId.addAll(this.listaDeAcciones);
		
		return accionesOrdenadasId;	}
	
	

	
}
