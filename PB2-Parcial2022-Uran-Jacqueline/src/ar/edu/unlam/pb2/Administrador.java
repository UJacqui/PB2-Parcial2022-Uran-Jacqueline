package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Administrador extends Usuario implements Configurable {
	
	private Set<Alarma> listaAlarma = new HashSet<>();
	
	public Administrador(Integer dni, String nombre) {
		super(dni, nombre);
	}

	public Boolean agregarAlarma(Alarma alarma, Central central) {
		this.listaAlarma.add(alarma);
		return true;
	}
	
	public Integer cantAlarmasRegistradas () {
		return listaAlarma.size();
	}
	
	

}
