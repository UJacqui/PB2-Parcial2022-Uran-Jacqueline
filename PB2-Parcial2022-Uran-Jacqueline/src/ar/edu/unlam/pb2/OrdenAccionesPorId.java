package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenAccionesPorId implements Comparator<Accion>{

	@Override
	public int compare(Accion o1, Accion o2) {
		if (o1.getIdAcciones().compareTo(o2.getIdAcciones()) == 0) {
			return o2.getIdAcciones().compareTo(o1.getIdAcciones());
		}
		
		return o1.getIdAcciones().compareTo(o2.getIdAcciones());
		}

}
