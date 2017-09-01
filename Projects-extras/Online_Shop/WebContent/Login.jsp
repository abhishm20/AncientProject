<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>

<link rel="stylesheet" type="text/css" href="loginstyle.css"/>

<script type="text/javascript" src="registration-form-validation.js"></script>



</head>
<body>

<div id="container">

      <div id="header">
             <div id="header1"><h1><i>Welcome to OnlineShop !</i></h1></div>
             <div id="header2">
             
               <form action="login" method="post" >
               
                   <%String msg =null; %>
                   <%msg=(String)request.getAttribute("msg"); %>
                
                     
                     
                      
                          <%if(msg!=null){%>
                         <font color="yellow"><b><%=msg%></b></font>



                          <%}%>

                    
 
                         <table cellpadding='10'>
                         <tr>
                            <td><t>UserId:</t></td>
                            <td><input type="text" name="userid" placeholder="Type userid here" autofocus="autofocus" required></td>
                         </tr>
                         <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" placeholder="Type password here" autofocus="autofocus" required></td>
                         </tr>
                     </table>
                     <button type="submit" value="submit">Login</button>

              </form>
            </div>
      </div>

     <div id="content">

             <div id="content1">
               <div class="image"></div>
             </div>
          
             <div id="content2">

                <form name="registration" action="register" method="post" onSubmit="return formValidation();">
              
                   <h2><i>Sign Up</i></h2>
                   <%String msg1 =null; %>
                   <%msg1=(String)request.getAttribute("msg1"); %>
                    
                     
                     
                      
                          <%if(msg1!=null){%>
                          <font color="blue"><b><%=msg1%></b></font>
                          <%}%>
                      

                      <table cellpadding='10'>
                      <tr>
                          <td>UserId:</td>
                          <td> <input type="text" name="userid"  autofocus="autofocus" required></td>
                      </tr>
                      
                      <tr>
                          <td>Password:</td>
                          <td> <input type="password" name="password"  autofocus="autofocus" required></td>
                      </tr>
                      
                      <tr>
                           <td>UserName:</td>
                           <td> <input type="text" name="name"  autofocus="autofocus" required></td>
                      </tr>
                      
                      <tr>
                            <td>Address:</td>
                            <td> <input type="text" name="address"  autofocus="autofocus" required></td>
                      </tr>

                    </table>
                    <button type="submit" value="Submit">Register</button>
 
                </form>

          </div>
   </div>
   
</div>   






</body>
</html>