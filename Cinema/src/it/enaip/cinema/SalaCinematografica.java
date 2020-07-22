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

	public Spettatore[] getListaSpettatori() {
		return listaSpettatori;
	}

	public void setListaSpettatori(Spettatore[] listaSpettatori) {
		this.listaSpettatori = listaSpettatori;
	}

	public int getSpettatoriAttuali() {
		return spettatoriAttuali;
	}

	public void setSpettatoriAttuali(int spettatoriAttuali) {
		this.spettatoriAttuali = spettatoriAttuali;
	}

	public int getLimiteSpettatori() {
		return limiteSpettatori;
	}

	public void setLimiteSpettatori(int limiteSpettatori) {
		this.limiteSpettatori = limiteSpettatori;
	}

	public String getIdSala() {
		return idSala;
	}

	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
}
