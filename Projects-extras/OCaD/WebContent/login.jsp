<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OCaD-space</title>
<!-- SET: FAVICON -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!-- END: FAVICON -->
<!-- SET: STYLESHEET -->
<link href="css/home.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/login.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/login.js"></script>
<%@ include file="homeHeader.jsp" %>
    <!-- Header ends --> 
    
    
    <!-- content Starts -->
    <div class="login">
     <div class="loginform"><div id="warning" style="padding-bottom: 5px;color: #cc0000;font-size: 15px;padding-left: 20px;'">
     <%if(null != request.getAttribute("loginPage")){ %><%=request.getAttribute("loginPage") %><%} %></div>
     <form id="contactform" action="loginUser" method="post" name="register"> 
			 <table>
<tr><td><label for="username">User-Id :</label><br><br><input maxlength="40" tabindex="1" required="" type="text" name="userId"></td></tr><br>
<tr><td><label for="username">Password :</label><br><br><input maxlength="30" tabindex="2" required="" type="password" name="password"></td></tr><br>
<tr><td><input  type="checkbox" tabindex="3" name="rememberMe" value="rememberMe" ><label for="username">Remember me</label></td></tr>
<tr><td><br></td></tr>
<tr><td><input class="buttom" tabindex="4" name="submit" id="submit" tabindex="23" value="Log In" type="submit"  onclick="return validateForm();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input class="buttom" name="reset" tabindex="5" id="submit" tabindex="24" value="Reset" type="reset"> 	</td></tr>
<tr><td></td></tr><tr><td></td></tr>
<tr><td><label><a href="forgotPassword">forgot password?</a></label>
</table>  
   </form> 
     
     </div>       
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
    <!-- content ends -->

<%@ include file="footer.jsp" %>