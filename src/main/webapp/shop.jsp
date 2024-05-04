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
						<span class="mr-2"><a href="index.html">Home</a></span> <span>Products</span>
					</p>
					<h1 class="mb-0 bread">Products</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section" style="overflow: hidden;">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-10 mb-5 text-center">
					<ul class="product-category">
						<li><a href="shop" class="category active">All</a></li>
						<c:forEach var="o" items="${categories}">
							<li><a class="category" style="cursor: pointer;"
								onclick="load(${o.cate_id})">${o.name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div class="row mb-2">
				<div class="col-8">
					<!-- Your other content here -->
				</div>
				<div class="col-4 ml-auto">
					<form action="search" method="get">
						<div class="input-group input-group-sm">
							<input oninput="search(this)" value="${keyword}" name="keyword"
								type="text" class="form-control" placeholder="Search...">
							<div class="input-group-append">
								<input type="submit" class="btn btn-primary"
									value="Search">
							</div>
						</div>
					</form>
				</div>
			</div>

			<div id="content" class="row mt-2">
				<c:forEach items="${products}" var="p">
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="product">
							<a href="product-detail?id=${p.product_id}" class="img-prod"><img
								class="img-fluid" src="images/${p.image}"
								alt="Colorlib Template"> <span class="status">20%</span>
								<div class="overlay"></div> </a>
							<div class="text py-3 pb-4 px-3 text-center">
								<h3>
									<a href="product-detail?id=${p.product_id}">${p.name}</a>
								</h3>
								<div class="d-flex">
									<div class="pricing">
										<p class="price">
											<span class="mr-2 price-dc">$${p.price/0.8}</span><span
												class="price-sale">$${p.price }</span>
										</p>
									</div>
								</div>
								<div class="bottom-area d-flex px-3">
									<div class="m-auto d-flex">
										<a href="#"
											class="add-to-cart d-flex justify-content-center align-items-center text-center">
											<span><i class="ion-ios-menu"></i></span>
										</a> <a href="add-to-cart?id=${p.product_id}&quantity=1"
											class="buy-now d-flex justify-content-center align-items-center mx-1">
											<span><i class="ion-ios-cart"></i></span>
										</a> <a href="add-to-wishlist?id=${p.product_id }"
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
		<div class="row mt-5">
			<div class="col text-center">
				<div class="block-27">
					<ul>
						<li class="page"><a style="cursor: pointer;" onclick="loadMore(1)">&lt;&lt;</a></li>
						<c:forEach var="i" begin="1" end="${totalPage}">
						  	<li class="page <c:if test='${i == 1}'>active</c:if>"><a style="cursor: pointer;" onclick="loadMore(${i})">${i}</a></li>
						</c:forEach>
						<li class="page"><a style="cursor: pointer;" onclick="loadMore(${totalPage})">&gt;&gt;</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		$('.category').click(function() {
			$('.category').removeClass('active'); 
			$(this).addClass('active'); 
		});
		
		$('.page').click(function() {
			$('.page').removeClass('active'); 
			$(this).addClass('active'); 
		});
		
		function load(cate_id) {
			$.ajax({
				url : "/Vegefoods/load",
				type : "get",
				data : {
					cid : cate_id
				},
				success : function(responeData) {
					document.getElementById("content").innerHTML = responeData;
				},
			});
		}
		
		function search(param) {
			var txtSearch = param.value;
			$.ajax({
				url : "/Vegefoods/searchAjax",
				type : "get", 
				data : {
					keyword : txtSearch
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
		
		/* Paginate */
		function loadMore(page) {
			$.ajax({
				url : "/Vegefoods/paginate",
				type : "get", 
				data : {
					index : page
				},
				success : function(data) {
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
				error : function(xhr) {
					//Do Something to handle error
				}
			});
		}
	</script>
</body>
</html>