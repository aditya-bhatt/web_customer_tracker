<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table-style.css"/>
</head>
<body>
	<div class="container">
	<h3 align="center" class="mt-3 mb-3">Customer Relationship Manager</h3>
		<table class="blueTable">
			<tr>
				<th>#</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
			
			<c:url value="/customer/showFormForUpdate" var="updateLink">
			<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
			<c:url value="/customer/deleteCustomer" var="deleteLink">
			<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
				<tr>
					<td>${tempCustomer.id}</td>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td> 
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary mt-3 mb-3" href="${pageContext.request.contextPath}/customer/showCustomerForm" role="button">Add Customer</a>
	</div>
</body>
</html>