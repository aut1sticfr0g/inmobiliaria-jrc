package Comparators;

import java.util.Comparator;

import Vivienda.Piso;

public class SuperficieComparator implements Comparator<Piso>{

	@Override
	public int compare(Piso o1, Piso o2) {

		return Double.compare(o1.getSuperficie(), o2.getSuperficie());
	}

}
