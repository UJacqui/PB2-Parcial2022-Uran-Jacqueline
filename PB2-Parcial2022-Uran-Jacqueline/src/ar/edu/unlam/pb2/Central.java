package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Central {
	
	private Set<Alarma> listaDeAlarma = new HashSet<>();
	private Set<Usuario> usuariosConfiguradores = new HashSet<>();

	
	public Boolean agregarUsuario(Usuario configurador) {
		 this.usuariosConfiguradores.add(configurador);
		 return true;
	}


	public Boolean registrarAlarma(Alarma alarma) {
		this.listaDeAlarma.add(alarma);
		return true;
	}

}
