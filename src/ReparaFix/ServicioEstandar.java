package ReparaFix;

public class ServicioEstandar implements Contratable{

	private Oficio oficio; 
	private double monto;
	private Trabajador trabajador;
	
	public ServicioEstandar (Oficio o , double precio, Trabajador t) {
		
		this.monto = precio; 
		this.oficio = o; 
		this.trabajador = t;
	}

	public double calcularCosto() {

		return this.trabajador.getCostoPlusServicio() + this.monto ; 
	} 
	
	
	
	

}
