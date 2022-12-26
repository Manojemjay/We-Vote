<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Online Voting System</title>
<link rel ="stylesheet" type ="text/css" href="css/style.css">
</head>

<body>
<form action="Userlogin" method="post">
<nav>
<div class="container">
	<h1>We-VOTE</h1>
	<div class="menu">
	<a href = "index.jsp"> Home</a>
	<a href ="register.jsp"> Register</a>
	<a href = "aboutus.jsp"> About-Us</a>
	<a href = "admin.jsp"> Admin</a>
	</div>
	
</div>
</nav>


<div class="login-box">
<h2>LOGIN</h2>
<form class="entry">
<div class="user-box">
	<input type="text" name="userID" required>
	<label>ID</label>
</div>
<div class="user-box">
	<input type="password" name="userPwd" required>
	<label>password</label>
</div>
<span style = "color: red;">${ERROR}<br></span>
<br><br>
<input type="submit" value="Login">
</form>
</div>


<footer>
<div class ="footer">

	<div id="footer_links">
	   <h3>We-vote</h3>
		<ul>
			
            <li><a href="contactus.jsp">Contact Us</a></li>
            <li><a href="#">Developer</a></li>
            <li><a href="#">What We Do</a></li>
            <li><a href="#">Careers</a></li>
         </ul>
	</div>
	
	
 	<div id="footer_info">
 	<p><a href="#">Terms of Service</a> I <a href="#">Privacy</a></p>
 	<p> © Copyright 2020 We-Vote. All rights reserved.</p>
 	</div>
</div>
</footer>
</form>
</body>


</html>