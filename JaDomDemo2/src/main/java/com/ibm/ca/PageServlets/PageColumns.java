package com.ibm.ca.PageServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ca.CodeBuilders.HtmlBuilder;
import com.ibm.ca.CodeBuilders.NavBuilder;
import com.ibm.ca.CodeBuilders.TableBuilder;
import com.ibm.ca.FileReader.FileReader; 

/**
 * Servlet implementation class Index
 */
@WebServlet("/Pages")
public class PageColumns extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageColumns() {
        super(); 
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 
		HtmlBuilder html = new HtmlBuilder(true);  
		html.addBackgroundContainer("#730673");
		html.addHrStyled(0, 0, "style-one", null, null); 
		html.addHeader(1, "Page Columns", "center", null, null);
		html.addHeader(3, "Dynamic Column Creation", "center", null, null);
		html.addHrStyled(0, 0, "style-one", null, null); 
		html.closeBackGroundContainer();
		html.addBrMulti(2);
		html.addParagraph("EasyJSP uses dynmically created columns with resoinsive widths based on y our input. Column width is processed on the java backend and inserted via style sheet into the html code. For more control over the column widths and responsivness, several pre defined styles and media rules are available to assist in override generated css.  There are also several media rules in place to aid in responsive design for various device widths. These media rules can be edited more to reflect the needs of your current situation.",0,0,null,null,null );
		html.addParagraph("When creating columns we must first create two string arrays. One with the ids of the columns, and one witht he corresponding html code for the column. You can use the HtmlCodeBuilder to create the code for the column, or you can just type it in as text.  The number of columns that will be generated correspionds to the number of ids you will feed into the column creation methods  If you dont have enough htmlcode to fill the columns you will get an array index error.", 0,0,null,null,null);
		html.addHrStyled(0, 0, "style-one", null, null);	
		html.addParagraph("Below is a basic example of two columns dynamically created.", 0, 0, null, null, null);
		html.addBr();
		String[] ids={"id_col1","id_col2"};
		String[] htmlCode ={"<h3>Column 1</h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer rhoncus enim volutpat est aliquet malesuada. Fusce id dictum nisi, ut suscipit erat. Cras sed nulla lectus. Donec maximus laoreet ex a tincidunt. Sed in justo pharetra, ultricies mi sit amet, aliquam massa. Aliquam erat volutpat. Mauris a posuere nibh, non tristique augue. Morbi ullamcorper, lacus eu varius sollicitudin, ligula magna porttitor libero, id consequat sem arcu at ipsum. Donec suscipit venenatis ante.","<h3>Column 2</h3>am eu dignissim arcu, nec fermentum ex. Duis sit amet aliquet arcu. Quisque suscipit et neque non suscipit. Nullam eleifend euismod nisl, a feugiat nibh congue ut. Etiam ut semper nisl, nec iaculis arcu. Donec semper feugiat ornare. In dapibus condimentum rutrum. Aliquam ullamcorper ipsum ut sem accumsan, nec posuere turpis ornare. Nam suscipit libero in porttitor ultricies. "};	 	
		html.addColumns(ids, htmlCode);
		html.addCode("String[] ids={\"id_col1\",\"id_col2\"};\n"+
		"String[] htmlCode ={\n"+
		"     \"<h3>Column 1</h3>\"+\n"+
		"     \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Inadger\"+\n"+
		"     \"... d consequat sem arcu at ipsum. Donec suscipit venenatis ante.\", \n"+
		"     \"<h3>Column 2</h3>am eu dignissim arcu, nec fermentum ex. Duis sit amet\"+\n"+
		"     \" ...... posuere turpis ornare. Nam suscipit libero in porttitor ultricies. \"};\n"+
		"html.addColumns(ids, htmlCode);");
			html.addHrStyled(0, 0, "style-one", null, null);	

			
			html.addParagraph("Below is a basic example of six columns dynamically created.", 0, 0, null, null, null);
		String[] ids2={"id_col1","id_col2","id_col3","id_col4","id_col5","id_col6"};
		String[] htmlCode2 ={"<h3>Column 1</h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit.  Fusce id dictum nisi, ut suscipit erat. Cras sed nulla lectus. Donec maximus laoreet ex a tincidunt. Sed in justo pharetra, ultricies mi sit amet, aliquam massa. Aliquam erat volutpat. Mauris a posuere nibh, non tristique augue. Morbi ullamcorper, lacus eu varius sollicitudin, ligula magna porttitor libero, id consequat sem arcu at ipsum. Donec suscipit venenatis ante.","<h3>Column 2</h3>am eu dignissim arcu, nec fermentum ex. Duis sit amet aliquet arcu. Quisque suscipit et neque non suscipit. Nullam eleifend euismod nisl, a feugiat nibh congue ut. Etiam ut semper nisl, nec iaculis arcu. Donec semper feugiat ornare. In dapibus condimentum rutrum. Aliquam ullamcorper ipsum ut sem accumsan, nec posuere turpis ornare. Nam suscipit libero in porttitor ultricies.", "<h3>Column 2</h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer rhoncus enim volutpat est aliquet malesuada. Fusce id dictum nisi, ut suscipit erat. Cras sed nulla lectus. Donec maximus laoreet ex a tincidunt. Sed in justo pharetra, ultricies mi sit amet, aliquam massa. Aliquam erat volutpat. Mauris a posuere nibh, non tristique augue. Morbi ullamcorper, lacus eu varius sollicitudin, ligula magna porttitor libero, id consequat sem arcu at ipsum. Donec suscipit venenatis ante.","<h3>Column 4</h3>am eu dignissim arcu, nec fermentum ex. Duis sit amet aliquet arcu. Quisque suscipit et neque non suscipit. Nullam eleifend euismod nisl, a feugiat nibh congue ut. Etiam ut semper nisl, nec iaculis arcu. Donec semper feugiat ornare. In dapibus condimentum rutrum. Aliquam ullamcorper ipsum ut sem accumsan, nec posuere turpis ornare. Nam suscipit libero in porttitor ultricies. ","<h3>Column 5</h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer rhoncus enim volutpat est aliquet malesuada. Fusce id dictum nisi, ut suscipit erat. Cras sed nulla lectus. Donec maximus laoreet ex a tincidunt. Sed in justo pharetra, ultricies mi sit amet, aliquam massa. Aliquam erat volutpat. Mauris a posuere nibh, non tristique augue. Morbi ullamcorper, lacus eu varius sollicitudin, ligula magna porttitor libero, id consequat sem arcu at ipsum. Donec suscipit venenatis ante.","<h3>Column 6</h3>am eu dignissim arcu, nec fermentum ex. Duis sit amet aliquet arcu. Quisque suscipit et neque non suscipit. Nullam eleifend euismod nisl, a feugiat nibh congue ut. Etiam ut semper nisl, nec iaculis arcu. Donec semper feugiat ornare. In dapibus condimentum rutrum. Aliquam ullamcorper ipsum ut sem accumsan, nec posuere turpis ornare. Nam suscipit libero in porttitor ultricies. "};	 		 		 	
		html.addColumns(ids2, htmlCode2,1,1,"500px");
	 	html.addCode(
	 			"String[] ids2={\n"+ 
	 			"     \"id_col1\",\"id_col2\",\"id_col3\",\"id_col4\",\"id_col5\",\"id_col6\"};\n"+
		"String[] htmlCode2 ={\n"+
	 			"     \"<h3>Column 1</h3>Lorem i...te.\",+\n" +
	 			"     \"<h3>Column 2</h3>am eu ...  ultricies.\", +\n" +
	 			"     \"<h3>Column 3</h3>Lorem ipsum ....	 ante.\",+\n" +
	 			"     \"<h3>Column 4</h3>am eu .... ultricies. \", + \n" +
	 			"     \"<h3>Column 5</h3>Lorem ipsum .... ante.\",+\n" +
	 			"     \"<h3>Column 6</h3>am eu ... ultricies. \"};\n"+	 		 		 	
	 			"html.addColumns(ids2, htmlCode2);\n"); 
		html.addHeader(3, "Adjusting column heights");
		String[] headers = {"col1","col2","col3","col4","col5"};

		html.creatAngularApp("angapp");
		html.addAngularApp(); 
		request.getSession().setAttribute("generatedStyleSheet", html.getGeneratedStyleSheet());
		request.getSession().setAttribute("HTMLbody",html.getCode());
		request.getRequestDispatcher("/TemplateTest.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
