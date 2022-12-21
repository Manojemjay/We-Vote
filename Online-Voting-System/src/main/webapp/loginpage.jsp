<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel ="stylesheet" type ="text/css" href="css/adminlogin.css">

</head>
<body>

<form action = login method = post>

<div class="admin">
<h2>ADMIN LOGIN</h2>

<div class="adminName">
	<label>ID</label><br>
	<input type="text" name="adminName" required>
</div>
<div class="adminPass">
	<label>Password</label><br>
	<input type="password" name="password" required>
</div>
<br>
<div class="button">
<input type=submit value=Login>
</div>
</div>
</form>

</body>
</html>