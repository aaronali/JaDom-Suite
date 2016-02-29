package com.ibm.ca.test;
 
import java.io.IOException;
import java.util.logging.Level;

import javax.swing.text.html.HTML;

import org.xml.sax.SAXException;
 
import com.ibm.ca.FileReader.FileReader;
import com.ibm.ca.JavaScript.DomFunction;
import com.ibm.ca.JavaScript.EventListener;
import com.ibm.ca.JavaScript.JavaScript;
import com.ibm.ca.JavaScript.XMLHttpRequest;
import com.ibm.ca.Network.IpAddress;
import com.ibm.ca.jadom.ApplicationManager;
import com.ibm.ca.jadom.Body;
import com.ibm.ca.jadom.Div;
import com.ibm.ca.jadom.Document;
import com.ibm.ca.jadom.H;
import com.ibm.ca.jadom.Header;
import com.ibm.ca.jadom.Img;
import com.ibm.ca.jadom.P;
import com.ibm.ca.jadom.*;
import com.ibm.ca.logger.Logger; 
public class testtest {

	
	
	public static void main(String[] args) {
		 
		/*
		 FileReader fr = new FileReader();
		 String filename = "appConfig/app.config";
		 FileReader.createFile(filename); 
		 FileReader.appendToFile(filename, "test insert");
		 
		 
		Logger l = new Logger();
		Logger.initializeLogging(); ;
		 Logger.info( "This is a test INFO message");
		 Logger.warning("This is a test WARNING message0");
		 Logger.info( "This is a test INFO message1");
		 Logger.warning("This is a test WARNING message2"); 
		 Logger.info( "This is a test INFO message3");
		 Logger.warning("This is a test WARNING message4"); ;
		StyleBuilder sb = new StyleBuilder();
		String styleName = "styleName";
		String[] valueNames={"valueName", "valuename2"};
		String[] values ={"value1", "value2"};
		
		sb.addStyle(styleName, valueNames, values);
H header = new H (2,"header");
System.out.println(header.toString());
P p = new P("paragraph yext");
System.out.println(p.toString());

	
	
	SyleBuilder2 sb2 = new SyleBuilder2();
	
	 
	
	System.out.println(p.toString());
	 
		  
	A link = new A("Google","google.com",true);
	Abbr abbr = new Abbr("World Health Prganization", "WHO");
	 Article art = new Article(  "articled html code ");
	 
	 System.out.println(art);
	 BlockQuote blockQuote = new BlockQuote("HTML bods");
	 System.out.println(blockQuote.toString());
	   blockQuote = new BlockQuote("HTML bods","this cite");
	 System.out.println(blockQuote.toString());
	   BlockQuote  as= new BlockQuote("html code", "some site", "myid", ApplicationManager.STRING_DOMCLASS, "color:blue", "onlick=\"alert()\"");
	 
	 System.out.println("----------------------------") ;
	 System.out.println("----------------------------") ;
	 System.out.println("----------------------------") ;
	 System.out.println("----------------------------");
	 Html html = new Html(true);
	 html.add(link);
	 html.add(abbr);
	 html.add(blockQuote);
	 html.add(as);
	 sb2.addStyle(html.getElements());
	 System.out.println(html.getHTML());
	 System.out.println(sb2.generateStyleSheet()); 
	 
	 Area area = new Area();
	 
	 System.out.println(area.toString());
	 Integer[] coords ={12,12,23,34,456,67,78,787,345,123};
	 Coord coor = new Coord(coords);
	 area = new Area(  coor, null);

	 
	 Base b = new Base(  "http:\\this.com", false);
	 System.out.println(area.toString());
	 
	 
	 System.out.println(b.toString());
	
	art.addDomElement(link);
	
	 Q q= new Q("I said this|","alr");
	 Body body = new Body();
	 body.addDomElement(area);
	 body.addDomElement(link);
	 body.addDomElement(q);	
	 body.addDomElement(art);
	 System.out.println(body.toString());
	 */
		
		System.out.println("adsasdasdasdasdasdasdasdasdasdasdasd"
				+ "asdasdas"
				+ "das"
				+ "d"
				+ "asdasdasdas"
				+ "d"
				+ "asd"
				+ "asd"
				+ "asd");
		IpAddress d = new IpAddress("132.168.002.001", 9999);
		System.out.println(d.toString());
		String[] args1 ={"arg1","arg2"};
		DomFunction function = new DomFunction("FunctionName", "alert(\"test js\");alert('test'); stat2;stmt3;", args1);
		JavaScript js = new JavaScript();
		js.addJS("onclick=\"alert('test'); stat2;stmt3;\" ");
		js.addJavaScipt(function);
		System.out.println(js.toString());
		
		js= new JavaScript();
		System.out.println(js.toString());
		Document doc = new Document();
		Body body = new Body();
		Img img = new Img("images/wd.png","walking dead",false);
		body.addDomElement(img);
		Header header = new Header(); 
		header.addDomElement(new H(2,"JaDOM",null,"center", null)); 
		header.addDomElement(new H(4,"Pre beta release"));
		P p = new P("JaDom is an intesive framework that allows the full manipulation of the dom through pure JAVA code. JaDom includes a complete library of html element classes designed"
			+ "in Java that can be easily diplayed in the browser.<br>JaDom allws you to create web applications with out even having to code a line of css or html. The powerful suite of tools"
			+ " leverages the ability to manipultate dom and get the effets you desire. Web applications can be quickly deployed using bootstapp, jquery, or angular."); 
		DomFunction f =  new DomFunction(null,"alert('Success');",null);
		// EventType evt =EventType.oncanplay; 
		body.addDomElement(header);
		XMLHttpRequest x=new XMLHttpRequest( "get",f, "what");
		p.addEventListener("click", x, true);
		EventListener ev = new EventListener(	"click", f, false);
		EventListener e1v = new EventListener(	"mouseup", f, false);
		ev.setId(ev.getId().concat("sessionId"));
		p.addEventListener(ev);
		Div div = new Div();
		e1v.setId(e1v.getId().concat("sessionId"));
		div.addEventListener(e1v);
		System.out.println("\n\n\n");
		ApplicationManager ap = new ApplicationManager();
		 
		body.addDomElement(p);
		body.addDomElement(div);
		System.out.println("\n\n\n");
		System.out.println(ap.getEventListseners()); 
		ApplicationManager.removeEventListeners(body);
		System.out.println("\n\n\n");
		System.out.println(ap.getEventListseners()); 
		
	} 
}
