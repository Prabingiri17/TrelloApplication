package com.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.dao.LoginDao;
import com.todo.model.LoginBean;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private LoginDao loginDao;
	
	public void init() {
		// database access object DAO object creation here
		 loginDao = new LoginDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("login/login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		authenticate(request,response);
	}
	
	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		try {
			if(loginDao.validate(loginBean)) {
				HttpSession session = request.getSession();
				session.setAttribute("activeUser",loginBean.getUsername());
				response.sendRedirect("todo/todohome.jsp");
				//RequestDispatcher requestDispatcher =request.getRequestDispatcher("todo/todohome.jsp");
				//requestDispatcher.forward(request, response);
			}
			else {
				RequestDispatcher requestDispatcher =request.getRequestDispatcher("login/login.jsp");
				requestDispatcher.forward(request, response);
				/*
				 * HttpSession session = request.getSession();
				 * response.sendRedirect("login.jsp");
				 */
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
