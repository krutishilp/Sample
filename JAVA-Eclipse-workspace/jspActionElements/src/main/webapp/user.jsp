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
				<form action="userInfo.jsp" method="post">
					<h2 class="text-center">Login</h2>
					<div class="form-group">
						<label for="username">Name:</label> <input type="text"
							class="form-control" name="name" id="username" placeholder="Please Enter your Name">
					</div>
					
					<div class="form-group">
						<label for="age">Age:</label> <input type="number"
							class="form-control" name="age" id="age" placeholder="Please Enter your Age">
					</div>
					
					<div>
						<label for="gend">Gender:</label> <input type="radio"
							 name="gender" id="gend" value="Male">Male
							<input type="radio"
							 name="gender" id="gend" value="Female">Female
					</div>
					
					<div class="text-center">
						<input type="submit" class="btn btn-primary" value="Click Me">
						<!-- <a class="text-primary" href="register.html">Not yet Registerd??</a> -->
					</div>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>