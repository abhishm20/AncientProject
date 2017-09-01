
function validateRegForm2()
{ 
	  var cek = /^[a-zA-Z\']+$/;
	 /* if (!fileName) return;

	  dots = fileName.split(".")
	  //get the part AFTER the LAST period.
	  fileType = "." + dots[dots.length-1];

	  return (fileTypes.join(".").indexOf(fileType) != -1) ?
	  alert('That file is OK!') : 
	  alert("Please only upload files that end in types: \n\n" + (fileTypes.join(" .")) + "\n\nPlease select a new file and try again.");*/
	  /*var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];
	  var arrInputs = oForm.getElementsByName("profile_pic");
	    for (var i = 0; i < arrInputs.length; i++) {
	        var oInput = arrInputs[i];
	        if (oInput.type == "file") {
	            var sFileName = oInput.value;
	            if (sFileName.length > 0) {
	                var blnValid = false;
	                for (var j = 0; j < _validFileExtensions.length; j++) {
	                    var sCurExtension = _validFileExtensions[j];
	                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
	                        blnValid = true;
	                        break;
	                    }
	                }

	                if (!blnValid) {
	                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
	                    return false;
	                }
	            }
	        }
	    }

	    return true;
	  */
	  /*var file = document.getElementById('profile_pic').files[0];
	  if(file != null)
		  {
	  var fileFormat = file.name.split('.')[file.name.split('.').length - 1].toLowerCase();alert("Profile picture should be .png or .jpg or .jpeg and size should be less than 3MB");
		  }
	  var fileSize = file.size;*/
	/*  var filename = document.getElementById('profile_pic').value;
	  
	  var fileInput =  document.getElementById("profile_pic");
	    try{
	        alert(fileInput.files[0].size);
	        return false;// Size returned in bytes.
	    }catch(e){
	        var objFSO = new ActiveXObject("Scripting.FileSystemObject");
	        var e = objFSO.getFile( fileInput.value);
	        var fileSize = e.size;
	        alert(fileFormat);
	        alert(fileSize);
	        return false;*/
	  var dob=document.register.dob.value;
    var mob_no=document.forms["register"]["mobNo"].value;
    var state=document.forms["register"]["state"].value;
    var country=document.forms["register"]["country"].value;
    var pinCode=document.forms["register"]["pinCode"].value;
    var answer=document.forms["register"]["securityAns"].value;
    var line1=document.forms["register"]["line1"].value;
    var line2=document.forms["register"]["line2"].value;
    var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31]; 
    var city = document.forms["register"]["city"].value;
   
    /*
    	{
    	if(fileFormat != ".png" || fileFormat != ".jpg" || fileFormat != ".jpeg" || fileSize > 3145728)
    		{
    		alert("Profile picture should be .png or .jpg or .jpeg and size should be less than 3MB");
    		return false;
    		}*/
    	
 /*
				 
					  {  
					  alert("Invalid date format!");  
					  
					  return false;  
					  }  
					  if(mob_no==null||mob_no==""){
	                	  alert("Enter Mobile NO.");
	                	  return false;
	                  }
	                  else*/
  		  if(isNaN(mob_no)||mob_no<1400000000||mob_no>9999999990)
    {alert("Enter Correct Mobile No.");
    return false;
    }else
  	  if(line1==null||line1==""){
      	  alert("Enter Address Line 1.");
      	  return false;
        }
        else
      	  if(line2==null||line2==""){
          	  alert("Enter Address Line 2.");
          	  return false;
            }
            else if(city==null||city==""){
              	  alert("Enter City");
              	  return false;
                }
            else
          	  if(state==null||state==""){
              	  alert("Enter State");
              	  return false;
                }
                else
              	  if(country==null||country==""){
                  	  alert("Enter Country");
                  	  return false;
                    }
                    else
          	  if(answer==null||answer==""){
              	  alert("Enter answer of Security Question.");
              	  return false;
                }
                else
              	  if(pinCode==null||pinCode==""){
              	  alert("EnterPincode");
              	  return false;
                }else
   	if(isNaN(pinCode)||pinCode<=99999 ||pinCode>999999){
		alert("Enter Correct PIN");
		return false;
}
}


