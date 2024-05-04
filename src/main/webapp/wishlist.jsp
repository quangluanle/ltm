<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <jsp:include page="head.jsp"></jsp:include>
<body class="goto-here">
	<jsp:include page="top.jsp"></jsp:include>
		
	<jsp:include page="nav.jsp"></jsp:include>

    <div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Wishlist</span></p>
            <h1 class="mb-0 bread">My Wishlist</h1>
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
						        <th>Product</th>
						        <th>Description</th>
						        <th>Price</th>
						        <th>&nbsp;</th>
						      </tr>
						    </thead>
						    <tbody id="content">
								<c:forEach var="p" items="${products }">
									<tr class="text-center">
										<td class="image-prod"><div class="img"
												style="background-image: url(images/${p.value.image});"></div></td>
	
										<td class="product-name">
											<h3>
												<a href="product-detail?id=${p.value.product_id}">${p.value.name}</a>
											</h3>
											<p>${p.value.description }</p>
										</td>
	
										<td class="price">$${p.value.price }</td>
	
										<td class="product-remove"><a style="cursor: pointer;" onclick="removeFromWishlist(${p.value.product_id})"><span
												class="ion-ios-close"></span></a></td>

									</tr>
								</c:forEach>
								<!-- END TR-->
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
			</div>
		</section>

		<jsp:include page="footer.jsp"></jsp:include>

  	<script>
  	function removeFromWishlist(id) {
		$.ajax({
			url : "/Vegefoods/remove-wishlist",
			type : "get", 
			data : {
				product_id : id
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