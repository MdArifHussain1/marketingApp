<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead List</title>
</head>
<body>
	<h2>All Registered Leads</h2>
	<table border="4">
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Mobile</th>
	<th>Delete</th>
	<th>Update</th>
	</tr>
	
	<c:forEach var="lead" items="${leads }">
	<tr>
	<th>${lead.firstName }</th>
	<th>${lead.lastName }</th>
	<th>${lead.email }</th>
	<th>${lead.mobile }</th>
	<th><a href="deleteLead?id=${lead.id }">delete</a></th>
	<th><a href="updateLead?id=${lead.id }">update</a></th>
	</tr>
	</c:forEach>
	</table>
</body>
</html>