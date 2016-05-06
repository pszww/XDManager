package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUserDao;


@WebServlet(asyncSupported = true, urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public LoginServlet() {
        super();

    }
   
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 	
		        String name = request.getParameter("name");
		                   //获取用户填写的登录密码
		        String password = request.getParameter("password");
		  
		        
		          try {
					if(IUserDao.find(name, password)){
						response.setStatus(200);
					}
					else{
						response.setStatus(404);
					}
					
				} catch (Exception e) {
			
					e.printStackTrace();
				}
				
//		    	try {
//		          PrintWriter out = response.getWriter();
//			
//					IUserDao.query("", name, password, "");
//				} catch (Exception e) {
//					
//					e.printStackTrace();
//			}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String name = request.getParameter("name");
           //获取用户填写的登录密码
		   	String password = request.getParameter("password");
	
	}

}
