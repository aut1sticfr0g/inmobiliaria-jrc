package Vivienda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Comparators.*;
import ViviendaExceptions.*;


public class CatalogoImpl implements Catalogo {

	private ArrayList<Piso> pisos;

	public CatalogoImpl(ArrayList<Piso> pisos) {
		super();
		this.pisos = pisos;
	}

	public ArrayList<Piso> getPisos() {
		return pisos;
	}

	public void setPisos(ArrayList<Piso> pisos) {
		this.pisos = pisos;
	}

	/*
	 * 7 Para el tipo Catálogo implemente un método para que: reciba una cadena de
	 * caracteres con “ALQUILER” o “VENTA” y devuelva el número de pisos de esa
	 * operación.
	 */
	public int getNumPisos(String opcion) {

		opcion = opcion.toUpperCase();
		int count = 0;

		for (Piso piso : pisos) {
			if (piso.esMismaOperacion(Operacion.valueOf(opcion))) {
				count++;
			}
		}
		return count;
	}

	/*
	 * 8 Para el tipo Catálogo implemente un método que añada un nuevo piso al
	 * catálogo. Tenga en cuenta que no se pueden incluir dos pisos iguales en el
	 * catálogo.
	 */
	public void addPiso(Piso p) throws SamePisoException {
		
		if(pisos.contains(p)) {
			throw new SamePisoException();
		} else {
			pisos.add(p);
		}
	}
	
	/* 9 Para el tipo Catálogo implemente un método que elimine un piso existente del catálogo. 
	 * Si el piso no se encuentra en el catálogo entonces deberá lanzar una excepción 
	 * indicando esto. 
	 */
	public void removePiso(Piso p) throws PisoNotFoundException {
		
		if (pisos.contains(p)) pisos.remove(p);
		else throw new PisoNotFoundException();
	}
	
	/*Para el tipo Catálogo implemente un método para que: 
	 * reciba una planta y devuelva la suma de precios de los pisos 
	 * que están en esa planta.
	 */
	public int getPrecioPorPlanta(int planta) {
		
		int total = 0;
		for (Piso piso : pisos) {
			if (piso.getPlanta() == planta) {
				total += piso.getPrecio();
			}
				
		}
		return total;
	}
	
	/* Para el tipo Catálogo implemente un método para que: 
	 * devuelva la dirección del piso con el menor precio por superficie 
	 * (cociente de precio por superficie).
	 */
	public String getDireccionMasBarato() {
		
		Collections.sort(pisos);
		return pisos.get(0).getDireccion();
		}
	
	/* Para el tipo Catálogo implemente un método para que: 
	 * dado un precio p y una superficie s devuelve un Catálogo 
	 * con los pisos con superficie mayor que s y precio menor que p.
	 */
	public Catalogo getMejorCatalogo(int precio, double superficie) {
		
		ArrayList<Piso> p = new ArrayList<>();
		for (Piso piso : pisos) {
			if (piso.getPrecio() < precio && piso.getSuperficie() > superficie) {
				p.add(piso);
			}
		}
		Catalogo result = new CatalogoImpl(p);
		return result;
	}
	
	/* Para el tipo Catálogo implemente un método para que: 
	 * Ordena el Catálogo por superficie.
	 */
	public void sortSuperficie() {
		pisos.sort(new SuperficieComparator());
	}
	
	/*Para el tipo Catálogo implemente un método para que: 
	 * Dado un precio p devuelva si existe un piso con precio menor que p.
	 */
	public boolean existeMenorPrecio(double precio) {
		
		Collections.sort(pisos);
		return pisos.get(0).getPrecio() < precio;
	}

	/*Para el tipo Catálogo implemente un método para que: 
	 * Dada una planta p devuelve si todos los pisos están 
	 * por debajo de esa planta.
	 */
	public boolean estaPorDebajo(int p) {
		
		pisos.sort(new PlantaComparator());
		return pisos.get(0).getPlanta() < p;
	}
	
	/*Para el tipo Catálogo implemente un método para que: 
	 * Dado una superficie s y un porcentaje p rebaja 
	 * el precio de los pisos con superficie 
	 * mayor que s un porcentaje p.
	 */
	public void getRebajaPorSuperficie(double s, double p) {
		
		for (Piso piso : pisos) {
			
			if (piso.getSuperficie() > s) {
				piso.setPrecio((piso.getPrecio() * p) - piso.getPrecio());
			}
		}
	}
	
	
	
}
