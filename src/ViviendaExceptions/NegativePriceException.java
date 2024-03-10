package ViviendaExceptions;

public class NegativePriceException extends Exception {

	public NegativePriceException() {
		super("El precio no puede ser negativo.");
	}
}
