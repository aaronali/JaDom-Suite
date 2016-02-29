package com.ibm.ca.MainServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.JavaScript.EventListener;
import com.ibm.ca.Navigator.Navigator;
import com.ibm.ca.Security.Secure;
import com.ibm.ca.jadom.ApplicationManager;
import com.ibm.ca.jadom.Document;
import com.ibm.ca.jadom.History;
import com.ibm.ca.jadom.Iframe;
import com.ibm.ca.jadom.Location;
import com.ibm.ca.jadom.Screen;
import com.ibm.ca.jadom.Window;
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
			if(!request.getParameter("page")!=null){
				response.getWriter().append("page= at: ").append(!request.getParameter("page"));
				System.out.print(request.getParameterNames());
				System.out.print(!request.getParameter("page"));
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
		 
		if(request.getParameter("newWindow")!=null && Boolean.valueOf(request.getParameter("newWindow"))){
			System.out.println("creating new windopw\n\n\n___________");
			String NULL  =(request.getParameter("undefined")!=null)?request.getParameter("undefined"):"undefined";
			
			String defaultStatus  =(!request.getParameter("defaultStatus").equals(NULL))?request.getParameter("defaultStatus"):"";
			boolean closed = (!request.getParameter("closed").equals(NULL))?Boolean.valueOf(request.getParameter("closed")):false;
			long mozInnerScreenX = (!request.getParameter("mozInnerScreenX").equals(NULL))?Long.valueOf(request.getParameter("mozInnerScreenX")):0;
			System.out.println(request.getParameter("mozInnerScreenY"));
			long mozInnerScreenY = (request.getParameter("mozInnerScreenY")!=null ||((request.getParameter("mozInnerScreenY")!=null && !request.getParameter("mozInnerScreenY").equals(NULL))))?Long.valueOf(request.getParameter("mozInnerScreenY")):0;
			boolean fullscreen = (request.getParameter("fullscreen")!=null || (!request.getParameter("fullscreen").equals(NULL)))?Boolean.valueOf(request.getParameter("fullscreen")):false;
			long length = (!request.getParameter("length").equals(NULL))?Long.valueOf(request.getParameter("length")):0;
			System.out.println("hoffset");
			System.out.println(request.getParameter("hoffset"));
			System.out.println("request.getParameter( hoffse )!=null");
			System.out.println(request.getParameter("hoffset")!=null);

			System.out.println("!request.getParameter(\"hoffset\").equals(NULL)");
			System.out.println(!request.getParameter("hoffset").equals(NULL));
			long hoffset = (!request.getParameter("hoffset").equals(NULL))?Long.valueOf(request.getParameter("hoffset")):0;
			long mozPaintCount = (!request.getParameter("mozPaintCount").equals(NULL))?Long.valueOf(request.getParameter("mozPaintCount")):0;
			long innerHeight = (!request.getParameter("innerHeight").equals(NULL))?Long.valueOf(request.getParameter("innerHeight")):0;
			long innerWidth = (request.getParameter("innerWidth")!=null || (request.getParameter("innerWidth")!=null && !request.getParameter("innerWidth").equals(NULL)))?Long.valueOf(request.getParameter("innerWidth")):0;
			long outerHeight = (request.getParameter("outerHeight")!=null || (request.getParameter("outerHeight")!=null && !request.getParameter("outerHeight").equals(NULL)))?Long.valueOf(request.getParameter("outerHeight")):0;
			long outerWidth = (request.getParameter("outerWidth")!=null || (request.getParameter("outerWidth")!=null && !request.getParameter("outerWidth").equals(NULL)))?Long.valueOf(request.getParameter("outerWidth")):0;
			long InnerScreenY = (request.getParameter("InnerScreenY")!=null && !request.getParameter("InnerScreenY").equals(NULL))?Long.valueOf(request.getParameter("InnerScreenY")):0;
			long InnerScreenX = (request.getParameter("InnerScreenX")!=null ||(request.getParameter("InnerScreenX")!=null && !request.getParameter("InnerScreenX").equals(NULL)))?Long.valueOf(request.getParameter("InnerScreenX")):0;
			long pageYOffset = (request.getParameter("pageYOffset")!=null || !request.getParameter("pageYOffset").equals(NULL))?Long.valueOf(request.getParameter("pageYOffset")):0;
			String name = (!request.getParameter("name").equals(NULL))?request.getParameter("name"):"";
			long pageXOffset = (!request.getParameter("pageXOffset").equals(NULL))?Long.valueOf(request.getParameter("pageXOffset")):0;
			long screenX = (request.getParameter("screenX")!=null || !request.getParameter("screenX").equals(NULL))?Long.valueOf(request.getParameter("screenX")):0;
			long screenY = (request.getParameter("screenY")!=null || (request.getParameter("screenY")!=null && !request.getParameter("screenY").equals(NULL)))?Long.valueOf(request.getParameter("screenY")):0;
			long screenLeft = (request.getParameter("screenLeft")!=null || (request.getParameter("screenLeft")!=null && !request.getParameter("screenLeft").equals(NULL)))?Long.valueOf(request.getParameter("screenLeft")):0;
			long screenTop = (request.getParameter("screenTop")!=null || (request.getParameter("screenTop")!=null && !request.getParameter("screenTop").equals(NULL)))?Long.valueOf(request.getParameter("screenTop")):0;
			long scrollX = (!request.getParameter("scrollX").equals(NULL))?Long.valueOf(request.getParameter("scrollX")):0;
			String status = (!request.getParameter("status").equals(NULL))?request.getParameter("status"):"";
			long scrollY = (!request.getParameter("scrollY").equals(NULL))?Long.valueOf(request.getParameter("scrollY")):0;
			long wOffset = (!request.getParameter("wOffset").equals(NULL))?Long.valueOf(request.getParameter("wOffset")):0;
			long widHieght = (!request.getParameter("widHieght").equals(NULL))?Long.valueOf(request.getParameter("widHieght")):0;
			long wimHeight = (!request.getParameter("wimHeight").equals(NULL))?Long.valueOf(request.getParameter("wimHeight")):0;
			long winWidth = (!request.getParameter("winWidth").equals(NULL))?Long.valueOf(request.getParameter("winWidth")):0;
			String id = request.getSession().getId();
			System.out.println("id = " + id);
				Window window = new Window(  closed,  defaultStatus,   innerHeight,  innerWidth,  length,   name, 
					  outerHeight,  outerWidth,  pageXOffset, pageYOffset,screenLeft,  screenTop,
					 screenX,  screenY,  scrollX,  scrollY,   status ,hoffset,mozPaintCount,InnerScreenY,InnerScreenX,
					 wOffset , widHieght,wimHeight, winWidth,id) ;
			Secure secure;
			try {
				secure = new Secure(AppManager.getAttribute("docKey"+request.getSession().getId()));
			
				Document document =   (Document)(ObjectHelper.stringToObject(secure.decrypt((String)request.getSession().getAttribute("defaultDocument")), com.ibm.ca.jadom.Document.class));
				Window s = ((Window) ApplicationManager.getGlobal(request.getSession().getId().concat("WINDOW_OBJECT")));
				document.setWindow(window,request.getSession().getId().concat("WINDOW_OBJECT"));
				AppManager.addAttribute("docKey"+id, secure.getKey());
				secure = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(window);
			ApplicationManager.addGlobal(request.getSession().getId().concat("WINDOW_OBJECT"), window);
			//request.getRequestDispatcher("/window");

		}
		
		
		if(request.getParameter("newLocation")!=null & Boolean.valueOf(request.getParameter("newLocation"))){

			System.out.println("caller " + request.getParameter("caller"));
			System.out.println("name "  + request.getParameter("name"));
			System.out.println("hash "+ request.getParameter("hash"));
			System.out.println("host "+ request.getParameter("host"));
			System.out.println("href "+ request.getParameter("href"));
			System.out.println("orgin " + request.getParameter("orgin"));
			System.out.println("protocal "+request.getParameter("protocal"));
			System.out.println("search "+request.getParameter("search")); 
			}
		if(request.getParameter("requestWindow")!=null){
			response.getWriter().write("requestWindow=true");
			System.out.println("request recieved");
			response.getWriter().close();
		}
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
		if(!request.getParameter("domlistener").equals(eventListen.getRequestUrl())) 
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
