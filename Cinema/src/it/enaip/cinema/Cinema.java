package it.enaip.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cinema {

	private HashMap<String, SalaCinematografica> listaSale;
	
	public Cinema() {
		listaSale = new HashMap<>();
	}
	
	public void addSala(SalaCinematografica sala) {
		String id = sala.getIdSala();
		listaSale.put(id, sala);
	}
	
	public void setFilmPerSala(Film film, String idSala) {
		if(listaSale.containsKey(idSala)) {
			SalaCinematografica tempSala = listaSale.get(idSala);
			tempSala.setFilm(film);
		}
	}
	
	public SalaCinematografica getSala(String idSala) {
		SalaCinematografica sala = null;
		
		if(listaSale.containsKey(idSala))
			sala = listaSale.get(idSala);
		
		return sala;
	}
	
	public double getIncassoTotale() {
		double incasso = 0;
		for (SalaCinematografica salaCinematografica : listaSale.values()) {
			incasso += salaCinematografica.calcolaIncasso();
		}
		return incasso;
	}
	
	public List<SalaCinematografica> getSale() {
		return new ArrayList<>(listaSale.values());
	}
}
