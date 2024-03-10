package Comparators;

import java.util.Comparator;

import Vivienda.Piso;

public class PlantaComparator implements Comparator<Piso> {

	@Override
	public int compare(Piso o1, Piso o2) {
		
		return Integer.compare(o1.getPlanta(), o2.getPlanta());
	}

}
