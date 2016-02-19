package com.ibm.ca.MainServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LinkServlet
 */
@WebServlet("/Link")
public class LinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinkServlet() {
        super(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String link=(request.getParameter("Link"));;
		request.getParameterMap().clear();
		String styleSheet = (String) ((request.getSession().getAttribute("stylesheet")!=null)?request.getSession().getAttribute("stylesheet") : null);
		if(page!=null)
			request.getRequestDispatcher(page).include(request, response);
		else{ 
			String urlWithSessionID = response.encodeRedirectURL(link);
			if(((!link.startsWith("http://")|| !link.startsWith("https://")))&& !link.contains("://"))
				urlWithSessionID = "http://".concat(urlWithSessionID);
		    response.sendRedirect(urlWithSessionID);
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String page = request.getParameter("page");
		request.getParameterMap().clear();
		request.getRequestDispatcher(page).include(request, response);
	}

}
