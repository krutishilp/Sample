<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search an Product</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style type="text/css">
.container {
	width: 40%;
	align-items: center;
}
</style>
</head>
<body  class="jumbotron">
		<div class="container">
		<div>
		<h2>Search Product</h2>
		</div>
			<form action="getProduct" method="post">
				<div class="form-group">
					<label for="productid">Product Id</label> <input type="text"
						class="form-control" id="productid" placeholder="Please Enter Product Id" name="productId" required="required">
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" 
						placeholder=""  value="Search">
				</div>

			</form>
		</div>
</body>
</html>