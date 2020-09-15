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
					placeholder="Please Enter Coupen Code">
			</div>
			<div class="form-group">
				<input type="hidden"
					class="form-control" name="action" value="findCoupon" required>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary"
					value="Find Coupon"> 
			</div>
		</form>
	</div>

</body>
</html>