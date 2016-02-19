package com.ibm.ca.PageServlets;

import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.JavaScript.EventType;
import com.ibm.ca.JavaScript.XMLHttpRequest;
import com.ibm.ca.FileReader.FileReader;
import com.ibm.ca.JavaScript.DomFunction;
import com.ibm.ca.JavaScript.EventListener;
import com.ibm.ca.dom.*;
import com.ibm.ca.logger.Logger;
import com.ibm.ca.test.User;

import jdk.nashorn.internal.runtime.Context; 
/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")

public class Index extends ApplicationServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super(); 
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response); 
		URI contextUrl = URI.create(request.getRequestURL().toString()).resolve(request.getContextPath()); 
			Img img = new Img("images/JaDom.png","walking dead",false);
			Img g = new Img("images/JaDom.png", "JaDom",false);
			g.addAttribute("domClass", "center"); 
			Header header = new Header(); 
			header.addDomElement(new H(2,"JaDOM",null,"center", null)); 
			header.addDomElement(new H(4,"Pre beta release")); 
			String gh= getServletContext().getRealPath("/templates/jaDom/JaDomIntro.jaDom");

			P p = new P();
			p.innnHtmlFromFile(gh);
			p.addAttribute("domClass", "centre");
			Div div = new Div();
			div.addAttribute("style", "width:100%");
			div.addAttribute("domClass", "center");
			DomFunction f1 =  new DomFunction(null,div.getElementById().concat(".innerHTML=event.target;"),null);

	 		DomFunction f2 =  new DomFunction(null,"alert(\"this is a \" + eventListenerNamePlaceHolder.responseText);",null);
	 		java.lang.Object[] param=  {"tets"};
		  	 g.ondrag(f1,"test",param, Id()); 
	 	  div.onclick(f2,"test",param, Id());
		 	div.addDomElement(g);
			//this.document.getEmbeddedElements()[1].onload(f1,"test",param, Id());
			this.bodyAdd(div);
			this.bodyAdd(header);
			this.bodyAdd(p); 
		 
	 
			
		 
		
		execute(response); 

		request.getParameterMap().clear();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
