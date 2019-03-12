<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h2>Add EMP </h2>
	<h3>${info}</h3>
	<h3>
		<form action="saveEmployee" method="post">
			<table>

				<tr>
					<th>first name</th>
					<td><input type="text" name="firstName"></td>
				</tr>

				<tr>
					<th>last name</th>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<th>login Id</th>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th>password</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<th>role</th>
					<td><input type="text" name="role"></td>
				</tr>
				<tr>
					<th>is active</th>
					<td><input type="text" name="isActive"></td>
				</tr>
				<tr>
					<th>street</th>
					<td><input type="text" name="addressDto.street"></td>
				</tr>
				<tr>
					<th>city</th>
					<td><input type="text" name="addressDto.city"></td>
				</tr>
				<tr>
					<th>state</th>
					<td><input type="text" name="addressDto.state"></td>
				</tr>
				<tr>
					<th>pincode</th>
					<td><input type="text" name="addressDto.pincode"></td>
				</tr>
				<tr><h2><input type="submit" value="add emp"></h2></tr>
				
			</table>
		</form>
	</h3>

</body>
</html>
