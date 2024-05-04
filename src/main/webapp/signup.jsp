<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://thymeleaf.org">

<head>
	<meta charset="UTF-8" />
	<meta name="viewport" contenteditable="width=device-width, initial-scale-1.0" />
	<title>SignUp</title>
	<link rel="stylesheet" href="./css/signup.css" />
</head>

<body>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="register" method="post">
				<h1>Sign Up</h1>
				<c:if test="${error != null}">
					<span style="color: red; text-align: center; font-size: 14px">${error }</span>
				</c:if>
				<input type="number" placeholder="Phone number" name="phoneNumber" required />
				<input type="text" placeholder="Example@gmail.com" name="email" required />
				<input type="password" placeholder="Password" name="password" required />
				<input type="password" placeholder="Confirm Password" name="repassword" required />

				<button type="submit">Sign Up</button>
			</form>
		</div>
		
		<div class="form-container sign-up-container-firstpage">
			<form action="login" method="post">
				<h3 style="color: red; font-weight: bold"></h3>
				<h3 style="color: red; font-weight: bold"></h3>
				<h3 style="color: blue; font-weight: bold"></h3>
				<h1>Login</h1>
				<span>Sign in with phone number and password</span>
				<c:if test="${message != null}">
					<span style="color: red; font-size: 14px;">${message }</span>
				</c:if>
				<input type="number" placeholder="Phone number" name="name" value="${phoneNumber}" required />
				<input type="password" placeholder="Password" name="pass" value="${password}" required />
				<div>
					<span style="color: Red; font-weight: bold"></span>
				</div>
				<div class="flex-row-reverse">
					<input name="remember" value="1" type="checkbox"
						class="form-check-input" id="exampleCheck1"> 
					<label class="form-check-label" for="exampleCheck1">Remember me</label>
				</div>
				<button type="submit">Login</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h2>Welcome to Vegefoods</h2>

					<button class="ghost" id="signIn">Login</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h2>Hello!</h2>
					<p>
						If you dont't have account, please enter your personal details to
						start journey with me.
					</p>
					<button class="ghost" type="submit" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script>
	<script
		src="https://partner.googleadservices.com/gampad/cookie.js?domain=anonystick.com&amp;callback=_gfp_s_&amp;client=ca-pub-1121308659421064&amp;cookie=ID%3D30ef4963e726bc22%3AT%3D1601867713%3AS%3DALNI_MYKre9fOXFq7S33O70k_HC_rwqx-Q"></script>
	<script src="https://pagead2.googlesyndication.com/pagead/js/r20201001/r20190131/show_ads_impl_fy2019.js"
		id="google_shimpl"></script>
	<script>
		const signUpButton = document.getElementById("signUp");
		const container = document.getElementById("container");
		const comeBackButton = document.getElementById("signIn");
		signUpButton.addEventListener("click", () => {
			container.classList.add("right-panel-active");
		});
		comeBackButton.addEventListener("click", () => {
			container.classList.remove("right-panel-active");
		});
	</script>
</body>

</html>