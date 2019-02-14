
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Book View</title>
</head>
<body>
	<div align="center">
		<h1>AddressBook List</h1>
		<h3>
			<a href="newAddress">Add New Record</a>
		</h3>
		

		<table border="1">

			<thead>
				<tr>
					<th>Id</th>
					<th>Full Names</th>
					<th>email</th>
					<th>Work Number</th>
					<th>Mobile Number</th>
					<th>Home Number</th>
					<th>Physical Address</th>
				</tr>
			</thead>

			<tbody>



				<c:forEach var="addressBook" items="${addressBookLists}">

					<tr>
						<td>${addressBook.id}</td>
						<td>${addressBook.name}</td>
						<td>${addressBook.email}</td>
						<td>${addressBook.workNumber}</td>
						<td>${addressBook.mobileNumber}</td>
						<td>${addressBook.homeNumber}</td>
						<td>${addressBook.address}</td>
						<td><a href="editAddressBookRecord?id=${addressBook.id}">Edit</a>
							<a href="deleteAddressBookRecord?id=${addressBook.id}">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>