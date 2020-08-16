<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: teal">
		<div>
			<a href="https://www.prabingiri.info.np" class="navbar-brand"
				style="font-family: serif"> TRELLO</a>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%=request.getContextPath() %>/unicode"
				class="nav-link">NepaliUnicode</a>
			<li><a href="<%= request.getContextPath() %>/login"
				class="nav-link">Login</a></li>
			<li><a href="<%= request.getContextPath() %>/register"
				class="nav-link">SignUp</a></li>
		</ul>
	</nav>
</header>