function formValidation()
{
var userid = document.registration.userid;
var password = document.registration.password;
var username = document.registration.username;
var address = document.registration.address;


if(userid_validation(userid,5,12))
{
if(password_validation(password,7,12))
{
if(allLetter(username))
{
if(alphanumeric(address))
{


}
}
}
}

return false;

}

function userid_validation(userid,mx,my)
{
var userid_len = userid.value.length;
if (userid_len == 0 || userid_len >= my || userid_len < mx)
{
alert("UserId length between "+mx+" to "+my);
userid.focus();
return false;
}
return true;
}


function password_validation(password,mx,my)
{
var password_len = password.value.length;
if (password == 0 ||password_len >= my || password_len < mx)
{
alert("Password length be between "+mx+" to "+my);
password.focus();
return false;
}
return true;
}



function allLetter(username)
{
var letters = /^[A-Za-z]+$/;
if(username.value.match(letters))
{
username.focus();

return true;
}
else
{
alert('Username must have alphabet characters only');
return false;
}
}





function alphanumeric(address)
{
var letters = /^[0-9a-zA-Z]+$/;
if(address.value.match(letters))
{
return true;
}
else
{
alert('Address must have alphanumeric characters only');
address.focus();
return false;
}
}
