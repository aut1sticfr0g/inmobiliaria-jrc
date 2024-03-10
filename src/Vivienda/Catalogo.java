package Vivienda;

import java.util.ArrayList;

import ViviendaExceptions.PisoNotFoundException;
import ViviendaExceptions.SamePisoException;

public interface Catalogo {

	ArrayList<Piso> getPisos();

	void setPisos(ArrayList<Piso> pisos);

	/*
	 * 7 Para el tipo Catálogo implemente un método para que: reciba una cadena de
	 * caracteres con “ALQUILER” o “VENTA” y devuelva el número de pisos de esa
	 * operación.
	 */
	int getNumPisos(String opcion);

	/*
	 * 8 Para el tipo Catálogo implemente un método que añada un nuevo piso al
	 * catálogo. Tenga en cuenta que no se pueden incluir dos pisos iguales en el
	 * catálogo.
	 */
	void addPiso(Piso p) throws SamePisoException;

	/* 9 Para el tipo Catálogo implemente un método que elimine un piso existente del catálogo. 
	 * Si el piso no se encuentra en el catálogo entonces deberá lanzar una excepción 
	 * indicando esto. 
	 */
	void removePiso(Piso p) throws PisoNotFoundException;

	/*Para el tipo Catálogo implemente un método para que: 
	 * reciba una planta y devuelva la suma de precios de los pisos 
	 * que están en esa planta.
	 */
	int getPrecioPorPlanta(int planta);

	/* Para el tipo Catálogo implemente un método para que: 
	 * devuelva la dirección del piso con el menor precio por superficie 
	 * (cociente de precio por superficie).
	 */
	String getDireccionMasBarato();

	/* Para el tipo Catálogo implemente un método para que: 
	 * dado un precio p y una superficie s devuelve un Catálogo 
	 * con los pisos con superficie mayor que s y precio menor que p.
	 */
	Catalogo getMejorCatalogo(int precio, double superficie);

	/* Para el tipo Catálogo implemente un método para que: 
	 * Ordena el Catálogo por superficie.
	 */
	void sortSuperficie();

	/*Para el tipo Catálogo implemente un método para que: 
	 * Dado un precio p devuelva si existe un piso con precio menor que p.
	 */
	boolean existeMenorPrecio(double precio);

	/*Para el tipo Catálogo implemente un método para que: 
	 * Dada una planta p devuelve si todos los pisos están 
	 * por debajo de esa planta.
	 */
	boolean estaPorDebajo(int p);

	/*Para el tipo Catálogo implemente un método para que: 
	 * Dado una superficie s y un porcentaje p rebaja 
	 * el precio de los pisos con superficie 
	 * mayor que s un porcentaje p.
	 */
	void getRebajaPorSuperficie(double s, double p);

}