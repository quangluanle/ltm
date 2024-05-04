<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN nav -->
<nav
	class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
	id="ftco-navbar">
	<div class="container">
		<a class="navbar-brand" href="home">Vegefoods</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>

		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto d-flex align-items-center">
				<li class="nav-item active"><a href="home" class="nav-link">Home</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="shop" id="dropdown04"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
					<div class="dropdown-menu" aria-labelledby="dropdown04">
						<a class="dropdown-item" href="shop">Shop</a> <a
							class="dropdown-item" href="wishlist">Wishlist</a> <a
							class="dropdown-item" href="cart">Cart</a>
					</div></li>
				<li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
				<li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
				<li class="nav-item cta cta-colored"><a href="cart"
					class="nav-link"> <span class="icon-shopping_cart totalItem">[${sessionScope.totalItem}]</span>
				</a></li>
				<c:if test="${sessionScope.user != null}">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						id="dropdown04" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <img src="./images/person.png"
							style="width: 30px; height: 30px; border-radius: 50%;" alt="" />
					</a>
						<div class="dropdown-menu" aria-labelledby="dropdown04">
							<c:if test="${sessionScope.user.role_id == 1 }">
								<a class="dropdown-item" href="dashboard">VegefoodShop Admin</a>
							</c:if>
							<a class="dropdown-item" href="logout">Logout</a>
						</div></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
<!-- END nav -->