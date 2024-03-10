package ViviendaExceptions;

public class SamePisoException extends Exception {

	public SamePisoException() {
		super("No se puede añadir un piso ya existente");
	}
}
