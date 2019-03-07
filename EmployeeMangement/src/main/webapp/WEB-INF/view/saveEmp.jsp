<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h2>Hello World!</h2>
	<h2>${ index }</h2>

	<form action="saveEmployee" method="post">
		   id <input type="text" name="id"> <br>
		  first name <input type="text" name="firstName"><br>
		  last name <input type="text" name=lastName> <br> --%>
		  dob<input type="text" name="dob"><br> 
		    is active <input type="text" name="isActive" ><br> 
		  <input type="submit" value="Click">
	</form>

</body>
</html>
