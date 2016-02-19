package com.ibm.ca.Listeners.Session;
   
import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import com.ibm.ca.CodeBuilders.NavBuilder;
import com.ibm.ca.MainServlet.AppManager; 
import com.ibm.ca.MainServlet.ObjectHelper;
import com.ibm.ca.Security.Secure; 
import com.ibm.ca.dom.Body;
import com.ibm.ca.dom.Div;
import com.ibm.ca.dom.Document;
import com.ibm.ca.dom.H;
import com.ibm.ca.dom.Head;
import com.ibm.ca.dom.Header; 
/**
 * Application Lifecycle Listener implementation class HttpSessionListener
 */
import com.ibm.ca.logger.Logger;
@WebListener
public class HttpSessionListener implements javax.servlet.http.HttpSessionListener {

	
	Map <String, HttpSession> sessions = new HashMap<String, HttpSession>();
	//private AppManager appManager;
	private Document defaultDoc;  
	
    public HttpSessionListener() { 
    	Logger.initializeLogging(); 
    	Body body = new Body( );
    	Div div= new Div();
    	Header header = new Header();
			header.addDomElement(new H(1,"JaDom"));
	    	div.addDomElement(header);;
	    	body.addDomElement(div);
	    	Head head = new Head();
	    	head.addTitle(AppManager.DEFAULT_TITLE);
	    	defaultDoc = new Document("html");
	    	defaultDoc.addDomElement(head);
	    	defaultDoc.addDomElement(body);  
	        NavBuilder nav = new NavBuilder(true,false); 
		//    AppManager appManager = new AppManager();
		//  appManager.initJqueryUI(session, active);
	    //	ApplicationManager.initJqueryUI(arg0.getSession()	);
			 nav.CreateNavTab();
			nav.navJustify(true);
			nav.addNavLink("Index", "Home", null);
			nav.addNavLink("GettingStarted", "Getting Started", null);
			nav.addNavLink("Api","Api Documentation", null);
			nav.addNavLink("Pages","Page Columns", null);
			nav.addNavLink("test.html", "Testing Page", null);
			body.addDomElement(nav.getAsSpan());
		Logger.info("Session Listener initilized");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  {   
    	Logger.info("Init session "+arg0.getSession());
    	sessions.put(arg0.getSession().getId(), arg0.getSession());  
    	AppManager.initSite(arg0.getSession(), true, true, true);
    	if(AppManager.isJqueryApp()){ 
    		defaultDoc.linkJavaScript("js/jquery-1.11.3.min.js");
    	}
    	if(AppManager.isBootStrapApp()){
    		defaultDoc.linkJavaScript("bootstrap/js/bootstrap.min.js");
    		defaultDoc.linkStyleSheet("bootstrap/css/bootstrap.min.css");
    	}
    	if(AppManager.isAngularApp()){ 
    		defaultDoc.linkJavaScript("js\\angular.min.js");
    	}

		defaultDoc.linkStyleSheet("css\\style.css");
    		 
			  Secure secure;
			try {
				secure = new Secure();
			
			  String docString = ObjectHelper.objectToString(defaultDoc); 
			  arg0.getSession().setAttribute("defaultDocument", secure.encrypt(docString)); 
			  arg0.getSession().setAttribute("document", secure.encrypt(docString)); 
			  AppManager.addAttribute("docKey"+arg0.getSession().getId(), secure.getKey());
			  secure = null;
			  docString = null;
		 
    	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    NavBuilder nav = new NavBuilder(true,false); 
	//   AppManager appManager = new AppManager();
	//  appManager.initJqueryUI(session, active);
    //	ApplicationManager.initJqueryUI(arg0.getSession()	);
		 nav.CreateNavTab();
		nav.navJustify(true);
		nav.addNavLink("Index", "Home", null);
		nav.addNavLink("GettingStarted", "Getting Started", null);
		nav.addNavLink("Api","Api Documentation", null);
		nav.addNavLink("Pages","Page Columns", null);
		nav.addNavLink("test.html", "Testing Page", null);
		Secure secure1;
		try {
			secure1 = new Secure( AppManager.getAttribute("docKey"+arg0.getSession().getId())); 
			String navString = secure1.encrypt(ObjectHelper.objectToString(nav.getAsSpan()));
			arg0.getSession().setAttribute("appNavigation", secure1.encrypt(ObjectHelper.objectToString(nav.getAsSpan())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arg0.getSession().setAttribute("stlyeSheet", "");
		Logger.info("Init session "+arg0.getSession() + " Done : defaultDoc = " +this.defaultDoc.toString());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         sessions.remove(arg0.getSession().getId());
    }
	
}
