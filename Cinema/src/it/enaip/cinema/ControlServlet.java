package it.enaip.cinema;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String op = request.getParameter("op");
		
		switch (op) {
		case "addSala":
			addSala(request, response);
			//TODO: forward main menu
			break;
			
		case "svuotaSala":
			svuotaSala(request, response);
			//TODO: forward main menu
			break;
			
		case "incassi":
			getIncassi(request, response);
			//TODO: forward display
			break;
			
		case "addSpettatore":
			addSpettatore(request, response);
			//TODO: forward main menu
			break;
			
		case "simulate":
			Simulatore.simulate(false, getCinema());
			//TODO: forward main menu
			break;
			
		case "listaSale":
			listaSale(request, response);
			//TODO: forward lista sale
			break;

		default:
			break;
		}
	}
	
	private void addSala(HttpServletRequest request, HttpServletResponse response) {
		int limitePosti = Integer.parseInt(request.getParameter("posti"));
		String idSala = request.getParameter("id");
		SalaCinematografica sala = new SalaCinematografica(limitePosti, idSala);
		getCinema().addSala(sala);
	}
	
	private void svuotaSala(HttpServletRequest request, HttpServletResponse response) {
		String idSala = request.getParameter("id");
		getCinema().getSala(idSala).svuotaSala();
	}
	
	private void getIncassi(HttpServletRequest request, HttpServletResponse response) {
		double incassi = getCinema().getIncassoTotale();
		request.setAttribute("incassi", incassi);
	}
	
	private void addSpettatore(HttpServletRequest request, HttpServletResponse response) {
		String idSpettatore = request.getParameter("idSpettatore");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		LocalDate dataNascita = LocalDate.parse(request.getParameter("nascita"));
		
		Spettatore sp = new Spettatore(idSpettatore, nome, cognome, dataNascita);
		
		String idSala = request.getParameter("idSala");
		
		try {
			getCinema().getSala(idSala).consentiIngresso(sp);
		} catch (SalaAlCompleto | FilmVietato | NullPointerException e) {
			// TODO: Forward exception page
		} 
		
	}
	
	private void listaSale(HttpServletRequest request, HttpServletResponse response) {
		List<SalaCinematografica> sale = getCinema().getSale();
		request.setAttribute("listaSale", sale);
	}
	
	private Cinema getCinema() {
		//TODO: Dove lo tengo il cinema??
		return null;
	}
}
