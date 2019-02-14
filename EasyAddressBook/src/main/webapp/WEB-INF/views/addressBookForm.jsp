<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<title>Add new or Update records</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit AddressBook</h1>
		<form:form action="updateAddressBook" method="post"
			modelAttribute="addressBook">
			<table>
				<tr>
					<td><form:label path="id">Id:</form:label></td>
					<td><form:input path="id" disabled="true" /></td>
				</tr>
				<tr>
					<td>Full Names:</td>
					<td><form:input path="name" /></td>
					<td><form:errors class="invalid" path="name" style="color: red"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
					<td><form:errors class="invalid" path="email" style="color: red"/></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="Address" /></td>
					<td><form:errors class="invalid" path="Address" style="color: red"/></td>
				</tr>
				<tr>
					<td>Work Telephone:</td>
					<td><form:input path="workNumber" /></td>
					<td><form:errors class="invalid" path="workNumber" style="color: red"/></td>
				</tr>
				<tr>
					<td>Mobile_Number:</td>
					<td><form:input path="mobileNumber" /></td>
					<td><form:errors class="invalid" path="mobileNumber" style="color: red"/></td>
				</tr>
				<tr>
					<td>Home_Number:</td>
					<td><form:input path="homeNumber" /></td>
					<td><form:errors class="invalid" path="homeNumber" style="color: red"/></td>
				</tr>
				

				<tr>
					<td><input type="submit" value="Save" class = "addAddressBook"></td>

					<td><input type="reset" value="Cancel" class="cancel" /></td>


				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>