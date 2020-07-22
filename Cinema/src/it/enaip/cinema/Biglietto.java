package it.enaip.cinema;

public class Biglietto {

	private static final double SCONTO_ANZIANI = 10.0;
	private static final double SCONTO_BAMBINI = 50.0;
	private static final double PREZZO_FISSO = 100.0;
	
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
		prezzo *= (100.0 - SCONTO_ANZIANI) / 100.0;
	}
	
	private void calcolaRiduzioneBambini() {
		prezzo *= (100.0 - SCONTO_BAMBINI) / 100.0;
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

	public Spettatore getSpettatore() {
		return spettatore;
	}
}
