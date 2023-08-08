package com.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {
	public static Connection getConnection() {
		Connection con=null;
		
		   
		try {
			InitialContext context = new InitialContext();
			System.out.println(context); 
			DataSource ds = (DataSource)context.lookup("java:comp/env/shaadi");
			con=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // context.lookup("java:comp/env/my"); System.out.println(ds);
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(con);
		return con;
		
	}
	
}
