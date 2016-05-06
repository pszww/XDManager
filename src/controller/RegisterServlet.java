package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUserDao;


@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
     
        String password = request.getParameter("password");


        try {
        		if(IUserDao.exist(name)){
        		response.setStatus(404);
        		}
        		else{
        		IUserDao.insert(name, password);
        		
        		response.setStatus(200);
        		}
	
        	} catch (Exception e) {

	e.printStackTrace();
}

	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
