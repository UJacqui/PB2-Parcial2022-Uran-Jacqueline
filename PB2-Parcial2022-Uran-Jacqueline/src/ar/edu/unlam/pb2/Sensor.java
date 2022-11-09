package ar.edu.unlam.pb2;

public class Sensor {
	
	private Integer identificador;
	private Boolean estado;

	public Sensor(Integer identificador, Boolean estado) {
		super();
		this.identificador = identificador;
		this.estado = estado;
	}
	

	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	

}
