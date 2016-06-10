
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>

<title>Login Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Blog Login Form Responsive Templates, Iphone Compatible Templates, Smartphone Compatible Templates, Ipad Compatible Templates, Flat Responsive Templates"/>
<link href="resources/style.css" rel='stylesheet' type='text/css' />

<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Handlee' rel='stylesheet' type='text/css'>

</head>
<body>
<!--start-main-->
<h1>Login Form</h1>
<div class="login-box">
	<div class="camera"> </div>
	<h2>Book Hub</h2>
	<form:form method = "POST" commandName = "user">
		<form:input path="name" value="USERNAME" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" /><form:errors path="name" cssStyle="color:#ff0000"></form:errors>
		<form:input path="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" /><form:errors path="password" cssStyle="color:#ff0000"></form:errors>
		<div class="btn"><input  type="submit" value="Login" name ="chklogin"></div>
	
		<div class="remember"><p>Not a Member?</p>
		<h4><a href="SignUp">Sign up now</a></h4>
		</form:form> 
	</div>
</div> 
		
		
		
		
		
		
		
		
</body>
</html>