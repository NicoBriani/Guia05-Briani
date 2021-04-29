package ReparaFix.exception;

public class AlquilerNoEntregadoException extends Exception {
	
	public AlquilerNoEntregadoException () {
		super ("Ya hay mas de dos alquires no entregados");
	}

}
