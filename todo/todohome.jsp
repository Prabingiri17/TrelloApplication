<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage | LazyAss</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<style>
* {
	overflow-x: hidden;
	overflow-y
	=auto;
}
</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>

	<%
		if (session.getAttribute("activeUser") == null) {
		response.sendRedirect("../login/login.jsp");
	}
	%>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: teal">
			<div>
				<a href="https://www.prabingiri.info.np" class="navbar-brand"
					style="font-family: serif"> TRELLO</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">My Todos</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center" style="line-height: 1.6">List of Todos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Todo</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Title</th>
						<th scope="col">Description</th>
						<th scope="col">Status</th>
						<th scope="col">Target Date</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todo" items='${showlist}'>
						<tr>
							<td><c:out value="${todo.title}" /></td>
							<td><c:out value="${todo.description}" /></td>
							<td><c:out value="${todo.status}" /></td>
							<td><c:out value="${todo.target_date}" /></td>

							<td><a href="edit?id=<c:out value='${todo.id }'/>">Edit</a>&nbsp;&nbsp;<a
								href="delete?id=<c:out value='${todo.id }'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>