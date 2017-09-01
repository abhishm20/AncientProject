<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.ArrayList , com.shop.dto.MobileDTO" %>
    <jsp:include page="/NavigationBar.jsp"></jsp:include>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobiles</title>

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
    
       <table cellpadding='2'> 
          
          <%ArrayList list=(ArrayList)request.getAttribute("mobile");%>
             
            
            <tr>
            
                 <% if(list!=null){%>
                      
                    	  <%int i;
                    	    for(i=0;i<=2;i++){%>
                    	      
                    	      <%MobileDTO mobile=(MobileDTO)list.get(i);%>
                    	       
                    	       <td>
                    	        
                    	        
                               <ul> <h3><font color="grey"> <%=mobile.getName() %></font></h3></ul>
                               
                                <a href="Product<%=mobile.getMid()%>">
                                <img src='<%=mobile.getImg()%>' height=300 width=400 ></img>
                                </a>
                                
                               </td> 
                               
                               
                             <%} %>
                             
                    <%} %>
            </tr>
            <tr>
                 
                      
                    <% if(list!=null){%>
                      
                    	  <%int i;
                    	    for(i=3;i<=5;i++){%>
                    	      
                    	      <%MobileDTO mobile=(MobileDTO)list.get(i);%>
                    	       
                    	       <td>
                    	        
                               
                                <ul><h3><font color="grey"><%=mobile.getName() %></font></h3></ul>
                                  <a href="#"><img src='<%=mobile.getImg()%>' height=300 width=400></img></a>
                               </td> 
                               
                               
                             <%} %>
                             
                    <%} %>
            </tr>
            
                    
    </div>    
                   
</div>

</body>
</html>