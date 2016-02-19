package com.ibm.ca.MainServlet;
 
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.ibm.ca.dom.Document;

public class AppManager {

	public static final String DEFAULT_TITLE = "JaDOM";

	private Document document;
	private static HashMap<String,String> attributes = new HashMap<String,String>();

	private static boolean isBootStrapApp = false;
	private static boolean isAngularApp  = false;
	private static boolean isJqueryApp = false;
	private static boolean isJqueryUiApp = false;
	
	public AppManager(){
		
	}
	public AppManager(Document document){
		this.document = document;
	}
	public Document getDocument(){
		return document;
	}
	
	
	public static void initSite(HttpSession session, boolean jquery, boolean bootstrap, boolean angular){
		 
		if(jquery){
			isJqueryApp = true;
			session.setAttribute("jquery", true);
		}
		if(bootstrap){
			isBootStrapApp=true;
			isJqueryApp = true;
			session.setAttribute("bootstrap", true);
			session.setAttribute("jquery", true);
		}
		if(angular){
			isAngularApp   = true;
			session.setAttribute("angular", true);
		} 
		
	 
	}
	 
	public static synchronized final boolean isAngularApp() {
		return isAngularApp;
	}

	public static synchronized final boolean isJqueryApp() {
		return isJqueryApp;
	}




	public static synchronized final boolean isJqueryUiApp() {
		return isJqueryUiApp;
	}




	public static void initJqueryUI(HttpSession session, boolean active){
		session.setAttribute("jqueryUi", active);
		isJqueryUiApp = active;
	}
	
	public static void enableBootstrap(HttpSession session, boolean active){   
		 session.setAttribute("bootstrap", active);
		 isBootStrapApp =active; 
	}
	
	
	public static boolean isBootStrapApp(){
		return isBootStrapApp;
	}
	
	 
	 
	public static void  addAttribute(String attributeName, String attributeValue) {
		attributes.put(attributeName, attributeValue);
		
	}
	public static String getAttribute(String attributeName) {
		if(attributes.containsKey(attributeName))
			return attributes.get(attributeName);
		return null; 
	}
	 
}
