<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<div align="center">
<body style= "background-color:pink">
<form action="log" method="post"> 
<h1>Student Registration</h1>
	
<p>Name:<input type="text" name="tbName" style="background-color:powderblue; color:black"></p>

<p>Email:<input type="email" name="tbEmail" style="background-color:powderblue; color:black"></p>

<p>Password:<input type="password" name="tbPassword" style="background-color:powderblue; color:black"></p>

<p>States:<select name="ddlStates" style="background-color:powderblue; color:black">
	        <option value="">--select--</option>
			<option value="karnataka">KA</option>
			<option value="Tamil Nadu">TN</option>
			<option value="Maharastra">MH</option>
			<option value="kerala">KL</option>
	</select>
	</p>
<input type="submit" value="Insert" style="background-color:blue; color:white">
</form>
<p><form action="update">
<input type="submit" value="Update" style="background-color:blue; color:white">
</form></p>
<p><form action="delete">
<input type="submit" value="Delete" style="background-color:blue; color:white">
</form></p>
<p>
<form action="showall">
<input type="submit" value="Show All" style="background-color:blue; color:white">
</p>
</form>

</body>
</html>