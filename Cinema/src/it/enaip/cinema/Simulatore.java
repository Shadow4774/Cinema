package it.enaip.cinema;

import java.time.LocalDate;

import it.enaip.cinema.Film.eFilmGenere;

public class Simulatore {
	
	public static void simulate(boolean talk, Cinema cinemaIn) {
		Cinema cinema = cinemaIn;
		
		if(cinema == null)
			cinema = new Cinema();
		
		if(talk) System.out.println("Inizio simulazione - creazione sale");
		
		cinema.addSala(new SalaCinematografica(15, "Sala 1"));
		cinema.addSala(new SalaCinematografica(20, "Sala 2"));
		cinema.addSala(new SalaCinematografica(2, "Sala 3"));
		
		if(talk) System.out.println("Sale create - creazione ed assegnazione film per sala");
		
		cinema.setFilmPerSala(new Film("Star wars 1", "George Lucas", "George Lucas", 120, eFilmGenere.SCIFI), "Sala 1");
		cinema.setFilmPerSala(new Film("Titolo 2", "Aut 2", "Prod 2", 90, eFilmGenere.HORROR), "Sala 2");
		cinema.setFilmPerSala(new Film("Titolo 3", "Aut 3", "Prod 2", 77, eFilmGenere.STORICO), "Sala 3");
		
		if(talk) System.out.println("Film assegnati - creazione ed accesso spettatori");
		
		try {	//100
			cinema.getSala("Sala 3").consentiIngresso(new Spettatore("Id 1", "Gianni", "Pinotto", LocalDate.of(1991, 10, 25)));
		} catch (SalaAlCompleto | FilmVietato e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {	//100 - 200
			cinema.getSala("Sala 3").consentiIngresso(new Spettatore("Id 2", "Gianna", "Pinotta", LocalDate.of(2000, 10, 02)));
		} catch (SalaAlCompleto | FilmVietato e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {	//Eccezione sala piena
			cinema.getSala("Sala 3").consentiIngresso(new Spettatore("Id 3", "Maria", "Luisa", LocalDate.of(1991, 10, 25)));
		} catch (SalaAlCompleto | FilmVietato e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {	//Eccezione età + horror
			cinema.getSala("Sala 2").consentiIngresso(new Spettatore("Id 4", "Tizio", "Caio", LocalDate.of(2010, 10, 25)));
		} catch (SalaAlCompleto | FilmVietato e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {	//90 - 290
			cinema.getSala("Sala 2").consentiIngresso(new Spettatore("Id 5", "Nova", "Terra", LocalDate.of(1920, 10, 25)));
		} catch (SalaAlCompleto | FilmVietato e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		try {	//50 - 340
			cinema.getSala("Sala 1").consentiIngresso(new Spettatore("Id 5", "James", "Raynor", LocalDate.of(2019, 10, 25)));
		} catch (SalaAlCompleto | FilmVietato e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		if(talk) System.out.println("Spettatori assegnati - calcolo incassi");
		
		if(talk) System.out.println("Incassi: " + cinema.getIncassoTotale());
		
		if(talk) System.out.println("Incasso max calcolato - Svuoto sala 2");
		
		cinema.getSala("Sala 2").svuotaSala();
		
		if(talk) System.out.println("Sala 2 Svuotata - calcolo nuovi incassi");
		
		if(talk) System.out.println("Incassi: " + cinema.getIncassoTotale());
		
		if(talk) System.out.println("Nuovi incassi calcolati - Fine simulazione");
	}
}
