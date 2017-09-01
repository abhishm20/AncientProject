<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="/NavigationBar.jsp"></jsp:include>
    
    <%@ page import="com.shop.dto.BrandDetailDTO" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brand Detail</title>

<script type="text/javascript" src="drop.js"></script>

<link rel="stylesheet" type="text/css" href="style.css"/>

<link rel="stylesheet" type="text/css" href="BrandDetail.css"/>


</head>
<body>

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
    
    
      
          
         <%BrandDetailDTO brand =(BrandDetailDTO)request.getAttribute("brand");%>  
             
             
             
             <div id="sidebar">
              
             <img src='<%=brand.getImg()%>' height=400 width=400 ></img> 
             
             </div>
             
             <div id="maincontent">
             
             <h2><%=brand.getName() %></h2>
                          
                     <font Color="grey">    <h3> Specifications---------------------------------------------</h3></font> 
                     <font Color="grey"><%=brand.getFeatures() %></font><br></br><br></br>
                     
                          <h2>Price:Rs. <%=brand.getPrice() %></h2>  
                           
                          
                          <%int id; %>
                           <%String url=response.encodeUrl("addtocart?id=1&image="+brand.getImg()+"&price="+brand.getPrice()+"");%>
                           
                           <a href="<%=url%>">
                           
                           <img src="images/button.jpg">
                           </img>
                           
                           </a>
                          
             </div>
             
            
             
            <div id="remarks">
                  <font color="grey"> <h2>Remarks--------------------------------------------------------------------------------------------------</h2></font><br>
                  
                  <font Color="grey"><%=brand.getRemarks() %></font><br></br></br>
                  <font Color="grey">Good Touch-------------------------------------------------------</font><br></br></br>
                  <font Color="grey">Screen is Perfect----------------------------------------------------</font><br></br></br>
                  <font Color="grey">Very Fast with Amazing Battery Backup---------------------------------------------------         </font>
                  
            </div>               
                    
                               
            
                 
   
 
    </div>
</div>    
</body>
</html>