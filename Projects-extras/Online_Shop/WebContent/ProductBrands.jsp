<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.* , com.shop.dto.BrandDTO" %>
     <jsp:include page="/NavigationBar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Brands</title>

<script type="text/javascript" src="drop.js"></script>

<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>

</body>
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
          
          <%ArrayList list=(ArrayList)request.getAttribute("brand");%>     
            
            <tr>
                 <% if(list!=null){%>
                      
                    	  <%int i;
                    	    for(i=0;i<=2;i++){%>
                    	      
                    	      <%BrandDTO brand=(BrandDTO)list.get(i);%>
                    	       
                    	       
                    	        <td>
                    	            <a href="Brand<%=brand.getBid() %>">
                    	            <img src='<%=brand.getImg()%>' height=400 width=400 ></img>
                    	            </a>
                               </td>
                               
                             <%} %>
                             
                    <%} %>
            </tr>
    
            <tr>
             <% if(list!=null){%>
                      
                    	  <%int i;
                    	    for(i=0;i<=2;i++){%>
                    	      
                    	      <%BrandDTO brand=(BrandDTO)list.get(i);%>
                    	       
                    	      <td>
                    	      
                    	         <ul>  <ul><h3><font color="grey"><%=brand.getName()%></font></h3></ul></ul>
                    	           <ul><ul><ul><h2>Rs. <%=brand.getPrice()%></h2> </ul> </ul></ul>
                                       
                               </td>        
                                       
   
                             <%} %>
                             
                    <%} %>
            
            
            </tr>
        </table>      
                    
    </div>    
                   
</div>

</html>