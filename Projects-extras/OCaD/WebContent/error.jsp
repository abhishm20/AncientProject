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
<link href="css/error.css" rel="stylesheet" type="text/css" media="all" />

  <%@ include file="homeHeader.jsp" %>
    <!-- Header ends --> 
    <!-- content Starts -->
    <div class="errorContent">
    <br><br><br><br>
     <fieldset class="errorPane">
    <legend style="color:#cc0000;font-size: 14px;">Error occured !!! </legend>
    <p style="font-size: 17px;color:#cc0000;">
    <%=config.getServletContext().getAttribute("message")%>
   </p>
  </fieldset>
     </div>
    <div class="clear"></div>
    <!-- content ends -->
    <%@ include file="footer.jsp" %>