package ReparaFix;

public class Herramienta{
	
	private double precioPorDia; 
	private String nombre;
	
	public Herramienta (String n, double precio) {
		this.nombre = n ; 
		this.precioPorDia = precio; 
	}
	
	
	public double getPrecioPorDia() {
		return precioPorDia;
	}
	public void setPrecioPorDia(double precioPorDia) {
		this.precioPorDia = precioPorDia;
	} 
	

}
