package it.enaip.cinema;

import it.enaip.cinema.Film.eFilmGenere;

public class SalaCinematografica {

	private Spettatore[] listaSpettatori;
	private int spettatoriAttuali, limiteSpettatori;
	private Film film;
	private String idSala;
	
	public SalaCinematografica(int limiteSpettatori, String id) {
		listaSpettatori = new Spettatore[limiteSpettatori];
		this.limiteSpettatori = limiteSpettatori;
		spettatoriAttuali = 0;
		idSala = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	public void svuotaSala() {
		for (int i = 0; i < listaSpettatori.length; i++) {
			listaSpettatori[i] = null;
		}
	}
	
	private int addSpettatore(Spettatore spettatore) {
		int i = 0;
		boolean added = false;
		
		while (!added && i < limiteSpettatori) {
			if (listaSpettatori[i] == null) {
				listaSpettatori[i] = spettatore;
				spettatoriAttuali++;
				added = true;
			} else
				i++;
		}
		
		return i;
	}
	
	public void consentiIngresso(Spettatore spettatore) throws SalaAlCompleto, FilmVietato {
		if(spettatoriAttuali >= limiteSpettatori)
			throw new SalaAlCompleto("La sala " + idSala + " è piena");
		
		if(spettatore.getAge() < 14 && film.getGenere() == eFilmGenere.HORROR)
			throw new FilmVietato(spettatore.getNome() + " è minorenne");
		
		int posizione = addSpettatore(spettatore);
		spettatore.setBiglietto(new Biglietto(posizione, 0, spettatore));
	}
	
	public double calcolaIncasso() {
		double incasso = 0;
		for (int i = 0; i < listaSpettatori.length; i++) {
			Spettatore spettatore = listaSpettatori[i];
			if(spettatore != null)
				incasso += spettatore.getBiglietto().getPrezzo();
		}
		return incasso;
	}
}
