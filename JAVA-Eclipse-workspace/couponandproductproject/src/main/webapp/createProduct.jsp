<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Coupon</title>
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

		<form action="product" method="post">
			<h2 class="text-center">Product Coupon</h2>

			<div class="form-group">
				<label for="productname">Product Name</label> <input type="text"
					class="form-control" name="productName" id="productname" required
					placeholder="Please Enter your Product Name">
			</div>

			<div class="form-group">
				<label for="pdescription">Product Description</label> <input type="text"
					class="form-control" name="productDescription" id="pdescription" required
					placeholder="Please Enter Product Description">
			</div>

			<div class="form-group">
				<label for="productprice">Product Price</label> <input type="number"
					class="form-control" name="productPrice" id="productprice" required
					placeholder="Please Enter Product Price">
			</div>
			
			<div class="form-group">
				<label for="couponcode">Coupon Code</label> <input type="text"
					class="form-control" name="couponCode" id="couponcode" required
					placeholder="Please Enter Coupon Code">
			</div>
			
			<div class="text-center">
				<input type="submit" class="btn btn-primary"
					value="Create Product"> 
			</div>
		</form>
	</div>

</body>
</html>