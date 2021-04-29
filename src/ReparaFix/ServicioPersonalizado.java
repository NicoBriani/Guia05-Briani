package ReparaFix;

public class ServicioPersonalizado implements Contratable {

	private Oficio oficio; 
	private double montoPresupuestado;
	private double montoTransporte;
	private double montoMateriales;
	private Trabajador trabajador;
	private boolean urgente;
	
public ServicioPersonalizado (Oficio o , double precio, double transporte, double material, Trabajador t, boolean urgente) {
		
		this.montoPresupuestado = precio; 
		this.oficio = o; 
		this.trabajador = t;
		this.montoMateriales = material;
		this.montoTransporte = transporte; 
		this.urgente = urgente ; 
	}


	
	public double calcularCosto() {
		double montoTotal = this.trabajador.getCostoPlusServicio() + this.montoPresupuestado + this.montoTransporte + this.montoMateriales; 
			if (this.urgente)
					return montoTotal *1.5;
		return montoTotal;
	} 
	
}
	
	
