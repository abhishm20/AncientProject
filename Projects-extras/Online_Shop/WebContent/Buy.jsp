<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy</title>
<link rel="stylesheet" type="text/css" href="buy.css"/>
</head>
<body> 

 <div id="container">
  
   <div id="header">
       <div id="header1"><h2>Step1 -------------------------------------------------------------------------------------------------------------------------------------------------------</h2>
       
     <h3><font color="grey"> Kindly fill up the Required Details</h3></font>
       </div>
       
       <div id="header2">
    
        <form action="LogOutServlet" method="post">
        <button type="submit" value="submit">LogOut</button>
        </form>
        
        </div>
        
     </div>
     
     <div id="space"></div>
 
   <div id="content">
     
     <div id="sidebar"></div>
   
     <div id="formsection">
   <form action="payment.jsp">
      <table cellpadding='10'>
                      
                      
                      <tr>
                           <td>UserName:</td>
                           <td> <input type="text" name="name"  autofocus="autofocus" required></td>
                      </tr>
                      
                      <tr>
                            <td>Permanent Address:</td>
                            <td> <input type="text" name="address"  autofocus="autofocus" required></td>
                      </tr>
                      
                      
                      <tr>
                          <td>Shipping Address:</td>
                          <td> <input type="password" name="password"  autofocus="autofocus" required></td>
                      </tr>
                      
                      
                      <tr>
                          <td>Contact No.</td>
                          <td> <input type="text" name="userid"  autofocus="autofocus" required></td>
                      </tr>
                      

                    </table><br>
                    
                   <ul><ul><ul>  <button type="submit" value="submit">Next</button> </ul></ul></ul>
                   
                    </form>
   
   
   
    </div>
   
   
   
   </div>
 
 
 </div>


</body>
</html>