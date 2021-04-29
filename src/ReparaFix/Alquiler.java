package ReparaFix;

import java.time.Duration;
import java.time.Instant;

public class Alquiler implements Contratable{
	
	private Herramienta herramienta; 
	private Instant fechaInicio;
	private Instant fechaContratada; 
	private Instant fechaRealDevolucion;
	private Duration dias; 

	
	public Alquiler (Herramienta herramienta, Instant i1, Instant i2) {
		this.herramienta = herramienta; 
		this.fechaInicio = i1 ; 
		this.fechaContratada = i2 ; 
	}
	
	
	public Herramienta getHerramienta() {
		return herramienta;
	}

	

	public Instant getFechaInicio() {
		return fechaInicio;
	}

	

	public Instant getFechaContratada() {
		return fechaContratada;
	}



	public Instant getFechaRealDevolucion() {
		return fechaRealDevolucion;
	}


	public Duration getDias() {
		return dias;
	}

	public void setDias(Duration dias) {
		this.dias = dias;
	}

	public int cantDiasContratados() {
		this.dias = this.dias.between(fechaInicio, fechaContratada);
		return (int) this.dias.toDays();
	}
	
	public int cantDiasReal() {
		this.dias = this.dias.between(fechaInicio, fechaRealDevolucion);
		return (int) this.dias.toDays();
	}
	
	
	public double calcularCosto() {
		return herramienta.getPrecioPorDia() * cantDiasContratados();
		
	}
	
	public double calcularCosto(Instant ahora) {
		this.fechaContratada = ahora ; 
		return herramienta.getPrecioPorDia() * cantDiasContratados();		
	}
	
	public boolean enMora () {
		return (cantDiasContratados() < cantDiasReal()); 
	}
	
	public boolean finalizado() {
		Duration aux = Duration.between(Instant.now(), fechaRealDevolucion) ; 
		return (aux.toDays() < 0);
	}
	
	
	
	
	

}
