package ReparaFix;

import java.util.ArrayList;
import java.util.List;

import ReparaFix.exception.AlquilerNoEntregadoException;

public class Usuario {

	private String nombre ;
	private String correo; 
	private List <Contratable> misContratables = new ArrayList<Contratable>();

	
	public Usuario (String nombre, String correo) {
		this.nombre = nombre ; 
		this.correo = correo ; 
	}
	
	public boolean comprobarCantidad () throws AlquilerNoEntregadoException{
		
		int cantidad = 0; 
		
		if (misContratables.size() < 3) return true ; 
		
		for (Contratable aux : misContratables) 
			if(aux instanceof Alquiler) {
				Alquiler aux1 = (ReparaFix.Alquiler) aux ;
				if (aux1.getFechaRealDevolucion() == null) 
					cantidad ++ ;
			}
		
		if (cantidad < 2) return true ; 
		else throw new AlquilerNoEntregadoException();
		
	}
	
	public void contratar (Contratable c) throws AlquilerNoEntregadoException {
	
		if (comprobarCantidad())
				misContratables.add(c);		
	}
	
}
