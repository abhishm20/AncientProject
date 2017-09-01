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
<link href="css/resetPassword.css" rel="stylesheet" type="text/css" media="all" />
<%@ include file="homeHeader.jsp" %>
<div class="forgotPassword">
<div class="resetForm">
<form action="resetPassword" method="post">
<table><tr><td><label><%if(null != request.getAttribute("forgotPasswordPage")){ %>
<%=request.getAttribute("forgotPasswordPage") %><%} %>
<tr>
<td><label><p>User-id or Email-id :</p></label></td>
<td><input type="text" autofocus="autofocus" maxlength="50" name="userId"></tr>
<tr><td><br/></td><td></td></tr><tr><td><br/></td><td></td></tr><tr><td></td><td></td></tr>
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</div>
</div>

<%@ include file="footer.jsp" %>