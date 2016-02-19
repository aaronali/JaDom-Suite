package com.ibm.ca.PageServlets.Api;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.CodeBuilders.StyleBuilder;
import com.ibm.ca.FileReader.FileReader;
import com.ibm.ca.PageServlets.ApplicationServlet;
import com.ibm.ca.customNavigation.ApiNav;
import com.ibm.ca.dom.*;
import com.sun.glass.ui.Application;
/**
 * Servlet implementation class Index
 */
@WebServlet("/Api")
public class Document extends ApplicationServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Document() {
        super();  
       
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response); 
		String className;
		if(request.getParameter("api")!=null)
			className = request.getParameter("api").trim();
		else className = null;
		Header header = new Header();
		Div div = new Div("",null,null,"float:right;width:70% ;",null);
		Code code = new Code("",null,null,"float:right;width:70% ;",null);
		URI contextUrl = URI.create(request.getRequestURL().toString()).resolve(request.getContextPath()); 
		if(className!=null) {
			((Head)this.document.getEmbeddedElements()[0]).addTitle(className);
			header.addDomElement(new H(1,className)); 
			try{
				URL url = new URL(contextUrl  + "/webapi/"+className);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String inputLine; 
				url=null; 
				while ((inputLine = in.readLine()) != null) {
					div.addDomElement(new P(inputLine + "\n"));
					inputLine=null;
				} 
				in.close();
				url = new URL(contextUrl  + "/webapi/"+className.concat(".Code"));
				 in = new BufferedReader(new InputStreamReader(url.openStream())); 
				url=null; 
		
				while ((inputLine = in.readLine()) != null) {
					code.appendHTML(inputLine + "\n");
					inputLine=null;
				} 
				in.close();
				in= null;
			}catch(Exception e){
				div.addDomElement(new P("Doumentation for this section is under construction, please check back soon"));
			}
		}else{
			header.addDomElement(new H(1,"Welcome to JaDom Api Documentaion"));
			((Head)this.document.getEmbeddedElements()[0]).addTitle("JaDom Api");
			div.addDomElement(new P("The documentation is still being developed, please check back soon for updates"));
		} 
		
		
		 String[] classNames = new String[0];
		 JarFile jarFile = new JarFile("/Users/aaronali/Documents/TrailzBeta/JaDomDemo2/src/main/webapp/WEB-INF/lib/jaDom.jar");
	       Enumeration<JarEntry> enums = jarFile.entries();
	       while (enums.hasMoreElements()) {
	    	   JarEntry entry = (JarEntry) enums.nextElement();
	    	   String name = entry.getName();
	    	   if(name.endsWith(".class") ){
	    		   if(name.contains("com/ibm/ca/dom")){
	    			 
		    		   String[] temp = new String[classNames.length+1];
		    		   System.arraycopy(classNames, 0, temp, 0, classNames.length);
		    		   temp[temp.length-1] =name.replace('/', '.').replace(".class", "");
		    		   classNames = new String[temp.length];
		    		   System.arraycopy(temp, 0, classNames, 0, temp.length); 
		    		   
	    		   }
	    	   } 
	         }	
 
	   	    
	    this.bodyAdd(header);
	    this.bodyAdd(ApiNav.getApiNav(  classNames) ); 
	 	this.bodyAdd(div) ; 
	 	Pre coded = new Pre();
	 	coded.addAttribute("style",  "float:right;width:70%;");
	 	coded.addDomElement(code);
	 	this.bodyAdd(coded);
		execute(response); 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	  /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
	private  Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       
         
        String path = packageName.replace('.', '/');
        Enumeration<?> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = (URL) resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return (Class[]) classes.toArray(new Class[classes.size()]);
    }
    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private  List findClasses(File directory, String packageName) throws ClassNotFoundException {
        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
