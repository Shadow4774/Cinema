package it.enaip.cinema;

import java.time.LocalDate;

public class Spettatore {

	private String idSpettatore, nome, cognome;
	private LocalDate dataNascita;
	private Biglietto biglietto;
	
	public Spettatore(String idSpettatore, String nome, String cognome, LocalDate dataNascita) {
		super();
		this.idSpettatore = idSpettatore;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}
	
	public boolean minorenne() {
		return (getAge() < 18);
	}
	
	public int getAge() {
		LocalDate now = LocalDate.now();
		int age = now.getYear() - dataNascita.getYear();
		if (now.getDayOfYear() < dataNascita.getDayOfYear())
			age--;
		return age;
	}

	public String getIdSpettatore() {
		return idSpettatore;
	}

	public void setIdSpettatore(String idSpettatore) {
		this.idSpettatore = idSpettatore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Biglietto getBiglietto() {
		return biglietto;
	}

	public void setBiglietto(Biglietto biglietto) {
		this.biglietto = biglietto;
	}
}
