package it.enaip.cinema;

public class Film {

	enum eFilmGenere{
		HORROR,
		SCIFI,
		COMICO,
		STORICO
	}
	
	private String titolo, autore, produttore;
	private int durata;
	private eFilmGenere genere;
	
	public Film(String titolo, String autore, String produttore, int durata, eFilmGenere genere) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.produttore = produttore;
		this.durata = durata;
		this.genere = genere;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getProduttore() {
		return produttore;
	}

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public eFilmGenere getGenere() {
		return genere;
	}

	public void setGenere(eFilmGenere genere) {
		this.genere = genere;
	}
	
	
}
