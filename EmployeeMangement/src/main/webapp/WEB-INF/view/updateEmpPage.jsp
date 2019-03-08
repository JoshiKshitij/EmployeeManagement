<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h2>Hello World!</h2>
	<h3>${error}</h3>	

	<form action="updateEmp" method="post">
		  
		  first name <input type="text" name="firstName"  value="${emp.firstName} "><br>
		  last name <input type="text" name="lastName" value="${emp.lastName}"><br>
		  login id <input type="text" name="loginId" value="${emp.loginId}"><br>
		  password <input type="text" name="password" value="${emp.password}"><br>
		  dob<input type="text" name="dob" value="${emp.dob}"><br> 
		  street <input type="text" name="addressDto.street" value="${emp.addressDto.street}"><br>
		  state <input type="text" name="addressDto.state" value="${emp.addressDto.state}"> <br>
		  pincode <input type="text" name="addressDto.pincode" value="${emp.addressDto.pincode}"> <br>
		  city <input type="text" name="addressDto.city" value="${emp.addressDto.city}"> <br> 
		
		  <input type="submit" value="Click">
	</form>

</body>
</html>
