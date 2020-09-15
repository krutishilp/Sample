<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style type="text/css">
.container {
	width: 35%;
	align-content: center;
}
</style>

</head>
<body>
	<div class="container">
		<div class="">
			<div class="">
				<form action="login" method="post">
					<h2 class="text-center">Login</h2>
					<div class="form-group">
						<label for="username">UserName:</label> <input type="text"
							class="form-control" name="userName" id="username" placeholder="Please Enter your Username">
					</div>
					<div class="form-group">
						<label for="pass">Password:</label> <input type="password"
							class="form-control" name="password" id="pass" placeholder="Please Enter your Password" >
					</div>
					<div class="text-center">
						<input type="submit" class="btn btn-primary" value="Login">
						<a class="text-primary" href="register.html">Not yet Registerd??</a>
					</div>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>