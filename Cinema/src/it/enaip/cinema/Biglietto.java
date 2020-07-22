package it.enaip.cinema;

public class Biglietto {

	private static final int SCONTO_ANZIANI = 10;
	private static final int SCONTO_BAMBINI = 50;
	private static final int PREZZO_FISSO = 100;
	
	private int posizione;
	private double prezzo;
	private Spettatore spettatore;
	
	public Biglietto(int posizione, double prezzo, Spettatore spettatore) {
		super();
		this.posizione = posizione;
		this.prezzo = PREZZO_FISSO;
		this.spettatore = spettatore;
		
		int tempEta = spettatore.getAge();
		if(tempEta > 70)
			applicaRiduzioneAnziani();
		if(tempEta < 5)
			calcolaRiduzioneBambini();
	}
	
	private void applicaRiduzioneAnziani() {
		prezzo *= (100 - SCONTO_ANZIANI);
	}
	
	private void calcolaRiduzioneBambini() {
		prezzo *= (100 - SCONTO_BAMBINI);
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Spettatore getSpettatore() {
		return spettatore;
	}

	public void setSpettatore(Spettatore spettatore) {
		this.spettatore = spettatore;
	}
}
