<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="py-1 bg-primary">
		<div class="container">
			<div class="row no-gutters d-flex align-items-start justify-content-center align-items-center px-md-0">
				<div class="col-lg-12 d-block">
					<div class="row d-flex">
						<div class="col-md pr-4 d-flex topper align-items-center">
							<div class="icon mr-2 d-flex justify-content-center align-items-center"><span
									class="icon-phone2"></span></div>
							<span class="text">+ 123 456 789</span>
						</div>
						
						<div class="col-md pr-4 d-flex topper align-items-center">
							<form class="input-group" action="search" method="get">
						  		<div class="form-outline d-flex flex-row">
						  			<input type="search" id="form1" name="keyword" oninput="search(this)" value="${keyword}" placeholder="Seach..." style="width: 350px; padding: 5px 15px; border-radius: 15px; border: none; font-size: 14px;" />
							  		 <button type="submit" class="btn">
									    <i class="icon-search text-white"></i>
									 </button>
						  		</div>
							</form>
						</div>
						<c:if test="${sessionScope.user == null}">
							<div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
								<span class="text"><a href="login" class="text-white">Login & Singup</a></span>
							</div>
						</c:if>
						<c:if test="${sessionScope.user != null}">
							<div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
								<span class="text"><a class="text-white">Hello, ${sessionScope.user.email}</a></span>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>