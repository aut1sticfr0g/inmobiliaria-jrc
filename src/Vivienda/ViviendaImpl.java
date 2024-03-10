package Vivienda;

import ViviendaExceptions.NegativePriceException;

public class ViviendaImpl implements Vivienda {

	protected final double REBAJA = 0.10;
	protected double superficie;
	protected double precio;
	protected Operacion operacion;
	protected String direccion;

	/**
	 * Constructor con todos los parámetros
	 * @param superficie
	 * @param precio
	 * @param operacion
	 * @param direccion
	 */
	public ViviendaImpl(double superficie, double precio, Operacion operacion, String direccion) {

		this.setSuperficie(superficie);
		try {
			calcularPrecio(precio);
			this.setPrecio(precio);
		} catch (NegativePriceException e) {
			System.out.println(e);
		}
		this.setOperacion(operacion);
		this.setDireccion(direccion);
	}

	/**
	 * Constructor con la direccion de la vivienda
	 * @param direccion
	 */
	public ViviendaImpl(String direccion) {

		this.setSuperficie(90.0);
		this.setPrecio(150000);
		this.setOperacion(Operacion.VENTA);
		this.setDireccion(direccion);
	}

	/**
	 * Constructor vacío
	 */
	public ViviendaImpl() {

		this.setSuperficie(0);
		this.setPrecio(0);
		this.setOperacion(Operacion.VENTA);
		this.setDireccion("");
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		try {
			calcularPrecio(precio);
			this.precio = precio;
		} catch (NegativePriceException e) {
			System.out.println(e);
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * rebaja el precio de la vivienda un 10%
	 * @author Josema
	 * @return el precio con el descuento aplicado
	 */
	public double getRebaja() {

		double descuento = precio * REBAJA;
		return this.precio - descuento;
	}

	// EJERCICIO 4
	public String toString() {
		return "Dirección: " + direccion + " - precio=" + precio + " - superficie=" + superficie + " - operacion="
				+ operacion;
	}

	/**
	 * dada una operación, alquiler, venta o alquiler con opción a compra, devuelve
	 * si la vivienda es de esa operación.
	 * 
	 * @author Josema
	 * @param operacion a comparar
	 * @return true si las dos operaciones son la misma
	 */
	public boolean esMismaOperacion(Operacion operacion) {
		return this.operacion.equals(operacion);
	}

	/**
	 * Método para obtener los gastos de gestión de la inmobiliaria
	 * 
	 * @author Josema
	 * @return devuelve la cantidad que se lleva la inmobiliaria en base al
	 *         porcentaje definido por la operacion.
	 */
	public double getGastosGestion() {
		switch (operacion) {
		case ALQUILER:
			return this.getPrecio() * 0.08;
		case VENTA:
			return this.getPrecio() * 0.14;
		case ALQUILER_VENTA:
			return this.getPrecio() * 0.11;
		default:
			return 0;
		}
	}

	private static double calcularPrecioMetroCuadrado(Vivienda v) {

		return v.getPrecio() * v.getSuperficie();
	}

	/**
	 * Método que compara dos viviendas en base a su operacion y si es la misma
	 * devuelve la dirección de la vivienda con el precio por metro cuadrado más
	 * caro
	 * 
	 * @author Josema
	 * @param Vivienda a comparar
	 * @return Dirección de la vivienda con el precio más caro, en el caso de que la
	 *         operación de las viviendas no sea el mismo, devuelve un mensaje de
	 *         error
	 */
	public String getViviendaMasCara(Vivienda v) {

		if (this.getOperacion().equals(v.getOperacion())) {
			if (calcularPrecioMetroCuadrado(this) > calcularPrecioMetroCuadrado(v)) {
				return this.getDireccion();
			} else {
				return v.getDireccion();
			}
		}
		return "Las viviendas no tienen la misma operación";
	}

	/**
	 * Método que obtiene el tamaño de la vivienda
	 * 
	 * @author Josema
	 * @return Devuelve el tamaño (pequeña, mediana, grande) en base a su superficie
	 */
	public String getTamanyo() {

		String tamanyo = "";
		if (this.getSuperficie() < 70)
			return tamanyo = "Vivienda pequeña";
		if (this.getSuperficie() <= 70 && this.getSuperficie() <= 95)
			return tamanyo = "Vivienda mediana";
		if (this.getSuperficie() > 95)
			return tamanyo = "Vivienda grande";

		return tamanyo;
	}

	/**
	 * Método para obtener la localidad de una vivienda a partir de su dirección
	 * 
	 * @author Josema
	 * @return String con el nombre de la localidad
	 */
	public String getLocalidad() {

		String localidad[] = this.getDireccion().split(",");

		return localidad[1];
	}

	/**
	 * Método que calcula la superficie total de una vivienda y modifica su atributo
	 * de superficie
	 * @author Josema
	 * @param Array de doubles con las superficies de cada estancia de la vivienda
	 */
	public void calcularSuperficieTotal(double[] superficies) {

		double superficieTotal = 0;

		for (double d : superficies) {
			superficieTotal += d;
		}
		this.setSuperficie(superficieTotal);
	}

	@Override
	public boolean equals(Object obj) {

		boolean r = false;
		if (obj instanceof ViviendaImpl) {

			ViviendaImpl other = (ViviendaImpl) obj;
			r = this.direccion.equals(other.direccion);
		}
		return r;
	}

	protected static void calcularPrecio(double precio) throws NegativePriceException{
		
		if (precio < 0) throw new NegativePriceException();
	}
}
