<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h1>add dept</h1>
	
	<h3>${dept }</h3>
	<h3>
		<form action="savedept" method="post">
			<div>
				<table>

					<tr>
						<th>department name</th>
						<td><input type="text" name="name"></td>
					</tr>

					<tr>
						<th>no of emps</th>
						<td><input type="number" name="noOfEmps"></td>
					</tr>

					<tr></tr>

				</table>
			</div>
			<div>
				<h2>
					<input type="submit" value="add dept">
				</h2>
			</div>
		</form>
	</h3>
</body>
</html>


