package Vivienda;


public class PisoImpl extends ViviendaImpl implements Piso, Comparable<Piso> {

	private int planta;
	private char puerta;
	
	public PisoImpl(double superficie, double precio, Operacion operacion, String direccion, int planta, char puerta) {
		super(superficie, precio, operacion, direccion);
		this.setPlanta(planta);
		this.setPuerta(puerta);
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public char getPuerta() {
		return puerta;
	}

	public void setPuerta(char puerta) {
		this.puerta = puerta;
	}
	
	public boolean equals(Object obj) {

		boolean r = false;
		if (obj instanceof PisoImpl) {

			PisoImpl other = (PisoImpl) obj;
			r = super.equals(other) && 
					this.planta == other.planta &&
					this.puerta == other.puerta;
		}
		return r;
	}

	@Override
	public int compareTo(Piso o) {
		// TODO Auto-generated method stub
		return Double.compare(this.getPrecio(), o.getPrecio());
	}
	
}
