
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.besant.model.Student"%>


<html>

<head>
<title>Student List</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}
</style>
</head>
<body>
	<h2>Student List</h2>
	<table>
		<tr>
			<th>Student ID</th>
			<th>Name</th>
			<th>DOB</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Address</th>
			<th>Department</th>
			<th>Passout</th>
			<th>Creator_Id</th>
			<th>Created_At</th>
		</tr>
		<%
		List<Student> students = (List<Student>) request.getAttribute("students");
		if (students != null && !students.isEmpty()) {
			for (Student student : students) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getDob()%></td>
			<td><%=student.getPhone()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getAddress()%></td>
			<td><%=student.getDept()%></td>
			<td><%=student.getPassout()%></td>
			<td><%=student.getCreator_id()%></td>
			<td><%=student.getCreated_at()%></td>




			<td>
				<form action="delete" method="POST">
					<input type="hidden" name="id" value="<%=student.getId()%>">
					<input type="submit" value="Delete" onclick=" refresh();" >
				</form>
			</td>
		</tr>

		<%
		}
		} else {
		%>
		<tr>
			<td colspan="10">No Student Found</td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>
