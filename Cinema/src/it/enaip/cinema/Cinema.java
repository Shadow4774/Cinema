package it.enaip.cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

	private List<SalaCinematografica> listaSale;
	
	public Cinema() {
		listaSale = new ArrayList<>();
	}
	
	public void addSala(SalaCinematografica sala) {
		listaSale.add(sala);
	}
	
	public double getIncassoTotale() {
		double incasso = 0;
		for (SalaCinematografica salaCinematografica : listaSale) {
			incasso += salaCinematografica.calcolaIncasso();
		}
		return incasso;
	}
}
