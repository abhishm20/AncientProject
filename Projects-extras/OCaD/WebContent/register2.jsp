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
<link href="css/registration2.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/registration2.js"></script>
<%@ include file="homeHeader.jsp" %>
    <!-- Header ends --> 
    <!-- content Starts -->
    <div class="registration">
      <div class="registrationform">
      <fieldset id="reg_2">
      <legend style="font-size: 17px; color:#000;padding-bottom:30px;">Registration step-2 (optional) :</legend>
       <form id="contactform" enctype="multipart/form-data" action="registerUser2" method=post name="register"> 
		   <table >
		   <tr><td>
		   <label>Your profile picture:</label></td>
			<td><input type="file" tabindex="1" id="profile_pic" name="profile_pic" size="40"></td></tr>
		    <tr><td>  <p class="contact"><label for="phone">Mobile phone :</label></p> </td><td>
            <input id="phone" name="mobNo" placeholder="only ten digit no" maxlength="10" size="10"  tabindex="2"  type="text"> </td></tr>
			 <tr><td>
                 <label>Birthday :</label></td><td>
                 <input type="date" name="dob" tabindex="3">
               <!--    <select class="select-style" name="birthMonth" tabindex="9" >
					  <option value="">Month</option>
                  <option  value="01">January</option>
                  <option value="02">February</option>
                  <option value="03" >March</option>
                  <option value="04">April</option>
                  <option value="05">May</option>
                  <option value="06">June</option>
                  <option value="07">July</option>
                  <option value="08">August</option>
                  <option value="09">September</option>
                  <option value="10">October</option>
                  <option value="11">November</option>
                  <option value="12" >December</option>
                  
                 </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select class="select-style" tabindex="10" name="birthDay">
                  <option value="00">Day</option>
                  <option value="01">01</option>
                  <option value="02">02</option>
                  <option value="03" >03</option>
                  <option value="04">04</option>
                  <option value="05">05</option>
                  <option value="06">06</option>
                  <option value="07">07</option>
                  <option value="08">08</option>
                  <option value="09">09</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
				  <option value="13">13</option>
                  <option value="14">14</option>
                  <option value="15">15</option>
                  <option value="16">16</option>
                  <option value="17">17</option>
                  <option value="18">18</option>
                  <option value="19">19</option>
                  <option value="20">20</option>
                  <option value="21">21</option>
                  <option value="22">22</option>
                  <option value="23">23</option>
                  <option value="24">24</option>
                  <option value="25">25</option>
				  <option value="26">26</option>
                  <option value="27">27</option>
                  <option value="28">28</option>
                  <option value="29">29</option>
                  <option value="30">30</option>
                  <option value="31">31</option>
				  </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <select class="select-style" tabindex="11" name="birthYear">
                <option value="00">Year</option>
                  <option value="1975">1975</option>
                  <option value="1976">1976</option>
                  <option value="1977">1977</option>
                  <option value="1978">1978</option>
                  <option value="1979">1979</option>
                  <option value="1980">1980</option>
                  <option value="1981">1981</option>
                  <option value="1982">1982</option>
                  <option value="1983">1983</option>
                  <option value="1984">1984</option>
                  <option value="1985">1985</option>
                  <option value="1986">1986</option>
				  <option value="1987">1987</option>
                  <option value="1988">1988</option>
                  <option value="1989">1989</option>
                  <option value="1990">1990</option>
                  <option value="1991">1991</option>
                  <option value="1992">1992</option>
                  <option value="1993">1993</option>
                  <option value="1994">1994</option>
                  <option value="1995">1995</option>
                  <option value="1996">1996</option>
                  <option value="1997">1997</option>
                  <option value="1998">1998</option>
                  <option value="1999">1999</option>
				  <option value="2000">2000</option>
                  <option value="2001">2001</option>
                  <option value="2002">2002</option>
                  <option value="2003">2003</option>
                  <option value="2004">2004</option>
                  <option value="2005">2005</option>
				   <option value="2006">2006</option>
                  <option value="2007">2007</option>
                  <option value="2008">2008</option>
                </select> -->
              </td></tr>
           
				<tr><td><p class="contact"><label for="name">Address Line 1 :</label></p> </td><td>
    			<input id="name" name="line1" maxlength="50" placeholder="address line 1"  tabindex="4" type="text"> </td></tr>
				<tr><td><p class="contact"><label for="name">Address Line 2 :</label></p> </td><td>
    			<input id="name" name="line2" maxlength="50" placeholder="address line 2"  tabindex="5" type="text"></td></tr>
			<tr><td>	<p class="contact"><label for="name">Address Line 3 :</label></p> </td><td>
    			<input id="name" name="line3"maxlength="50" placeholder="address line 3"   tabindex="6" type="text"></td></tr>
    			<tr><td><p class="contact"><label for="name">City :</label></p> </td><td>
    			<input id="name" name="city" maxlength="30" placeholder="city"   tabindex="7" type="text"></td></tr>
				<tr><td><p class="contact"><label for="name">State :</label></p> </td><td>
    			<input id="name" name="state" maxlength="30" placeholder="state"   tabindex="8" type="text"></td></tr>
				<tr><td><p class="contact"><label for="name">Country :</label></p> </td><td>
    			<input id="name" name="country"  maxlength="30" placeholder="country"  tabindex="9" type="text"></td></tr>
				<tr><td><p class="contact"><label for="name">Pin Code :</label></p> </td><td>
    			<input id="name" name="pinCode"  placeholder="pin code" maxlength="6" size="6"   tabindex="10" type="text"></td></tr>
				<tr><td><p class="contact"><label for="name">Occupation</label> </td><td>
    			  <select name="occupation" tabindex="11" class="select-style"><option value="Student"> Student <option value="Working"> Working  </select> </td></tr>
    			  <tr><td>  <p class="contact"><label for="name">Company :</label> </p></td><td>
    			 <input id="name" name="CompanyName" maxlength="100"placeholder="Enter Company Name"  tabindex="12" type="text"></td></tr>
				
				<tr><td></td></tr>	<tr><td><br></td></tr>			
            <tr><td><input class="buttom" name="submit" id="submit" tabindex="13" value="Create" type="submit"  onclick="return validateRegForm2();">
           </td><td>
             		 <input class="buttom" name="reset" id="submit" tabindex="14" value="Reset" type="reset"> </td></tr>
             		 	</table>
   </form> 
</fieldset>
        </div>
      </div>
    <div class="clear"></div>
    <!-- content ends -->
   <%@ include file="footer.jsp" %>