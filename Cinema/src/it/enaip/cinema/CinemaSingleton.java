package it.enaip.cinema;

public class CinemaSingleton {

	private static final Cinema INSTANCE_CINEMA = new Cinema();
	
	public CinemaSingleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Cinema getInstance() {
		return INSTANCE_CINEMA;
	}
}
