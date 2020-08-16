package com.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.dao.UserDao;
import com.todo.model.User;

@WebServlet("/register")
public class UserController extends HttpServlet {
		private UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("register/register.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register(request,response);
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName =request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		String userName =request.getParameter("username");
		String password = request.getParameter("password");
		User user =new User();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		
		try {
			
			int result =userDao.registerEmployee(user);
				if(result==1) {
					request.setAttribute("NOTIFICATION","User Registered Successfully!");
				}else {
					request.setAttribute("NOTIFICATION", "Please Provide valid Credentials");
				}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		request.getRequestDispatcher("register/register.jsp").forward(request, response);	
		
	}
	

}
