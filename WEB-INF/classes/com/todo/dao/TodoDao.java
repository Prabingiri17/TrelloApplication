package com.todo.dao;
import java.sql.SQLException;
import java.util.List;

import com.todo.model.Todos;

public interface TodoDao {
	
	void insertTodo(Todos todos) throws SQLException ;
	boolean deleteTodo(Long id) throws SQLException;
	boolean updateTodo(Todos todos) throws SQLException ;
	Todos selectTodo(Long id);
	 List<Todos> selectAllTodos();
	


}
