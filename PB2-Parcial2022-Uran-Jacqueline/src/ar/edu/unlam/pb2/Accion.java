package ar.edu.unlam.pb2;

import java.util.Date;
import java.util.Objects;

public class Accion {
	private Integer idAcciones;
	private String fecha;
	private TipoConfiguracion tipo;
	private Usuario usuario;
	private Alarma alarma;
	
	public Accion(Integer idAcciones, String fecha, TipoConfiguracion tipo, Usuario usuario, Alarma alarma) {
		super();
		this.idAcciones = idAcciones;
		this.fecha = fecha;
		this.tipo = tipo;
		this.usuario = usuario;
		this.alarma = alarma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAcciones, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accion other = (Accion) obj;
		return Objects.equals(idAcciones, other.idAcciones) && tipo == other.tipo;
	}

	public Integer getIdAcciones() {
		return idAcciones;
	}

	public void setIdAcciones(Integer idAcciones) {
		this.idAcciones = idAcciones;
	}

	

	public TipoConfiguracion getTipo() {
		return tipo;
	}

	public void setTipo(TipoConfiguracion tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Alarma getAlarma() {
		return alarma;
	}

	public void setAlarma(Alarma alarma) {
		this.alarma = alarma;
	}
	
	

}
