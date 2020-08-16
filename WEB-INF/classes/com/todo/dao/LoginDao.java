package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todo.model.LoginBean;
import com.todo.utils.JDBCutils;

public class LoginDao {
	
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		
		boolean status =false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection connection = JDBCutils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? and password = ? ");
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			status =resultSet.next();
		} catch (SQLException e) {
			JDBCutils.printSQLException(e);
		}
		
		return status;
	}
	

}
