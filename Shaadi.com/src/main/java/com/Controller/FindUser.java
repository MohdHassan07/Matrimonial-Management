package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.userDaoImpl;
import com.module.userDetails;

/**
 * Servlet implementation class FindUser
 */
@WebServlet("/FindUser")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int id = Integer.parseInt(req.getParameter("id"));
		
		userDaoImpl ud =new userDaoImpl();
		userDetails user = ud.userFind(id);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print(user);
		
		
	}

}
