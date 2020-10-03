<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 200px;
		margin: 5px;
		text-align: left;
	}
	input, select {
		width: 200px;	
	}
	input[type=radio] {
		display: inline-block;
		margin-left: 45px;
	}
	input[type=checkbox] {
		display: inline-block;
		margin-right: 190px;
	}	
	
	button {
		padding: 10px;
		margin: 10px;
	}
</style>
</head>
<body>
	<div align="center">
		<h2>User Registration</h2>
		<form:form action="registration" method="post" modelAttribute="userdetails">
			
			<form:label path="fname">First Name</form:label>
			<form:input path="fname"/><br/>
			
			<form:label path="mname">Middle Name</form:label>
			<form:input path="mname"/><br/>
			
			<form:label path="lname">Last Name</form:label>
			<form:input path="lname"/><br/>
			
			<form:label path="phone">Phone Number</form:label>
			<form:input path="phone"/><br/>
			
			<form:label path="email">E-mail:</form:label>
			<form:input path="email"/><br/>
			
			<form:label path="password">Password:</form:label>
			<form:password path="password"/><br/>
			
			<form:label path="institute">Institute </form:label>
			<form:input placeholder="INstitute" path="institute"/><br/>
			
		
			
			<form:label path="role">Role </form:label>
			<form:select path="role">
			<option>Teacher</option>
			<option>Student</option>
			</form:select><br/>
			
				
				
			<form:button>Register</form:button>

		</form:form>
	</div>
</body>
</html>