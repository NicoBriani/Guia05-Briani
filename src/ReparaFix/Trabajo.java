package ReparaFix;

import java.time.Instant;

public class Trabajo {
	
	private Oficio oficio; 
	private Instant fechaInicio;
	private Instant fechaFinalizacion;
	
	public Trabajo (Oficio o , Instant inicio , Instant finish) {
		this.fechaFinalizacion = finish ; 
		this.oficio = o; 
		this.fechaInicio = inicio; 
	}
	
	
	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	public Instant getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Instant fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Instant getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(Instant fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	} 
	
	
	

}
