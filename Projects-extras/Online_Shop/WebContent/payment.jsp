<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet" type="text/css" href="buy.css"/>
</head>
<body>
 <div id="container">
  
   <div id="header">
       <div id="header1"><h2>Step2 -------------------------------------------------------------------------------------------------------------------------------------------------------</h2>
       
     <h3><font color="grey"> Payment Details </h3></font>
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
    <form action="finalpage.jsp">
    <h3><font color="grey">Select the Type of Payment Option</font></h3>
    <br>
   <input type="radio" name="r">Debit Card</input></br></br>
   <input type="radio" name="r">Credit Card</input></br></br>
  
   <input type="radio" name="r">Cash on Delievery</input></br></br>
   <ul><ul><button type="submit">Submit</button></ul></ul>
   </form>
    </div>
   
   
   
   </div>
 
 
 </div>


</body>
</html>