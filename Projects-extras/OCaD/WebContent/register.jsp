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
<link href="css/registration1.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/registration1.js"></script>
<%@ include file="homeHeader.jsp" %>
    <!-- Header ends --> 
    <!-- content Starts -->
    <div class="registration">
      <div class="registrationform"><div id="warning" style="padding-bottom: 5px;color: #cc0000;font-size: 15px;padding-left: 20px;'"><%if(null != request.getAttribute("alreadyExist")){ %><%=request.getAttribute("alreadyExist") %><%} %></div>
      <fieldset id="reg_1">
      <legend style="font-size: 17px; color:#000;padding-bottom:30px;">Registration step-1 (Compulsory)::</legend>
       <form id="contactform" action="registerUser" method=post name="register"> 
		   <table cellspacing="10">
			 <tr><td><p class="contact"><label for="username">Create a User-id :</label></p> </td>
    			<td><input id="userId" maxlength="40" name="userId" placeholder="User Id to login"  tabindex="1" type="text"> </td></tr>
				<tr><td><p class="contact"><label for="email">Email :</label></p></td> 
    			<td><input id="email" maxlength="50" name="emailId" placeholder="example@domain.com"  tabindex="2"  type="email"></td></tr>
				<tr><td><p class="contact"><label for="password">Create a password :</label></p></td> 
    			<td><input type="password" maxlength="50"id="password" name="password"placeholder="********" tabindex="3" ></td></tr> 
                <tr><td><p class="contact"><label for="repassword">Confirm your password :</label></p></td> 
    			<td><input type="password"maxlength="50" id="confirm" name="confirm" placeholder="********" tabindex="4"  ></td></tr> 
				
					<tr><td><p class="contact"><label for="name">First Name :</label></p></td> 
    			
    			<td><input id="name"maxlength="30" name="Fname" placeholder="Enter First Name" tabindex="5" type="text"></td></tr> 
    			 <tr><td><p class="contact"><label for="name">Middle Name :</label></p> </td><td>
    			<input id="name"maxlength="30" name="Mname" placeholder="Enter Middle Name" tabindex="6" type="text"> </td></tr>
    			 <tr><td><p class="contact"><label for="name">Last Name :</label></p> </td><td>
    			<input id="name"maxlength="30" name="Lname" placeholder="Enter Last Name"  tabindex="7" type="text"> </td></tr>
    		 <tr><td><label for="gender">Gender :</label> </td><td><select name="gender" tabindex="8" class="select-style">
    		 <option value="Male">Male<option value="Female">Female</select> </td></tr>
				<tr><td> <p class="contact"><label for="name">Select Security Question :</label></td><td> 
    			  <select name="securityQue" tabindex="22" class="select-style">
    			  <option value="What was your childhood nickname?">What was your childhood nickname? 
				  <option value="What is the name of your favorite childhood friend?">What is the name of your favorite childhood friend?
				  <option value="What was the name of your elementary / primary school?">What was the name of your elementary / primary school?
				  <option value="What is the country of your ultimate dream vacation?">What is the country of your ultimate dream vacation?
				  <option value="What was your dream job as a child?">What was your dream job as a child?
				  <option value="Who was your childhood hero?">Who was your childhood hero?</select></td></tr>
				<tr><td><p class="contact"><label for="name">Answer :</label></p> </td><td>
    			<input id="name" name="securityAns"  placeholder="security answer"  tabindex="23" type="text"></td></tr>
				<tr><td></td></tr>	<tr><td><br></td></tr>			
            <tr><td><input class="buttom" name="submit" id="submit" tabindex="24" value="Submit" type="submit"  onclick="return validateRegForm1();">
           </td><td>
             		 <input class="buttom" name="reset" id="submit" tabindex="25" value="Reset" type="reset"> </td></tr>	</table>
   </form> 
</fieldset>
        </div>
      </div>
    <div class="clear"></div>
    <!-- content ends -->
   <%@ include file="footer.jsp" %>