<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="/EcommerceApp" class="navbar-brand">Products</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Product Details</h3>
			<hr>
			<div class="container text-left">
			<form action="product" method="post">
				<input type="text" name="p_id" placeholder="Product ID">
				<input type="submit" class="btn btn-success">
			</form>
			</div>
			<br>
			
			<c:if test="${product.p_id != null}">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Price</th>
						<th>Brand</th>
					</tr>
				</thead>
				<tbody>			
						<tr>
							<td><c:out value="${product.p_id}" /></td>
							<td><c:out value="${product.p_name}" /></td>
							<td><c:out value="${product.p_price}" /></td>
							<td><c:out value="${product.p_brand}" /></td>
						</tr>
					<!-- } -->
				</tbody>
				
				</c:if>

			</table>
		</div>
	</div>
</body>
</html>