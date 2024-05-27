package it.unisa.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UrlControl",
urlPatterns={"./*"})
public class UrlControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UrlControl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String redirectedPage = request.getParameter("page");
		System.out.println(redirectedPage);
		
		if(redirectedPage != null) {
			
			String substring1 = redirectedPage.substring(0, 8);
			String substring2 = redirectedPage.substring(0, 7);

			
			if(substring1.equals("META-INF") || substring2.equals("WEB-INF")) {
				
				response.sendRedirect("/Home.jsp");
			}
		} else {
			 request.getRequestDispatcher("../Home.jsp")
             .forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
