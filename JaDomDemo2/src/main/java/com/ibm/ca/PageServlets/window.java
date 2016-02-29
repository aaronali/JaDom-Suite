package com.ibm.ca.PageServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.MainServlet.AppManager;
import com.ibm.ca.MainServlet.ObjectHelper;
import com.ibm.ca.Security.Secure;
import com.ibm.ca.jadom.ApplicationManager;
import com.ibm.ca.jadom.Window;

/**
 * Servlet implementation class window
 */
@WebServlet({ "/window", "/windowsResize" })
public class window  extends ApplicationServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public window() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		this.document.setWindow((Window)ApplicationManager.getGlobal(request.getSession().getId().concat("WINDOW_OBJECT")),request.getSession().getId().concat("WINDOW_OBJECT"));
		 
		try {
			 
		  Secure secure =  new Secure(AppManager.getAttribute("docKey"+Id()));
		  String docString = ObjectHelper.objectToString(document.toString());  
		  Session().setAttribute("document", secure.encrypt(docString));  
		  secure = null;
		  docString = null;
	 
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.execute(response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
