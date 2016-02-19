package com.ibm.ca.PageServlets.GettingStartedPages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.FileReader.FileReader;
import com.ibm.ca.PageServlets.ApplicationServlet;
import com.ibm.ca.customNavigation.SidePageNav;
import com.ibm.ca.dom.Aside;
import com.ibm.ca.dom.Div;
import com.ibm.ca.dom.H;
import com.ibm.ca.dom.P;

/**
 * Servlet implementation class BasicSections
 */
@WebServlet("/BasicSections")
public class BasicSections extends ApplicationServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicSections() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		SidePageNav nav = new SidePageNav();
		nav.addLink("Creating A Doocument", "CreatingDocuments", false);
		nav.addLink("Google", "google.com", true);
		Aside navi = (Aside) nav.getSidePageNav();
		navi.addAttribute("style", "background-color : purple;color:red;position:fixed;");
		//navi.addAttribute("style", "position:fixed");
		bodyAdd(navi);
		bodyAdd(new H(2, "Addd", "lightblue	", "hEADERID", null));
		bodyAdd(new H(4, "PreAplha Release", "domClass", "hEADERID", null));
		Div div = new Div(FileReader.readFile(request.getServletContext().getRealPath("/templates/jaDom/CreatingDocuments.jaDom")));
		div.addAttribute("style", "width:75%;height:auto"); 
		div.addAttribute("domClass","right");
		bodyAdd(div);
		
		execute(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
