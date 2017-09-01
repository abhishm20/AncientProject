<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="/NavigationBar.jsp"></jsp:include>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>

<script type="text/javascript" src="drop.js"></script>

<link rel="stylesheet" type="text/css" href="style.css"/>
<style>
a {
    color: #0000ff;
    text-decoration:none;
}
p, a span {
    color: #000000;
}
</style>
</head>
<body >

<div id="container">

     <div id="header">
     
        <div id="header1"></div>
        <div id="header2">
        <form action="LogOutServlet" method="post">
        <button type="submit" value="submit">LogOut</button>
        </form>
        </div>
        
    </div>
    
    
    <div id="content">
         
         <div id="navigation" style="height:683px;width:300px;float:left;">
         
         <ul>
         <h3>Trending For Women</h3>
         <a href="#"><span><font color="grey">Party Shoes</font></span></a></br></br>
         <a href="#"><span><font color="grey">Party Clutches</font></span></a></br></br>
         <a href="#"><span><font color="grey">Shehnaz Husain Store</font></span></a></br></br>
         <a href="#"><span><font color="grey">Miss Bennett Tops</font></span></a></br></br>
         <a href="#"><span><font color="grey">Lara Karen Dresses</font></span></a></br></br>
         
         <h3>Trending For Men</h3>
         <a href="#"><span><font color="grey">Fifa worldCup T-Shirts</font></span></a></br></br>
         <a href="#"><span><font color="grey">Gas Jeans</font></span></a></br></br>
         <a href="#"><span><font color="grey">Trendy Shorts</font></span></a></br></br>
         <a href="#"><span><font color="grey">Lee Shop</font></span></a></br></br>
         <a href="#"><span><font color="grey">Puma Shop</font></span></a></br></br>
         
        
         
        </ul>
         
         </div>
         <div id="maincontent" style="height:683px;width:1000px;float:right;">
         <tr><a href="SunGlasses.jsp"><img src="images/glasses.jpg" height=300 width=1000></img></a>
         </tr>
         <tr>
         <td><a href="#"><img src="images/dress.jpg" height=383 width=400></img></a></td>
         <td><a href="#"><img src="images/puma.jpg" height=380 width=300></img></a></td>
         <td><a href="#"><img src="images/bed.jpg" height=383 width=292></img></a></td>
         </tr>
         
         
         </div>
         
         
         
         
    </div>
    
    
</div>

</body>
</html>