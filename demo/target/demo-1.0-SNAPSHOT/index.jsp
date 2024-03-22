<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login and Multiplication Form</title>
</head>
<body>
<!-- Hello section -->
<h1>Hello World!</h1>

<hr>

<h2>Multiplication Form</h2>
<form action="multiply-servlet" method="GET">
  <label for="digit">Enter a number:</label>
  <input type="number" id="digit" name="digit">
  <input type="submit" value="Submit">
</form>
<br/>

<hr>

<h2>Login Form</h2>
<form action="db-servlet" method="GET">
  <input type="hidden" name="command" value="login"/>
  <label for="login">Login:</label>
  <input type="text" id="login" name="login" value="">
  <br/>
  <label for="pass">Password:</label>
  <input type="password" id="pass" name="pass" value="">
  <br/>
  <input type="submit" name="sub" value="Login"/>
</form>
<br/>
<p>${login_msg}</p>

</body>
</html>

