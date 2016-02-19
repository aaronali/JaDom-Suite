package com.ibm.ca.CodeBuilders;

import com.ibm.ca.MainServlet.ApplicationManager;

public class HtmlBuilder {

	/** html header open = &ltheader&gt  **/
	private String headerOp = "<header>";
	/** html header close =  &lt/header&gt  */
	String headerCl = "</header>";
	/** html paragraph close = &lt/p&gt **/
	String paragraphCl="</p>";  
	/** html anchor close = &lt/a&gt **/
	String anchorCl = "</a>";
	/** char = &lt **/
	char lt ='<';
	/** char = &gt **/
    char gt ='>';
    /** char = / **/
    char bk ='/';
    /** html span = &lt/span&gt **/
    String spanCl= "</span>";
    /** html nav = &lt/nav&gt **/
    String navCl="<nav/>";
    String CLASS = "class =";
    
    StyleBuilder generatedStyleSheet = new StyleBuilder();
    private int id =0;
    
    
    /** enable boot strap on elements **/
	boolean bootstrap;
	/** StringBuilder for appending all the HTML elements **/
	StringBuilder htmlCode = new StringBuilder();
	
	
	/**
	 * Default constructor
	 * @param bootstrapas boolean
	 */
	public HtmlBuilder(boolean bootstrap){
		this.bootstrap = bootstrap;
	}
	
	/**
	 * Returns the html code from this instance
	 * @return htmlCode as String
	 */
	public String getCode(){
		return htmlCode.toString();
	}
	
	
	
	
	/**
	 * Adds multiple line breaks to the html
	 * @param numberOfBreaks as int
	 */
	public void addBrMulti(int numberOfBreaks){
		while(numberOfBreaks>0){
			addBr();
			numberOfBreaks--;
		}
	}
	
	/**
	 * Adds a line break to the html <b>g&ltbr/&gt</b>
	 */
	public void addBr(){
		htmlCode.append("<br/>\n");
	}
	
	/**
	 * Adds a header to the html using the default header specs inside the ApplicationManager class
	 * @param size
	 * @param text
	 */
	public void addHeader(int size, String text){
		 addHeader( size,  text,  ApplicationManager.DEFAULT_HEADER_CLASS,null, ApplicationManager.DEFAULT_HEADER_JS);
	}
	
	/**
	 * Adds a header to the html using the given class id and javascript. Any values left as null will not be included
	 * in the html element. 
	 * @param headerSize
	 * @param headerText
	 * @param domClass
	 * @param headerId
	 * @param jsCallout
	 */
	public void addHeader(int headerSize, String headerText, String domClass , String headerId, String jsCallout){
		String h1= 'h'+ String.valueOf(headerSize);
		if(jsCallout==null) jsCallout="";
		if(bootstrap) htmlCode.append("\n\n"+headerOp+"\n");
		htmlCode.append("     <"+h1+ " class='"+domClass+"'  id='"+headerId+"' "+ jsCallout +gt); 
		htmlCode.append(headerText+"<"+h1+">\n");
		if(bootstrap) htmlCode.append(headerCl+"\n\n");
	}

	/**
	 * Adds the paragraph to the html using the given default paragraph specs from the ApplicationManager class
	 * @param paragraphText
	 * @param id
	 */
	public void addParagraph(String paragraphText,String id){ 
		 addParagraph( paragraphText, ApplicationManager.DEFAULT_PARAGRAPH_LINESIZE ,ApplicationManager.DEFAULT_PARAGRAPH_FONTSIZE, ApplicationManager.DEFAULT_PARAGRAPH_DOM_CLASS ,id, ApplicationManager.DEFAULT_PARAGRAPH_JAVASCRIPT );		
	}
		
