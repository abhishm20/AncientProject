<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.shop.dto.BrandDTO,java.util.ArrayList" %>
     
    <jsp:include page="/NavigationBar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<script type="text/javascript" src="drop.js"></script>

<link rel="stylesheet" type="text/css" href="style.css"/>
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
    
    <table > 
    
    
        <% ArrayList br=(ArrayList)session.getAttribute("cart"); %>
        
             <%if(br!=null){ %>
        
                <%int i=0; %>
        
                  <%for(i=0;i<br.size();i++){ %>
                  
                  
        
                     <%BrandDTO cart=(BrandDTO)br.get(i);%>
 
                       <tr>
                       
                      
                      
                       <td><img src='<%=cart.getImg()%>' height=100 width=100></img></td> 
 
                       <td><font color="grey"> Price: Rs.<%=cart.getPrice() %></font> </td>
                       
                       
                      <%int id; %>
                    
                        <%String url=response.encodeUrl("addtocart?id=2&removeindex="+i+"");%> 
                      
                       
                        <td> <a href="<%=url %>"> Remove </a> </td>   
                       
                      
    
                       </tr>
                       
             <%} %>
             
 
           <%} %>   
             
              </table> 
              
              
             
              <ul><ul><a href="Buy.jsp"><img src="images/buy.jpg" width=200 height=100></img></a></ul></ul>
    </div>
    
 </div>   

</body>
</html>