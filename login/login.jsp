<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome LazyAss</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<br>


		<h1>Login Form</h1>
		<br>
		<form action="<%=request.getContextPath()%>/login" method="post">

			<div class="form-group">
				<label for="uname">User Name:</label> <input type="text"
					class="form-control col-7" id="username" placeholder="username"
					name="username" required>
			</div>

			<div class="form-group">
				<label for="uname">Password:</label> <input type="password"
					class="form-control col-7" id="password" placeholder="password"
					name="password" required>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>