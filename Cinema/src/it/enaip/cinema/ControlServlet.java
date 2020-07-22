package it.enaip.cinema;

import java.io.IOException;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			
			break;
			
		case "svuotaSala":
			
			break;
			
		case "incassi":
			
			break;
			
		case "addSpettatore":
			
			break;
			
		case "simulate":
			
			break;

		default:
			break;
		}
	}
}
