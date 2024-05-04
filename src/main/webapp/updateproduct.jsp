<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Update Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="dashboard">VegefoodShop</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="logout">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<a class="nav-link" href="dashboard">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> THỐNG KÊ
						</a>

						<div class="sb-sidenav-menu-heading">QUẢN LÝ</div>
						<a class="nav-link" href="ProductsController">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> SẢN PHẨM
						</a> <a class="nav-link" href="UsersController">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> TÀI KHOẢN
						</a>
					</div>
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">SẢN PHẨM</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="dashboard">THỐNG KÊ</a></li>
						<li class="breadcrumb-item"><a href="ProductsController">SẢN
								PHẨM</a></li>
						<li class="breadcrumb-item active">CẬP NHẬT SẢN PHẨM</li>
					</ol>
					<div class="container">
						<section class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">CẬP NHẬT SẢN PHẨM</h3>
							</div>
							<div class="panel-body">
								<form action="UpdateProduct" method="post"
									enctype="multipart/form-data">
									<c:if test="${error != null}">
										<div class="text-center alert alert-danger">
											<p>${error}</p>
										</div>
									</c:if>

									<div class="form-group">
										<label for="product_id" class="col-sm-3 control-label">Mã
											sản phẩm ID</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="product_id"
												id="product_id" placeholder="${product.product_id}"
												value="${product.product_id}" required="required"
												readonly="readonly">
										</div>
									</div>

									<div class="form-group">
										<label for="name" class="col-sm-3 control-label">Tên
											sản phẩm</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="name" id="name"
												placeholder="${product.name}" value="${product.name}"
												required="required">
										</div>
									</div>

									<!-- form-group // -->

									<div class="form-group">
										<label for="tech" class="col-sm-3 control-label">Danh
											mục</label>
										<div class="col-sm-3">
											<select class="form-control" name="category"
												required="required">
												<c:forEach items="${categories}" var="o">
													<option value="${o.cate_id }"
														${o.cate_id eq product.cate_id ? 'selected' : ''}>${o.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<!-- form-group // -->

									<div class="form-group">
										<label for="name" class="col-sm-3 control-label">Mô tả</label>
										<div class="col-sm-9">
											<textarea class="form-control" rows="3"
												placeholder="${product.description}" name="description"
												required="required">${product.description}</textarea>
										</div>
									</div>

									<div class="form-group">
										<label for="qty" class="col-sm-3 control-label">Giá</label>
										<div class="col-sm-3">
											<input type="number" class="form-control" name="price"
												placeholder="${product.price}" value="${product.price}"
												required="required">
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label">Hình
											ảnh</label>
										<div class="col-sm-3">
											<input type="file" name="image" id="imageProduct"
												required="required" /> <img src="images/${product.image}"
												style="height: 100px; width: 100px;" class="mt-2" src=""
												alt="" id="img" onload="">
										</div>
									</div>

									<hr>
									<div class="form-group">
										<div class="col-sm-offset-3 col-sm-9">
											<a href="ProductsController" class="btn btn-danger">Thoát</a>
											<button type="submit" class="ml-2 btn btn-primary">Cập
												nhật</button>
										</div>
									</div>
									<!-- form-group // -->
								</form>

							</div>
							<!-- panel-body // -->
						</section>
						<!-- panel// -->
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> BẢNG SẢN PHẨM
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>Tên sản phẩm</th>
										<th>Mô tả</th>
										<th>Giá</th>
										<th>Hình ảnh</th>
										<th>Hành động</th>

									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Tên sản phẩm</th>
										<th>Mô tả</th>
										<th>Giá</th>
										<th>Hình ảnh</th>
										<th>Hành động</th>

									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${products}" var="p">
										<tr>
											<td>${p.name}</td>
											<td>${p.description}</td>
											<td>${p.price}00VNĐ</td>
											<td><img src="images/${p.image}"
												alt=${p.image
												} width="100" height="100"></td>
											<td style="vertical-align: middle; text-align: center;">
												<div style="display: flex;">
													<a href="UpdateProduct?id=${p.product_id}"
														style="text-decoration: none; margin-top: 30px"> <img
														alt="" src="images/edit.png" width="20" height="20">
													</a> <a href="UpdateProduct?id=${p.product_id}"
														style="text-decoration: none; margin-top: 30px; margin-left: 15px">
														<img alt="" src="images/delete.jpg" width="20" height="20">
													</a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2023</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>

	<script type="text/javascript">
		 const image = document.getElementById('img')
	     const input = document.getElementById('imageProduct'
	     input.addEventListener("change", () => {
	         image.src=URL.createObjectURL(input.files[0])
	     })
	     window.onload = function() {
		     if (image.src!=null)
				
			}
		};

	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>
</html>