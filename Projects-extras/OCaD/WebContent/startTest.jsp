<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Start Test</title>
<!-- SET: FAVICON -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!-- END: FAVICON -->
<!-- SET: STYLESHEET -->

<link href="css/startTest.css" rel="stylesheet" type="text/css" media="all" />
<%@ include file="homeHeader.jsp" %>

<div class="content">
<div class="note">

<br /><br />
<div class="Guest"><form action="prepareTest" method="get">
<label>Don't have account ... </label><input class="buttom" type="submit" tabindex="5" value="As a guest"/></form></div>
</div>
</div>



<%@ include file="footer.jsp" %>