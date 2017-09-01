/**
 * 
 */
function validateForm()
{
	  var cek = /^[a-zA-Z\ \']+$/;
	  var password=document.forms["register"]["password"].value;
	  var userId=document.forms["register"]["userId"].value;
	  
	if(userId == "null" || password == "null")
		{
		alert("Enter valid data !!!");
		}
}