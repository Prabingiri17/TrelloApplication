package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.todo.model.User;
import com.todo.utils.JDBCutils;

public class UserDao {
	public int registerEmployee(User user) {
		 //String query="insert into users values (?,?,?,?)";
		String INSERT_INTO_SQL ="insert into users" +"(first_name, last_name, username, password) values"+"(?,?,?,?)";
		int result =0;
		try(Connection connection = JDBCutils.getConnection();
				
				
				PreparedStatement preparedStatement  = connection.prepareStatement(INSERT_INTO_SQL)){
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getPassword());
			System.out.println(preparedStatement);
			
			result =preparedStatement.executeUpdate();

		}
		catch(SQLException e) {
			//process sql exception
			JDBCutils.printSQLException(e);
		}
		return result;
	}
}
