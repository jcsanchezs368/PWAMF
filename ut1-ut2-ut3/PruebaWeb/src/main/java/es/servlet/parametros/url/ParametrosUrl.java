package es.servlet.parametros.url;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

@WebServlet("/ParametrosUrl")
public class ParametrosUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 =  Integer.parseInt(request.getParameter("num1"));
		int num2 =  Integer.parseInt(request.getParameter("num2"));
		
		request.setAttribute("respuesta", num1+num2);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>El resultado es: </h2>" + num1+num2 + "</body></html>");
		
		
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
