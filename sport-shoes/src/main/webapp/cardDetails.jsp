<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="components/common_css_js.jsp"%>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/3.0.0/jquery.payment.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function paymentController() {
		let cart = JSON.parse(localStorage.getItem('cart'));
		let cartdata = "";
		let count = 1 ;
		for (const item of cart) {
			cartdata = cartdata + ("id"+count+"="+item.productId+"&quantity"+count+"="+item.productQuantity+"&");
		    count++;
		}
		count = count - 1 ;
		swal("order confirmed !", "buy more !", "success").then(function() {
			window.location.href ="paymentServlet?count="+count+"&"+cartdata;
		});

	}
</script>
<title>sportyshoes.com : paynow</title>
<style>
.padding {
	padding: 5rem !important
}

.form-control:focus {
	box-shadow: 10px 0px 0px 0px #ffffff !important;
	border-color: #4ca746
}
</style>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="padding">
		<div class="row">
			<div class="container-fluid d-flex justify-content-center">
				<div class="col-sm-8 col-md-6">
					<div class="card">
						<div class="card-header">
							<div class="row">
								<div class="col-md-6">
									<span>CREDIT/DEBIT CARD PAYMENT</span>
								</div>
								<div class="col-md-6 text-right" style="margin-top: -5px;">
									<img src="https://img.icons8.com/color/36/000000/visa.png">
									<img
										src="https://img.icons8.com/color/36/000000/mastercard.png">
									<img src="https://img.icons8.com/color/36/000000/amex.png">
								</div>
							</div>
						</div>
						<div class="card-body" style="height: 350px">
							<div class="form-group">
								<label for="cc-number" class="control-label">CARD NUMBER</label>
								<input id="cc-number" type="tel"
									class="input-lg form-control cc-number"
									autocomplete="cc-number"
									placeholder="???????????? ???????????? ???????????? ????????????"
									required>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="cc-exp" class="control-label">CARD EXPIRY</label>
										<input id="cc-exp" type="tel"
											class="input-lg form-control cc-exp" autocomplete="cc-exp"
											placeholder="?????? / ??????" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="cc-cvc" class="control-label">CARD CVC</label> <input
											id="cc-cvc" type="tel" class="input-lg form-control cc-cvc"
											autocomplete="off" placeholder="????????????" required>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="numeric" class="control-label">CARD HOLDER
									NAME</label> <input type="text" class="input-lg form-control">
							</div>
							<div class="form-group">
								<input value="MAKE PAYMENT" type="button"
									class="btn btn-success btn-lg form-control"
									onclick="paymentController()" style="font-size: .8rem;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="components/common_modals.jsp"%>
</body>
</html>