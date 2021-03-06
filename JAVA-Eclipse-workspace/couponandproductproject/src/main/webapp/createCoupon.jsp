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

		<form action="coupon" method="post">
			<h2 class="text-center">Create Coupon</h2>

			<div class="form-group">
				<label for="couponname">Coupon Name</label> <input type="text"
					class="form-control" name="couponName" id="couponname" required
					placeholder="Please Enter Coupon Code">
			</div>

			<!-- <div class="form-group">
				<label for="cdescription">Coupon Description</label> <input type="text"
					class="form-control" name="couponDescription" id="cdescription" required
					placeholder="Please Enter your Last Name">
			</div> -->

			<div class="form-group">
				<label for="coupondiscount">Coupon Discount</label> <input type="number"
					class="form-control" name="couponDiscount" id="coupondiscount" required
					placeholder="Please Enter Coupon Discount">
			</div>

			<div class="form-group">
				<label for="couponEXPDate">Coupon Expire Date</label> <input type="date"
					class="form-control" name="couponExpiryDate" id="couponEXPDate" required>
			</div>
			<div class="form-group">
				<input type="hidden"
					class="form-control" name="action" value="createCoupon" required>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary"
					value="Create Coupon"> 
			</div>
		</form>
	</div>

</body>
</html>