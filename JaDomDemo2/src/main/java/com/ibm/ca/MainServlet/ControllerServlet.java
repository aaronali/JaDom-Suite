package com.ibm.ca.MainServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.JavaScript.EventListener;
import com.ibm.ca.dom.ApplicationManager;
import com.ibm.ca.logger.Logger;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
 
		//ApplicationManager ap = new ApplicationManager();
		System.out.println("request.getContextPath()) = " +request.getContextPath());	
		if(request.getParameter("domlistener")!=null  && !request.getParameter("domlistener").isEmpty()){ 
			Logger.info("Getting current event listener"); 
			EventListener eventListenToActivate = getCurrentEvent(request);
			if(eventListenToActivate!=null){
			if(eventListenToActivate.getFunction().getClass() == com.ibm.ca.JavaScript.XMLHttpRequest.class){ 
				((com.ibm.ca.JavaScript.XMLHttpRequest)eventListenToActivate.getFunction()).getReponse();
			}
			if(eventListenToActivate.getResponseText()!=null &&eventListenToActivate.getResponseText().length()>0 )
				
				forwardJavaScriptResponseString(eventListenToActivate.getResponseText(), request, response);
			return;
			 
			}
		}else{
			ApplicationManager.removeSessionEventListeners(request.getSession().getId());
		}
		
			
		if(request.getParameter("page")==null){
			request.getRequestDispatcher("/Index").include(request, response);
			 return;
		}
		
		request.getRequestDispatcher("/"+request.getParameter("page")).include(request, response);

		 
		 
		
		/*	request.getRequestDispatcher("/Home.jsp").include(request, response);
			if(request.getParameter("page")!=null){
				response.getWriter().append("page= at: ").append(request.getParameter("page"));
				System.out.print(request.getParameterNames());
				System.out.print(request.getParameter("page"));
			}
		 
			
			
			FormBuilder fb = new FormBuilder(null, null,true);
			
			fb.inlineTextInput("LABEL inlineTextInput",23, 75, "value", "id1","TestPlaceHolder", "groupclass", "inputclass", "jscallout");
			fb.br();
			fb.build(InputType.TEXT, false, "LABEL",true,23,75 ,"vale", "id2",null, null, null, null);
			fb.br();
			fb.inlineTextInput("LABEL inlineTextInput",23, 75, "value", "id3","text inlin place holder " , "groupclass", "inputclass", "jscallout");
			fb.br();
			fb.build(InputType.CHECKBOX, false, "LABEL",true,23,23 ,"vale", "id4","idHolder", null, null, null);
			fb.br();
			String[] values ={"option1", "option2"};
			fb.inlineCheckBoxGroup("CheckBox", 23, 23,values, null,"Chjeck Boxes",null,null,null);
			request.getSession().setAttribute("HTMLbody",fb.getCode());
			request.getRequestDispatcher("/TemplateTest.jsp").include(request, response);
			
		
			*/
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.print("Posted");
		System.out.print(request.getParameterNames());
	}

	/**
	 * Returns the event listener from for the last fired dom event or returns null;
	 * @param request
	 * @return
	 */
	private EventListener getCurrentEvent(HttpServletRequest request){
		ApplicationManager ap = new ApplicationManager();
		for(EventListener eventListen  : ap.getEventListseners(request.getSession().getId())){  
		System.out.println(request.getParameter("domlistener"));;
		if(request.getParameter("domlistener").equals(eventListen.getRequestUrl())) 
			return eventListen; 
		}
		return null;
	}
	/**
	 * Forwards the javascript response back to the request
	 * @param text
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void forwardJavaScriptResponseString(String text, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Logger.info("Forwarding Response from session " + request.getSession().getId() +" :" +text);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache"); 
		response.setContentType("text/javascript"); 
		PrintWriter writer = response.getWriter();   
		writer.println(text);
		writer.close();
		writer=null; 
		return;
	}
}
