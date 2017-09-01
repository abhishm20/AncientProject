/**
 * 
 */
function validateRegForm1()
      { 
	var user = /^[a-zA-Z0-9.\-_]{3,40}$/;
    	  var cek = /^[a-zA-Z\']+$/;
    	 
    	  var userId=document.forms["register"]["userId"].value;
    	  var emailId=document.forms["register"]["emailId"].value;
    	  var password=document.forms["register"]["password"].value;
    	  var confirm=document.forms["register"]["confirm"].value;
    	  var name=document.forms["register"]["Fname"].value;
    	  var mname=document.forms["register"]["Mname"].value;
    	  var lname=document.forms["register"]["Lname"].value;
    	  
		  
         
         
          if(userId==null||userId=="" || !user.test(userId)){
        	  alert("User-id should be 3 to 30 length and contains alphanumeric with { '-' , '_' , '.'}");
        	  return false;
          }else 
          if(emailId==null||emailId==""){
            	  alert("Enter Email ID");
            	  return false;
              }else
            	  if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(emailId))) {
         	         alert("Enter Valid e-mail ID");
                     return false;
                     }else
            	  if(password==null||password==""){
                	  alert("Enter password ");
                	  return false;
            	  }else
          if(password!=confirm){
           			alert("Password Not Matched");
					return false;
           		}else
           		
           		  if(name==null||name==""){
                	  alert("Enter First Name");
                	  return false;
                  }
                  else
    		  if(!cek.test(name))
    		  { 
			  alert("Enter Valid First Name");
    		  return false;
    		 
    	  }else
		   if(!mname==null ||!mname==""){
    		  
          if(!cek.test(mname))
        		  { alert("Enter Valid Middle Name");
        		  return false;
    		  }
		   }else
    			  if(lname==null||lname==""){
                	  alert("Enter Last Name");
                	  return false;
                  }
                  else
    		  if(!cek.test(lname))
            		  { alert("Enter Valid Last Name");
            		  return false;
            		  
					  
      }
	  }
