<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FinalPage</title>

<style>
#container{
height:718px;
width:1330px;
background-color:#ffffff;
}
#header{
height:35px;
width:1330px;

}
#header1{
height:35px;
width:1230px;
background-color:#ebdfeb;
float:left;
}
#header2{
height:35px;
width:100px;
background-color:#ebdfeb;
float:right;
}
#content{
height:683px;
width:1330px;
background-color:#ffffff;
}

</style>




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
    <br>
    </br><br></br>
   <ul><ul><ul><ul><ul><ul><ul><ul><ul><ul> <h2>Your Details have been Submitted...Now you can Logout !!! </h2></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul><br>
   <ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><h3><font color="grey"> Collect Your items within 7 working days....</font></h3></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul>
    <br>
   <ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><ul><h1><font color="red">Happy Shopping!!!</font></h1></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul></ul> 
    </div>
</div>
</body>
</html>