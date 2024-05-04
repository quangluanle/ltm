<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>
<body class="goto-here">
	<jsp:include page="top.jsp"></jsp:include>

	<jsp:include page="nav.jsp"></jsp:include>

	<div class="hero-wrap hero-bread"
		style="background-image: url('images/bg_1.jpg');">
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="home">Home</a></span> <span>Cart</span>
					</p>
					<h1 class="mb-0 bread">My Cart</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>Product name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${cartEmpty != null}">
									<p class="text-center">${cartEmpty}</p>
								</c:if>
								<c:forEach var="item" items="${cart }">
									<tr class="text-center item">
										<form action="cart-action" method="get">
											<td class="image-prod">
												<div class="img"
													style="background-image:url(images/${item.value.product.image});"></div>
											</td>
	
											<td class="product-name">
												<h3>
													<a href="product-detail?id=${item.value.product.product_id}">${item.value.product.name}</a>
												</h3>
											</td>
	
											<td class="price">$${item.value.product.price }</td>
	
											<td class="quantity">
												<div class="input-group mb-3">
													<input type="number" name="quantity" id="quantity"
														class="quantity form-control input-number ml-2 mr-2"
														value="${item.value.quantity}" min="1" max="100">
													
												</div>
											</td>
	
											<td class="total">$${item.value.product.price * item.value.quantity}</td>
											<td class="product-remove">
													<a style="cursor: pointer;" class="mr-2" data-toggle="modal" data-target="#exampleModal">
													  	<span class="ion-ios-close"></span>
													</a>
														
													<a style="cursor: pointer;" onclick="setAction('update')"><span class="ion-ios-checkmark"></span></a>
											</td>
											 <input type="hidden" name="action" id="action" value="" />
											 <input type="submit" style="display:none"/>
											 <input type="hidden" name="id" value="${item.value.product.product_id}"/>
										</form>
									</tr>
									<!-- END TR-->
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row justify-content-end">
				<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>Coupon Code</h3>
						<p>Enter your coupon code if you have one</p>
						<form action="#" class="info">
							<div class="form-group">
								<label for="">Coupon code</label> <input type="text"
									class="form-control text-left px-3" placeholder="">
							</div>
						</form>
					</div>
					<p>
						<a href="checkout.html" class="btn btn-primary py-3 px-4">Apply
							Coupon</a>
					</p>
				</div>
				<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>Estimate shipping and tax</h3>
						<p>Enter your destination to get a shipping estimate</p>
						<form action="#" class="info">
							<div class="form-group">
								<label for="">Country</label> <input type="text"
									class="form-control text-left px-3" placeholder="">
							</div>
							<div class="form-group">
								<label for="country">State/Province</label> <input type="text"
									class="form-control text-left px-3" placeholder="">
							</div>
							<div class="form-group">
								<label for="country">Zip/Postal Code</label> <input type="text"
									class="form-control text-left px-3" placeholder="">
							</div>
						</form>
					</div>
					<p>
						<a href="checkout.html" class="btn btn-primary py-3 px-4">Estimate</a>
					</p>
				</div>
				<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>Cart Totals</h3>
						<p class="d-flex">
							<span>Subtotal</span> <span>$${totalPrice }</span>
						</p>
						<p class="d-flex">
							<span>Delivery</span> <span>$0.00</span>
						</p>
						<p class="d-flex">
							<span>Discount</span> <span>$3.00</span>
						</p>
						<hr>
						<p class="d-flex total-price">
							<span>Total</span> <span>$${totalPrice - 3}</span>
						</p>
					</div>
					<p>
						<a href="checkout.html" class="btn btn-primary py-3 px-4">Proceed
							to Checkout</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Warning</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Are you sure you want to remove the item from the cart?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	        <button type="button" onclick="setAction('delete')" class="btn btn-primary">Remove</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>

	<script>
		function setAction(action) {
		    document.getElementById('action').value = action;
		    document.forms[1].submit();
		};
	</script>

</body>

</html>