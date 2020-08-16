<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Todo</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: teal">
			<div>
				<a href="https://www.prabingiri.info.np" class="navbar-brand"
					style="font-family: serif"> TRELLO</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> My Todos</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:if test="${todo !=null }">
				<caption><c:if test="${todo!=null }"> Edit Trello</c:if></caption>
					
					<form action="update" method="post">
								<c:if test="${todo !=null }">
					<input type="hidden" name="id" value="<c:out value='${todo.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Todo Title</label> <input type="text"
						value="<c:out value='${todo.title}'/>" class="form-control"
						name="title" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label>Todo Decription</label> <input type="text"
						value="<c:out value='${todo.description}'/>" class="form-control"
						name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>Todo Status</label> <select class="form-control"
						name="status">
						<option value="In Progress">In Progress</option>
						<option value="Completed">Completed</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Todo End Date</label> <input type="date"
						value="<c:out value='${todo.target_date}'/>" class="form-control"
						name="targetDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
				</c:if>

				<c:if test="${todo ==null }">
					<form action="insert" method="post">
					<caption><h2> <c:if test="${todo==null }"> Trello</c:if></h2></caption>
					<fieldset class="form-group">
					<label>Todo Title</label> <input type="text"
						value="<c:out value='${todo.title}'/>" class="form-control"
						name="title" required="required" />
				</fieldset>

				<fieldset class="form-group">
					<label>Todo Decription</label> <input type="text"
						value="<c:out value='${todo.description}'/>" class="form-control"
						name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>Todo Status</label> <select class="form-control"
						name="status">
						<option value="In Progress">In Progress</option>
						<option value="Completed">Completed</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Todo End Date</label> <input type="date"
						value="<c:out value='${todo.target_date}'/>" class="form-control"
						name="targetDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
					
				</c:if>
	
			</div>
		</div>
	</div>

</body>
</html>