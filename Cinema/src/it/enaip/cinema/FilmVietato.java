package it.enaip.cinema;

public class FilmVietato extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FilmVietato(String errorMessage) {
		super(errorMessage);
	}

}
