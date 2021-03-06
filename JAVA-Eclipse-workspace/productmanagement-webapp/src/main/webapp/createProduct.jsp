<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place an Product</title>
<!-- Latest compiled and minified CSS -->
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
<body class="jumbotron">
	<div class="container">
		<div>
			<h2>Create Product</h2>
		</div>
		<form action="product" method="post">
			<div class="form-group">
				<label for="productname">Product Name</label> <input type="text"
					class="form-control" id="productname" placeholder="Please Enter Product Name"
					name="productName" required="required">
			</div>

			<div class="form-group">
				<label for="productcost">Product Cost</label> <input type="number"
					class="form-control" id="productcost" placeholder="Please Enter Product Cost"
					name="productCost" required="required">
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" name="createProduct" required="required">
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Create Product">
			</div>

		</form>
	</div>
</body>
</html>