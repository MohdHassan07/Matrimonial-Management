package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.userDaoImpl;
import com.module.userDetails;

@WebServlet("/user")
public class userController extends HttpServlet{
	userDaoImpl udao=new userDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		int age = Integer.parseInt(req.getParameter("age"));
		String usern = req.getParameter("username");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String contry = req.getParameter("country");
		String city = req.getParameter("city");
		String number = req.getParameter("mobilenumber");
		userDetails user= new userDetails();
		user.setAge(age);
		user.setUsername(usern);
		user.setEmail(email);
		user.setGender(gender);
		user.setCountry(contry);
		user.setCity(city);
		user.setMobilenumber(number);
		
		int i = udao.save(user);
		if(i>0) {
			out.print("<h1>Added Successfull</h1>");
			
		    RequestDispatcher rd = req.getRequestDispatcher("index.html");
		    rd.include(req, resp);
		}
		else {
			out.print("Not Inserted");
			RequestDispatcher rd = req.getRequestDispatcher("insertData.html");
		    rd.include(req, resp);
		}
		
		
		
		
	}
	
}
