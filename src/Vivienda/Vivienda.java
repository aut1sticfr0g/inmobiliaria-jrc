package Vivienda;

public interface Vivienda {

	public Operacion getOperacion();
	public void setOperacion(Operacion operacion);
	public double getSuperficie();
	public void setSuperficie(double superficie);
	public double getPrecio();
	public void setPrecio(double precio);
	public String getDireccion();
	public void setDireccion(String direccion);
public double getRebaja();
public boolean esMismaOperacion(Operacion operacion);
public double getGastosGestion();
public String getViviendaMasCara(Vivienda v);
public String getTamanyo();
public String getLocalidad();
public void calcularSuperficieTotal(double[] superficies);
}
