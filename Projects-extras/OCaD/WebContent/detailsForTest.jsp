<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OCaD-space</title>
<!-- SET: FAVICON -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!-- END: FAVICON -->
<!-- SET: STYLESHEET -->

<link href="css/detailForTest.css" rel="stylesheet" type="text/css" media="all" />
<%@ include file="homeHeader.jsp" %>

<div class="content">
<div class="form"><div id="warning" style="padding-bottom: 5px;color: #cc0000;font-size: 15px;padding-left: 20px;'">
     <%if(null != request.getAttribute("loginPage")){ %><%=request.getAttribute("loginPage") %><%} %></div>
<form action="log_in" method="post">
<table>
<tr>
<td><p>User-ID :</p></td>
<td><input type="text" maxlength="40" tabindex="1" placeholder="user-ID" name="userId"/></td>
</tr>
<tr>
<td><p>Password :</p></td>
<td><input type="password" maxlength="40" tabindex="2" placeholder="********" name="password"/></td>
</tr>
<tr><td><br/></td></tr>
<tr><td></td><td><input class="buttom" type="submit" tabindex="3" value="Login"/>  <input class="buttom" type="reset" tabindex="4" value="Reset"/></td></tr>
</table>
</form>
<br /><br />
<div class="Guest"><form action="prepareTest" method="get">
<label>Don't have account ... </label><input class="buttom" type="submit" tabindex="5" value="As a guest"/></form></div>
</div>
</div>



<%@ include file="footer.jsp" %>