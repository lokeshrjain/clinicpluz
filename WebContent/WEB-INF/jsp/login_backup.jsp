<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<form action="login.do" method="post">
<fieldset>
	
	<legend>Please Login using your email id as user id registered with us</legend>
	<center>
	<div id="loginContainer" align="center" >
	<ul>	
	<li><label for="email">Email [Valid email] :</label></li>
		<li><input type="text" name="emailId" id="emailId" size="50" onblur="ValidateEmail()" /></li>
	<li><label for="password">Password :</label></li>
	<li><input type="password" name="passId" id="passId" size="50" /></li>
	<li><input type="hidden" name="action" value="L" /></li>
			
	<li><input type="submit" name="submit" value="Submit" /> <a href="retrivePassword.jsp"> Forgot password </a></li>
	
		
	</ul>
		
	</div> <br/>
	
	<div>	
		<p> If you are not registered with us, please register by clicking on below link, if will help us to provide better medical services to your baby</p>
		<p><a href="registerPatient.jsp"> Please register with us to get an appointment </a></p>
	</div>
	</center>
</fieldset>
</form>
</body>
</html>