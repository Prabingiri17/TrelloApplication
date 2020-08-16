package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todos;
import com.todo.utils.JDBCutils;

public class TodoDaoImplementation implements TodoDao {

	private static final String INSERT_TODOS_SQL="insert into todos"+"(title,description,status,target_date,username) values"+"(?,?,?,?,?)";
	private static final String UPDATE_TODO ="update todos set title=?,description=?,status=?,target_date=?,username=? where id=?";
	private static final String SELECT_TODO ="select title,description,status,target_date,username from todos where id=?";
	private static final String SELECTALLTODOS ="select * from todos";
	private static final String DELETE_TODO="delete from todos where id=?";
	
	public TodoDaoImplementation() {
		
	}

	@Override
	public void insertTodo(Todos todos) throws SQLException {

		Connection connection =JDBCutils.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL);
			preparedStatement.setString(1, todos.getTitle());
			preparedStatement.setString(2, todos.getDescription());
			preparedStatement.setBoolean(3, todos.isStatus());
			preparedStatement.setDate(4, JDBCutils.getSQLDate(todos.getTarget_date()));
			preparedStatement.setString(5, todos.getUsername());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			JDBCutils.printSQLException(e);
		}
	}

	@Override
	public boolean updateTodo(Todos todos) throws SQLException{
		boolean result =false;
		Connection connection =JDBCutils.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_TODO);
			preparedStatement.setString(1, todos.getTitle());
			preparedStatement.setString(2, todos.getDescription());
			preparedStatement.setBoolean(3, todos.isStatus());
			preparedStatement.setDate(4, JDBCutils.getSQLDate(todos.getTarget_date()));
			preparedStatement.setString(5, todos.getUsername());
			preparedStatement.setLong(6, todos.getId());
			result = preparedStatement.executeUpdate()>0;
			return result;
		}
		catch(Exception e) {

		}
		return result;
	}

	@Override
	public Todos selectTodo(Long todoId){
		Todos todos =null;

		try(Connection connection = JDBCutils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO);){

			preparedStatement.setLong(1, todoId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				Long id = rs.getLong("1");
				String title =rs.getString(2);
				String description = rs.getString(3);
				boolean status =rs.getBoolean(4);
				LocalDate targetDate = rs.getDate(5).toLocalDate();
				String username = rs.getString(6);

				todos = new Todos( id,title,description,status,targetDate,username);

			}
		}catch(SQLException e) {
			JDBCutils.printSQLException(e);
		}
		return todos;
	}

	@Override
	public List<Todos> selectAllTodos() {
		List<Todos> todos = new ArrayList<>();

		Connection connection = null;
		try {	
			connection =JDBCutils.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SELECTALLTODOS);
			ResultSet rs = prepareStatement.executeQuery();

			while(rs.next()) {
				Long id = rs.getLong(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				boolean status = rs.getBoolean(4);
				LocalDate targetDate = rs.getDate(5).toLocalDate();
				String username = rs.getString(6);
				todos.add(new Todos(id,title,description,status,targetDate,username));				
			}			
		}catch(SQLException e) {
			JDBCutils.printSQLException(e);
		}				
		return todos;
	}

	@Override
	public boolean deleteTodo(Long id)throws SQLException {
		boolean result =false;
		Connection connection = JDBCutils.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TODO);
			preparedStatement.setLong(1, id);

			result =preparedStatement.executeUpdate()>0;
			return result;

		}catch(SQLException e) {
			JDBCutils.printSQLException(e);
		}

		return result;
	}


}
