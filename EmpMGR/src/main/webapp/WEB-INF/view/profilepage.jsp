
<html>
<body>
<h1>Profile</h1>
<table>
	<tr>
		<td>first Name</td> <td>${ emp.firstName}</td>
	</tr>
	<tr>
		<td>last Name</td> <td>${emp.lastName }</td>
	</tr>
	<tr>
		<td>login id</td> <td>${ emp.loginId}</td>
	</tr>
	<tr>
		<td>password</td> <td>${ emp.password}</td>
	</tr>
	<tr>
		<td>dob</td> <td>${emp.dob}</td>
	</tr>
	<tr>
		<td>role</td> <td>${ emp.role}</td>
	</tr>
	<tr>
		<td>street</td> <td>${ emp.addressDto.street}</td>
	</tr>
	<tr>
		<td>city</td> <td>${ emp.addressDto.city}</td>
	</tr>
	<tr>
		<td>state</td> <td>${ emp.addressDto.state}</td>
	</tr>
	<tr>
		<td>pin code</td> <td>${ emp.addressDto.pincode}</td>
	</tr>
</table>


<p><a href="updateProfile">update profile</a></p>
</body>
</html>