	/**
	 * Adds a paragraph element to the html
	 * @param message
	 * @param lineSize
	 * @param fontSize
	 * @param domClass
	 * @param id
	 * @param jsCallout
	 */
	public void addParagraph(String message,int lineSize, int fontSize, String domClass, String id, String jsCallout){
		htmlCode.append("<p");
		if(ApplicationManager.INLINE_SYTLES){
			addInlineStyle(lineSize, fontSize, domClass, id, jsCallout));
		}
		htmlCode.append("\n<p style='");
		htmlCode.append((lineSize!=0) ? " line-height:"+ lineSize +"%;" : "");
		htmlCode.append((fontSize!=0) ? " font-size:"+ fontSize +"px;" : "");
		htmlCode.append("'");
		htmlCode.append((domClass!=null) ? " class='"+ domClass +"'" : "");
		htmlCode.append((id!=null) ? " id='"+ id +"'" : "");
		htmlCode.append((jsCallout!=null) ? " "+jsCallout : ""); 
		htmlCode.append(">\n");
		htmlCode.append("     "+message+"\n"+this.paragraphCl+"\n");
	}
	
	/**
	 * Starts the html div tag with the given elements
	 * @param lineSize
	 * @param fontSize
	 * @param domClass
	 * @param id
	 * @param jsCallout
	 */
	public void addDivOp(int lineSize, int fontSize, String domClass, String id, String jsCallout){
		htmlCode.append("\n\n<div style='");
		htmlCode.append((lineSize!=0) ? " line-height:"+ lineSize +"%;" : "");
		htmlCode.append((fontSize!=0) ? " font-size:"+ fontSize +"px;" : "");
		htmlCode.append("'");
		htmlCode.append((domClass!=null) ? " class='"+ domClass +"'" : "");
		htmlCode.append((id!=null) ? " id='"+ id +"'" : "");
		htmlCode.append((jsCallout!=null) ? " "+jsCallout : ""); 
		htmlCode.append(">\n"); 
	}
	
	/**
	 * Inserts a html div close tag
	 */
	public void addDivCl(){
		htmlCode.append("</div>\n\n");
	}
	
	/**
	 * Adds the text as plain text to the html object
	 * @param message
	 */
	public void addText(String message){
		htmlCode.append(message);
	}
	
	/**
	 * Adds the given message in a span tag
	 * @param message
	 * @param lineSizePercent
	 * @param fontSizePx
	 * @param domClass
	 * @param id
	 * @param jsCallout
	 */
	public void addTextSpan(String message , int lineSizePercent, int fontSizePx, String domClass, String id, String jsCallout){
		htmlCode.append("\n\n<span "); 
		addInlineStyle(lineSizePercent, fontSizePx, domClass, id, jsCallout);
		htmlCode.append(">");
		htmlCode.append("\n     "+message+"\n"+this.spanCl+"\n\n"); 
		
	}
	
	/**
	 * Adds a external or internal link to the html. To open the link in a new tab use the jsCallOut value to add
	 * the target value after or before your inline javascript.
	 * @param message
	 * @param href
	 * @param isExternal
	 * @param lineSizePercent
	 * @param fontSizePx
	 * @param domClass
	 * @param id
	 * @param jsCallout
	 */
	public void addLink(String message,String href,boolean isExternal, int lineSizePercent, int fontSizePx, String domClass, String id, String jsCallout){
		if(!isExternal){
			htmlCode.append("\n<a href='Link?page="+href+"' "); 
		} else{
		htmlCode.append("\n<a href='"+href+ "' ");
		}
		addInlineStyle(lineSizePercent, fontSizePx, domClass, id, jsCallout);
		htmlCode.append(">\n");
		htmlCode.append("     "+message+"\n"+this.anchorCl+"\n\n");
		
	}
	
	/**
	 * Adds inline styles , id, class , and javascript to the current html
	 * @param lineSizePercent
	 * @param fontSizePx
	 * @param domClass
	 * @param id
	 * @param jsCallout
	 */
	private String  addInlineStyle(int lineSizePercent, int fontSizePx, String domClass, String id, String jsCallout){
		if(ApplicationManager.INLINE_SYTLES){
			 
			htmlCode.append(" style='");
			if(fontSizePx>0 || lineSizePercent>0){
			 htmlCode.append((lineSizePercent!=0) ? " line-height:"+ lineSizePercent +"%;" : ""); 
			}
			htmlCode.append((fontSizePx!=0) ? " font-size:"+ fontSizePx +"px;" : "");
			if(customStyleNames!=null){
				htmlCode.append(this.getCustomStyle(className));
			}
			htmlCode.append("'");
			htmlCode.append((domClass!=null) ? " class='"+ domClass +"'" : ""); 
			htmlCode.append((id!=null) ? " id='"+ id +"'" : ""); 
			htmlCode.append((jsCallout!=null) ? " "+ jsCallout : "");
		}else{
			String className =String.valueOf(id.charAt(0)).toUpperCase();
			className ="appParagraph"+ className + id.substring(1);
			String[] valueNames=
				{"font-size", "line-height"};
			this.generatedStyleSheet.addStyle(className, valueNames);
		}
	}
	
	private String[] customStyleNames;
	private String[] customStyleValues;
	private boolean[] customStyleInline;
	public void setStyle(String[] names, String[] values, boolean[] inline){
		customStyleNames = names;
		customStyleValues = values;
		customStyleInline = inline;
	}
	
	/**
	 * returns a string with the custom style class inline or returns null if using a style sheet
	 * @param className
	 * @return
	 */
	public    String getCustomStyle(String className, String[] names, String[] values){
		String styleString = "";
		if(customStyleNames!=null){
			for(int i =0; i< customStyleNames.length;i++){
				if((customStyleInline!=null) && customStyleInline.length<=i && customStyleInline[i]){ 
					styleString = styleString+"     "+customStyleNames[i]+" : "+customStyleValues[i]+"; \n";
					
					 
				}
				if((n!=null) && customStyleInline.length<=i && customStyleInline[i]){ 
				
				else{ 
					generatedStyleSheet.addStyle(className, customStyleNames, customStyleValues);
				}
			}
		}
		return (styleString.equals(""))?null : styleString;
	}
	
	 
	public void addNav(String[] pagesLink,String[] titles){
		addDivOp(0, 0, "custom-nav", "custom-nav", null); 
		for(int i = 0; i < pagesLink.length;i++){
			this.addLink(titles[i], pagesLink[i], false, 0, 0,null, "nav"+titles[i], null);
		}
		addDivCl();
	}
	
	public void  addHrStyled(int lineSizePercent, int fontSizePx, String domClass, String id, String jsCallout){
		htmlCode.append(" <hr ");
		addInlineStyle( lineSizePercent, fontSizePx, domClass, id, jsCallout);
		htmlCode.append("/>\n");
	}
	
	public void addHR(){
		htmlCode.append("<hr/>\n");
	}
	
	public void addHrMuliple(int x){
		while (x > 0){
			addHR();
			x--;
		} 
	}
	
	public void addCode(String message){
		String code = message.replaceAll("<", "&lt"); 
		code = code.replaceAll(">", "&gt");
		htmlCode.append("\n<pre>\n"+code+"\n</pre>\n"); 
	}
	
	/**
	 * Adds an image to the html code
	 * @param imageName
	 * @param width
	 * @param height
	 * @param docClass
	 * @param jsCallOut
	 */
	public void addImageInternal(String imageName,int width,int height, String docClass, String id , String jsCallOut){ 
		this.addImageExtrenal("./images/" + imageName, width, height, docClass, id, jsCallOut); 
	}
	
	/**
	 * Adds an image to the html code
	 * @param imageName
	 * @param width
	 * @param height
	 * @param docClass
	 * @param jsCallOut
	 */
	public void addImageExtrenal(String imageName, int width,int height, String domClass,String id, String jsCallOut){
		htmlCode.append("<div class='"+((domClass!=null)? domClass+"'" : "'") +" >\n     <img src='"+((imageName!=null)?imageName+"'":"'")+"  class='appImage'  "
				+ (((height>0) || (width > 0))  ? "style=\""+((height>0)?"height:"+height+"%;" : "") + 
						((width>0)?"width:"+width+"%;" : "") +" \" " : "")+" />\n</div>\n"); 
	}
	
	public void addImage(String imagename, String id){
		addImageInternal(imagename,100,0,"center", id,null); 
	}
	
	
	public void addBackgroundContainer(String color){
		htmlCode.append("\n<div style=\"background-color:"+color+";\"> \n");		
	}
	public void closeBackGroundContainer(){
		htmlCode.append("\n</div> <!-- end custom background -->\n");
	}
	

	StringBuilder angularApp = null;
	StringBuilder angularAppJS= null;
	public void creatAngularApp(String appName){
		angularApp= new StringBuilder();
		angularAppJS = new StringBuilder();
		angularApp.append("\n<div class=\"angularApp "+appName+"\" data-ng=\""+appName+"\" id=\""+appName +" \"></div>\n");
		angularAppJS.append("<script>\n" + 
				"	var app = angular.module('"+appName+"', []);\n"+
				"	app.controller('"+appName+"', function($scope) {\n}"+
				"	</script>\n"	);
	}
	
	
	public void addAngularApp(){
		angularApp.append(angularAppJS+"\n</div>"); 
		htmlCode.append("\n"+angularApp+"\n");
		htmlCode.append("\n"+angularAppJS); 
	}
	
	int colPadding=1;
	int colMargin=1;
	int cols=0;
	String hieght="300px";
	public void addColumns( String[] ids, String[] colHtmlCode){  
		
		addColumns( ids,  colHtmlCode, colPadding, colMargin, hieght);
	}
	
	public void addColumns( String[] ids, String[] colHtmlCode, int padding, int margin, String  hieght){  
		String[] names = {"float","position","display","width","padding","margin", "height"};
		int width =  (99/ids.length)-(colPadding+colMargin) ;
		Object[] values ={"left","relative","block", width ,(padding<0)?this.colPadding: padding, (margin<0)?colMargin: margin,(hieght==null ||(hieght.getClass().isInstance(Number.class) && Integer.valueOf(hieght)<0))?this.hieght:hieght}; 
		this.generatedStyleSheet.addStyle("appColumnInternal"+cols, names, values);
		
		String column = "<div class=\"appColumn\" id=\"appColumn"+ cols +"\">\n";
		for(int i =0 ; i <ids.length;i++){ 
			String col = "     <div id=\""+ids[i]+"\"     class='appColumnInternal appColumnInternal"+cols +" appColumnInternal"+ids[i] +"'>\n";
			col+="          <!--------->\n" + colHtmlCode[i]+"\n          <!--------->\n     </div>\n";
			column+=col;
		}
		column+="</div>";
		htmlCode.append(column);
		cols++;
	}
	
	public  String getGeneratedStyleSheet(){
		return this.generatedStyleSheet.getCode();
	}
	
}
