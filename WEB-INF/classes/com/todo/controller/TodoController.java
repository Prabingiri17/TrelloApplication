package com.todo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TodoDao;
import com.todo.dao.TodoDaoImplementation;
import com.todo.model.Todos;

//Servlet path get to come 
@WebServlet("/")
public class TodoController extends HttpServlet {
	private TodoDao todoDao ;
	
	public void init() {
		todoDao = new TodoDaoImplementation();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getServletPath();
		
		try {
			
			switch(action) {
			
			case "/new":
				showNewForm(request,response);
				
			case "/insert":
				insertTodo(request,response);
				
			case "/list":
				showList(request,response);
				
			case "/edit":
				showEditForm(request,response);
							
			case "/delete":
				deleteTodo(request,response);
			
			default:
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
				requestDispatcher.forward(request, response);
				break;
			
		}}catch(SQLException e) {
			throw new ServletException(e);
		}
		
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("todo/todoform.jsp");
		requestDispatcher.forward(request, response);
		
	}

	private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Todos> list = todoDao.selectAllTodos();
		request.setAttribute("showlist", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("todo/todohome.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	private  void insertTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String title= request.getParameter("title");
		String description = request.getParameter("description");
		boolean status = Boolean.valueOf(request.getParameter("status"));
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		String username = request.getParameter("username");
		
		Todos newTodo = new Todos(title,description,status,targetDate,username);
		todoDao.insertTodo(newTodo);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list");
		requestDispatcher.forward(request, response);
	}
	
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		Long id =Long.parseLong(request.getParameter("id"));
		Todos existingTodo = todoDao.selectTodo(id);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/todo/todoform.jsp");
		todoDao.updateTodo(existingTodo);
		request.setAttribute("todo", existingTodo);
		requestDispatcher.forward(request, response);
		
	}
	
	private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		long id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		boolean status = Boolean.valueOf(request.getParameter("status"));
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		String username = request.getParameter("username");
		Todos updatedTodo= new Todos(id,title,description,status,targetDate,username);
		todoDao.updateTodo(updatedTodo);
		response.sendRedirect("list");
		
	}
	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		todoDao.deleteTodo(id);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list");
		requestDispatcher.forward(request, response);
		
	}
	

}
