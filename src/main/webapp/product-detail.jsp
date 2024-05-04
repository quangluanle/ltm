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
						<span class="mr-2"><a href="index.html">Home</a></span> <span
							class="mr-2"><a href="index.html">Product</a></span> <span>Product
							Single</span>
					</p>
					<h1 class="mb-0 bread">Product Detail</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section">
		<div class="container">
			<c:if test="${success != null}">
				<div class="text-center alert alert-success">
					<p>${success }</p>
				</div>
			</c:if>
			<form class="row" action="add-to-cart" method="get">
				<input type="hidden" value="${product.product_id}" name="id">
				<div class="col-lg-6 mb-5 ftco-animate">
					<a href="images/${product.image}" class="image-popup"><img
						src="images/${product.image}" class="img-fluid"
						alt="Colorlib Template"></a>
				</div>
				<div class="col-lg-6 product-details pl-md-5 ftco-animate">
					<h3>${product.name}</h3>
					<div class="rating d-flex">
						<p class="text-left mr-4">
							<a href="#" class="mr-2">5.0</a> <a href="#"><span
								class="ion-ios-star-outline"></span></a> <a href="#"><span
								class="ion-ios-star-outline"></span></a> <a href="#"><span
								class="ion-ios-star-outline"></span></a> <a href="#"><span
								class="ion-ios-star-outline"></span></a> <a href="#"><span
								class="ion-ios-star-outline"></span></a>
						</p>
						<p class="text-left mr-4">
							<a href="#" class="mr-2" style="color: #000;">100 <span
								style="color: #bbb;">Rating</span></a>
						</p>
						<p class="text-left mr-4">
							<a href="#" class="mr-2" style="color: #000;">500 <span
								style="color: #bbb;">Sold</span></a>
						</p>
						<p class="text-left">
							<a href="add-to-wishlist?id=${product.product_id}" onclick="changeHeart()" >
							<span class="icon-heart heart <c:if test='${product.wish == true}'>text-red</c:if>"></span></a>
						</p>
					</div>
					<p class="price">
						<span>$${product.price }</span>
					</p>
					<p>${product.description }</p>
					<div class="row mt-4">
						<div class="w-100"></div>
						<div class="input-group col-md-6 d-flex mb-3">
							<span class="input-group-btn mr-2">
								<button type="button" class="quantity-left-minus btn"
									data-type="minus" data-field="">
									<i class="ion-ios-remove"></i>
								</button>
							</span> 
							<input type="number" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
							<span class="input-group-btn ml-2">
								<button type="button" class="quantity-right-plus btn"
									data-type="plus" data-field="">
									<i class="ion-ios-add"></i>
								</button>
							</span>
						</div>
						<div class="w-100"></div>
						<div class="col-md-12">
							<p style="color: #000;">600 kg available</p>
						</div>
					</div>
					<p>
						<input type="submit" class="btn btn-black py-3 px-5" value="Add to Cart"/>
					</p>
				</div>
			</form>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-3 pb-3">
				<div class="col-md-12 heading-section text-center ftco-animate">
					<span class="subheading">Products</span>
					<h2 class="mb-4">Related Products</h2>
					<p>Far far away, behind the word mountains, far from the
						countries Vokalia and Consonantia</p>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<c:forEach items="${relatedProducts}" var="o">
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="product">
							<a href="product-detail?id=${o.product_id}" class="img-prod"><img class="img-fluid"
								src="images/${o.image }" alt="Colorlib Template"> <span
								class="status">30%</span>
								<div class="overlay"></div> </a>
							<div class="text py-3 pb-4 px-3 text-center">
								<h3>
									<a href="product-detail?id=${o.product_id}">${o.name }</a>
								</h3>
								<div class="d-flex">
									<div class="pricing">
										<p class="price">
											<span class="mr-2 price-dc">$${o.price * 1.3 }</span><span
												class="price-sale">$${o.price }</span>
										</p>
									</div>
								</div>
								<div class="bottom-area d-flex px-3">
									<div class="m-auto d-flex">
										<a href="#"
											class="add-to-cart d-flex justify-content-center align-items-center text-center">
											<span><i class="ion-ios-menu"></i></span>
										</a> <a href="add-to-cart?id=${o.product_id}&quantity=1"
											class="buy-now d-flex justify-content-center align-items-center mx-1">
											<span><i class="ion-ios-cart"></i></span>
										</a> <a href="add-to-wishlist?id=${o.product_id}"
											class="heart d-flex justify-content-center align-items-center ">
											<span><i class="ion-ios-heart"></i></span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>

	<script>
		$(document).ready(function() {

			var quantitiy = 0;
			$('.quantity-right-plus').click(function(e) {

				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());
				// If is not undefined

				$('#quantity').val(quantity + 1);
				// Increment

			});

			$('.quantity-left-minus').click(function(e) {
				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());

				// If is not undefined

				// Increment
				if (quantity > 1) {
					$('#quantity').val(quantity - 1);
				}
			});

		});
		function changeHeart() {
    		var heart = document.querySelector('.heart');
			console.log(heart);
			heart.classList.toggle("text-red");
		}
	</script>

</body>
</html>