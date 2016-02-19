package com.ibm.ca.PageServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.ca.MainServlet.AppManager;
import com.ibm.ca.MainServlet.ObjectHelper;
import com.ibm.ca.Security.Secure; 
import com.ibm.ca.dom.DOMelement;
import com.ibm.ca.dom.Div;
import com.ibm.ca.dom.Document; 
import com.ibm.ca.dom.Head;
import com.ibm.ca.logger.Logger; 

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public abstract class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected com.ibm.ca.dom.Document document = new com.ibm.ca.dom.Document("html");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
        super(); 
    }
    

    private HttpSession session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.session =request.getSession();
		Logger.info("ApplicationServlet for "+session.getId());
		try {
			Logger.info("Decrypting Docuemnt");
			Secure secure=new Secure(AppManager.getAttribute("docKey"+this.session.getId()));
			this.document =   (Document)(ObjectHelper.stringToObject(secure.decrypt((String)session.getAttribute("defaultDocument")), com.ibm.ca.dom.Document.class));
			secure = null;
			Logger.info("Doucment decrypted");

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			Logger.info("Doucment decryption error : ".concat(e.getMessage()));
			this.document=new Document("html");
			document.addDomElement(new Div("<p>Unable to retrieve encrypted site. Please contact the site administration<br><br></p>",null,null, "color:red;", null));
			document.addDomElement(new Div("<code>"+e.getStackTrace().toString()+"</code>",null,null, "color:red;", null)); 
		} catch (Exception e) { 
			this.document=new Document("html");
			Logger.info("Doucment decryption error : ".concat(e.getMessage()));
			document.addDomElement(new Div("<p>Unable to retrieve encrypted site. Please contact the site administration<br><br></p>",null,null, "color:red;", null));
			document.addDomElement(new Div("<code>"+e.getStackTrace().toString()+"</code>",null,null, "color:red;", null)); 
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}
	
	/**
	 * Sets th current title for the page
	 * @param title
	 */
	protected void setTitle(String title){ 
		((Head)document.getEmbeddedElements()[0]).addTitle(title);
	}
	/**
	 * Adds the element ot the body
	 * @param element
	 */
	protected void bodyAdd(DOMelement  element){  
			document.getEmbeddedElements()[1].addDomElement(element); 
	}
	
	protected void headAdd(DOMelement  element){ 
		 
			document.getEmbeddedElements()[0].addDomElement(element);
		 
	}
	
	
	/**
	 * Writes the document to the response Writer
	 * @param response
	 */
	protected void execute(HttpServletResponse response){
		
		try {
			//Write the document document the session.
			// This is mainly for implementation and manipulatoin of jsps and can be excluded when serving info solely 
			// from the page servelets
			Secure secure = new Secure(); 
			secure.SetKey(AppManager.getAttribute("docKey"+session.getId()));
			this.session.setAttribute("document",secure.encrypt(ObjectHelper.objectToString(this.document)));
			secure =null;
		} catch (Exception e1) {
			PrintWriter writer;
			try {
				writer = response.getWriter();
			    writer.write(this.document.toString());	   
			    writer.close();
				e1.printStackTrace();
				return;
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
		PrintWriter writer; 
		// Below we are grabbing the encrypted session document and writing it as html
		// we could optionally grab the servlets document object and display it with out the need for encryption
		try {
			
			writer = response.getWriter();
			Secure secure =  new Secure(AppManager.getAttribute("docKey"+this.session.getId()));
			writer.write(((Document)(ObjectHelper.stringToObject(secure.decrypt((String)session.getAttribute("document")), com.ibm.ca.dom.Document.class))).toString());
			secure =null;
			writer.close();
			writer=null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
		//ApplicationManager.addEventListeners(this.document);
	} 
	/**
	 * Retuens the current session associate with the current running instance
	 * @return
	 */
	public HttpSession Session(){
		return this.session;
	}
	/**
	 * Returns the session id associated with he current running instance
	 * @return
	 */
	public String Id(){
		return this.session.getId();
	} 
}
