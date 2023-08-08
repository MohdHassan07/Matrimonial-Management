package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.module.userDetails;
import com.util.ConnectionUtil;

public class userDaoImpl implements userDao {

	@Override
	public int save(userDetails details) {
		int i = 0;
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into user_detail(age,username,email,gender,country,city,mobilenumber) values(?,?,?,?,?,?,?)");
			ps.setInt(1, details.getAge());
			ps.setString(2, details.getUsername());
			ps.setString(3, details.getEmail());
			ps.setString(6, details.getGender());
			ps.setString(4, details.getCountry());
			ps.setString(5, details.getCity());
			ps.setString(7, details.getMobilenumber());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public userDetails userFind(int id) {
		Connection con = ConnectionUtil.getConnection();
		userDetails ds = new userDetails();
		ds.setId(id);

		try {
			PreparedStatement ps = con.prepareStatement("select * from user_detail where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ds.setAge(rs.getInt(2));
				ds.setUsername(rs.getString(3));
				ds.setEmail(rs.getString(4));
				ds.setGender(rs.getString(5));
				ds.setCountry(rs.getString(6));
				ds.setCity(rs.getString(7));
				ds.setMobilenumber(rs.getString(8));
			}
			System.out.println(ds);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ds;
	}

	public void updateUser(int id, String name) {
		Connection con = ConnectionUtil.getConnection();

		try {
			PreparedStatement pd = con.prepareStatement("update user_detail set username=? where id=?");
			pd.setString(1, name);
			pd.setInt(2, id);

			pd.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void deleteUser(int id) {
		Connection con = ConnectionUtil.getConnection();
		
		try {
			PreparedStatement pd = con.prepareStatement("delete from user_detail where id=?");
			pd.setInt(1, id);
			pd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
