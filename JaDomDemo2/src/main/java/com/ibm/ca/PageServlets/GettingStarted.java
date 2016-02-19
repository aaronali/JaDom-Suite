package com.ibm.ca.PageServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.FileReader.FileReader;
import com.ibm.ca.JavaScript.DomFunction;
import com.ibm.ca.customNavigation.SidePageNav;
import com.ibm.ca.dom.*;
import com.ibm.ca.logger.Logger;

/**
 * Servlet implementation class Index
 */
@WebServlet("GettingStarted")
public class GettingStarted extends ApplicationServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GettingStarted() {
    	super();
    	// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		ArrayList<String> strs =(ArrayList<String>) FileReader.getDirListing(request.getServletContext().getRealPath("/GettingStarted/JaDom"));
 
	
		Div div = new Div();  
		bodyAdd(new H(2, "Getting Started with JaDom", "lightblue	", "hEADERID", null));
		bodyAdd(new H(4, "PreAplha Release", "domClass", "hEADERID", null));
		bodyAdd(new P("Any thing is possible", null, null, null, null));
		
		SidePageNav nav = new SidePageNav();
		for(String s :strs){
			DomFunction f1 =  new DomFunction(null,div.getElementById()+".innerHTML = eventListenerNamePlaceHolder.responseText",null); 
			String responseText = FileReader.readFile(request.getServletContext().getRealPath("/GettingStarted/JaDom/".concat(s)));
			System.out.println(responseText);
			java.lang.Object[] param=  {responseText};
			A a = new A(s.substring(2, s.length()).replace(".jaDom", "").replace("_", " ").replace(".", " "),s,true);
			a.inpage=true;
			//a.onclick();
			
			a.onclick((java.lang.Object)f1,responseText,param, Id());
			nav.addLink(a);
		 
		}
		Aside navi = (Aside) nav.getSidePageNav();
		navi.addAttribute("style", "background-color : black;color:red;position:fixed;min-width:175px;");
		//navi.addAttribute("style", "position:fixed");
		bodyAdd(navi);
		
	 
		
		div.addAttribute("style", "width:75%;height:auto"); 
		div.addAttribute("domClass","right");
		bodyAdd(div);
	 
	 
		execute(response);
		/**
		 
		request.getSession().setAttribute("HTMLbody",body.toString());
		request.getRequestDispatcher("/TemplateTest.jsp").include(request, response);
		**/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
