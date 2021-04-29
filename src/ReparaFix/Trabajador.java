package ReparaFix;
import java.time.Instant;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import ReparaFix.exception.AgendaOcupadaException;
import ReparaFix.exception.OficioNoCoincideException;


public class Trabajador {

	private Oficio oficio; 
	private String nombre;
	private String correoElectronico;
	private double costoPorHora;
	private double porcentajeComision;
	private double costoPlusServicio;
	private List <Trabajo> trabajos = new ArrayList<Trabajo>();
	
	
	
	public double getCostoPlusServicio() {
		return costoPlusServicio;
	}


	public void setCostoPlusServicio(double costoPlusServicio) {
		this.costoPlusServicio = costoPlusServicio;
	}


	public Trabajador (String n, double c , double p , Oficio o, double plus) {
		this.costoPorHora = c ; 
		this.nombre = n ; 
		this.porcentajeComision = p ; 
		this.oficio = o ; 
		this.costoPlusServicio = plus; 
	}
	


	public double getCostoPorHora() {
		return costoPorHora;
	}


	public void setCostoPorHora(double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}


	public double getPorcentajeComision() {
		return porcentajeComision;
	}


	public void setPorcentajeComision(double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}
	
	public boolean comprobarOficio (Oficio o) throws OficioNoCoincideException {
		
		if (o == this.oficio) return true;
		else {
			throw new OficioNoCoincideException();
		}
	
		
		}
	public boolean comprobarAgenda ( Instant fechaInicial) throws AgendaOcupadaException {
		
		if ((this.trabajos.size()-1) < 0 ) return true ; 
		
		Trabajo ultimoTrabajo = this.trabajos.get(this.trabajos.size()-1) ; 
		Duration auxDias; 
		
		auxDias = Duration.between(ultimoTrabajo.getFechaFinalizacion(), fechaInicial) ; 
		
		if ( auxDias.toDays() > 0)  return true ;
	
		else {
			throw new AgendaOcupadaException();
		}
		
	
	}
	
	public void asignarTrabajo (Trabajo t) throws OficioNoCoincideException, AgendaOcupadaException {
		
		if (comprobarOficio(t.getOficio()))
			if (comprobarAgenda(t.getFechaInicio()))
				trabajos.add(t);
	}
	
	
	

		
}
	
	

