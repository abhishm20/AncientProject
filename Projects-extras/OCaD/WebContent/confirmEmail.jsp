<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Confirm Email</title>
<!-- SET: FAVICON -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<!-- END: FAVICON -->
<!-- SET: STYLESHEET -->
<link href="css/home.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/confirmEmail.css" rel="stylesheet" type="text/css" media="all" />


<%@ include file="homeHeader.jsp" %>
    <!-- Header ends --> 
    <!-- content Starts -->
    <div class="confirmContent">
    <br><br><br><br>
     <fieldset class="confirmPane">
    <legend style="color:#07913B;font-size: 15px;">Successfully registered !!!</legend>
    <p style="font-size: 17px;color:#07913B;"><%if(!"one".equals(session.getAttribute("mailNo"))) {%>
You have successfully registered at ocadspace.com.....
<%} else{%><%if(!session.getAttribute("resendMail").equals("null")){ %>
<%=session.getAttribute("resendMail") %>
<%} }%>
<br><br>
An confirmation email has been to <%=session.getAttribute("emailId") %>....
<br><br><br>
Please confirm your account to get access at ocadspace.com
<br><br><br><br>

<a href="sendMail"><p>click here to resend confirmation mail</p></a>
<!-- <form action="sendMail" method="get">
<input type="submit" value="click to resend...">
</form> -->
</p>
  </fieldset>
     </div>
    <div class="clear"></div>
    <!-- content ends -->
    <%@ include file="footer.jsp" %>