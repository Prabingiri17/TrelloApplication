<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">

		<h2>Register</h2>
		<div class="col-md-6 col-md-offset-3">
			<div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
			</div>

			<form action="<%=request.getContextPath()%>/register" method="post">

				<div class="form-group">
					<label for="uname">First Name:</label> <input type="text"
						class="form-control" id="uname" name="firstName" required>
				</div>

				<div class="form-group">
					<label for="uname">Last Name:</label> <input type="text"
						class="form-control" id="uname" name="lastName" required>
				</div>

				<div class="form-group">
					<label for="uname">User Name:</label> <input type="text"
						class="form-control" id="username" name="username" required>
				</div>

				<div class="form-group">
					<label for="uname">Password:</label> <input type="password"
						class="form-control" id="password" name="password" required>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>

			</form>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>