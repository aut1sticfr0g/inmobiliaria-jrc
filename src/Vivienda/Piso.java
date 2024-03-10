package Vivienda;

public interface Piso extends Vivienda, Comparable<Piso> {

	int getPlanta();

	void setPlanta(int planta);

	char getPuerta();

	void setPuerta(char puerta);

}