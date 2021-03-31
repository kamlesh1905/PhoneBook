<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contacts</title>

<script type="text/javascript">

function confirmDelete()
{
	return confirm("Are you sure , you want to delete ?");
}

</script>


</head>
<body>

<h3>Contacts-display</h3>

<a href="loadform">Add New Contact</a>

<table border="1">
	<thead>
		<tr>
		 <th>Contact Id</th>
		 <th>Contact Name</th>
		 <th>Contact Number</th>	
		 <th>Contact Email</th>
		 <th>Action</th>
		</tr>
	<tbody>
		<c:forEach items="${contacts}" var="contact">
		<tr>
			<td>${contact.contactId}</td>
			<td>${contact.contactName}</td>
			<td>${contact.contactEmail}</td>
			<td>${contact.contactNumber}</td>
			<td><a href="edit?cid=${contact.contactId}">Edit</a> <a href="delete?cid=${contact.contactId }" onClick="return confirmDelete()">Delete</a></td>
		</tr>
		</c:forEach>			
	</tbody>

	
	</thead>
	

</table>


</body>
</html>