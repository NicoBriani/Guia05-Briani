package ReparaFix;

import java.time.Instant;

import ReparaFix.exception.AgendaOcupadaException;
import ReparaFix.exception.AlquilerNoEntregadoException;
import ReparaFix.exception.OficioNoCoincideException;

public class app {
	
	public static void main(String[] args) throws OficioNoCoincideException, AgendaOcupadaException, AlquilerNoEntregadoException {
		
		//CREANDO TRABAJADORES
		Trabajador trabajador1 = new Trabajador ("Juan",500,20,Oficio.Carpintero,1000); 
		Trabajador trabajador2 = new Trabajador ("Julian",300,20,Oficio.Albañil,0); 
		Trabajador trabajador3 = new Trabajador ("Marta",450,20,Oficio.ReparadorElectrodomestico,0); 
		
		//CREANDO USUARIOS
		Usuario usuario1 = new Usuario ("Pedro","pedro@utn");
		Usuario usuario2 = new Usuario ("Daniela","daniela@utn");
		Usuario usuario3 = new Usuario ("Delfina","delfina@utn");
		
		//CREANDO INSTANT 

		Instant i1 = Instant.now();
		Instant i2 = i1.plusMillis(10000000); //un dia mas 
	
		//CREANDO TRABAJOS 
		
		Trabajo trabajo1 = new Trabajo (Oficio.Carpintero, i1 , i2); 
		Trabajo trabajo2 = new Trabajo (Oficio.Albañil, i1 , i2); 
		Trabajo trabajo3 = new Trabajo (Oficio.ReparadorElectrodomestico, i1 , i2); 
		
		//CREANDO HERRAMIENTAS 
		
		Herramienta herramienta1 = new Herramienta ("Agujeradora", 1000) ; 
		Herramienta herramienta2 = new Herramienta ("Amoladora", 900) ; 
		Herramienta herramienta3 = new Herramienta ("Taladro", 1000) ; 
		Herramienta herramienta4 = new Herramienta ("Soplete", 1500) ; 
		
		
		//CREANDO CONTRATABLES 
		
		Contratable alquiler1 = new Alquiler (herramienta1, i1, i2);
		Contratable alquiler2 = new Alquiler (herramienta2, i1, i2);
	
		
		Contratable servicioEstandar1 = new ServicioEstandar (Oficio.Carpintero,2000,trabajador1);
		Contratable servicioEstandar2 = new ServicioEstandar (Oficio.Albañil,5000,trabajador2);
		
		
		Contratable servicioPersonalizado1 = new ServicioPersonalizado (Oficio.ReparadorElectrodomestico, 2000, 1000, 1000, trabajador3 ,false);
		Contratable servicioPersonalizado2 = new ServicioPersonalizado (Oficio.Carpintero, 3000, 500, 1500, trabajador1 ,true);
		
		
		System.out.println(servicioEstandar1.calcularCosto());
		
		System.out.println(servicioPersonalizado2.calcularCosto());
		
	
		trabajador1.asignarTrabajo(trabajo1);
		
		// trabajador2.asignarTrabajo(trabajo3); EXCEPCION 
		
		usuario1.contratar(servicioPersonalizado2);
		usuario1.contratar(alquiler1);
		usuario1.contratar(alquiler1);
		// usuario1.contratar(alquiler2); EXCEPTION 
		
		
	}

	
}
