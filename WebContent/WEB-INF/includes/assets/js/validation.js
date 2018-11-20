// After form loads focus will go to User id field.
  function firstfocus()
  {
  var fName = document.registration.firstName.focus();
  return true;
  }
//// This function will validate User id.
//  function userid_validation(mx,my)
//  {
//  var uid = document.registration.userid;
//  var uid_len = uid.value.length;
//  if (uid_len == 0 || uid_len >= my || uid_len < mx)
//  {
//  alert("User Id should not be empty / length be between "+mx+" to "+my);
//  uid.focus();
//  return false;
//  }
//  // Focus goes to next field i.e. Password.
//  document.registration.passId.focus();
//  return true;
//  }
  
// This function will validate Password.
  function passId_validation(mx,my)
  {
  var passId = document.registration.passId;
  var passId_len = passId.value.length;
  if (passId_len == 0 ||passId_len >= my || passId_len < mx)
  {
  alert("Password should not be empty / length be between "+mx+" to "+my);
  passId.focus();
  return false;
  }
  // Focus goes to next field i.e. Name.
  document.registration.gender.focus();
  return true;
  }
// This function will validate first Name.
  function allLetterFirst()
  {
  var uname = document.registration.firstName;
  var letters = /^[A-Za-z]+$/;
  if(uname.value.match(letters))
  {
  // Focus goes to next field i.e. Address.
  document.registration.lastName.focus();
  return true;
  }
  else
  {
  alert('first name must have alphabet characters only');
  document.registration.firstName.focus();
  return false;
  }
  }

//This function will validate last Name.
  function allLetterLast()
  {
  var uname = document.registration.lastName;
  var letters = /^[A-Za-z]+$/;
  if(uname.value.match(letters))
  {
  // Focus goes to next field i.e. Address.
  document.registration.address.focus();
  return true;
  }
  else
  {
  alert('Last name must have alphabet characters only');
  uname.focus();
  return false;
  }
  }
  
  function CheckPassword(inputtxt)   
  {   
  var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;  
  if(inputtxt.value.match(passw))   
  {   
  alert('Correct, try another...');  
  return true;  
  }  
  else  
  {   
  alert('Wrong...!');  
  return false;  
  }  
  }  
  
  // This function will validate Address.
  function alphanumeric()
  {
  var uadd = document.registration.address;
  var letters =/^[a-z\d\-_\s]+$/i;
  ///^[0-9a-zA-Z]+$/
  if(uadd.value.match(letters))
  {
  // Focus goes to next field i.e. Country.
  document.registration.postcode.focus();
  return true;
  }
  else
  {
  alert('User address must have alphanumeric characters only');
  uadd.focus();
  return false;
  }
  }
  // This function will select country name.
  function countryselect()
  {
  var ucountry = document.registration.country;
  if(ucountry.value == "Default")
  {
  alert('Select your country from the list');
  ucountry.focus();
  return false;
  }
  else
  {
  // Focus goes to next field i.e. ZIP Code.
  document.registration.zip.focus();
  return true;
  }
  }
 // This function will validate postCode.
  function allnumeric()
  {
  var postcode = document.registration.postcode;
  var numbers = /^[0-9]+$/;
  if(postcode.value.match(numbers))
  {
  // Focus goes to next field i.e. email.
  document.registration.email.focus();
  return true;
  }
  else
  {
  alert('ZIP code must have numeric characters only');
  postcode.focus();
  return false;
  }
  }
//This function will validate Phone.
  function ValidatePhone(inputtxt)  
  {  
	  var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;  
    if((inputtxt.value.match(phoneno))) {  
        return true;  
          }  
        else  {  
          alert("Please enter a valid phone number");  
          return false;  
          }  
  }  

//This function will validate Phone.
  function ValidatePhone(inputtxt)  
  {  
	  var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;  
    if((inputtxt.value.match(phoneno))) {  
        return true;  
          }  
        else  {  
          alert("Please enter a valid mobile number");  
          return false;  
          }  
  }  

  // This function will validate date.

  function validatedate(inputText)  
  {  
  var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;  
  // Match the date format through regular expression  
  if(inputText.value.match(dateformat))  
  {  
  document.registration.requestedDt.focus();  
  //Test which seperator is used '/' or '-'  
  var opera1 = inputText.value.split('/');  
  var opera2 = inputText.value.split('-');  
  lopera1 = opera1.length;  
  lopera2 = opera2.length;
  
  // Extract the string into month, date and year  
  if (lopera1>1)  
  {  
	  var pdate = inputText.value.split('/');  
  }  
  else if (lopera2>1)  
  {  
	  var pdate = inputText.value.split('-');  
  }  
  
  var dd = parseInt(pdate[0]);  
  var mm  = parseInt(pdate[1]);  
  var yy = parseInt(pdate[2]);  
  // Create list of days of a month [assume there is no leap year by default]
  
  var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];  
  if (mm==1 || mm>2)  
  {  
  if (dd>ListofDays[mm-1])  
  {  
  alert('Invalid date format!');  
  return false;  
  }  
  }  
  if (mm==2)  
  {  
  var lyear = false;  
  if ( (!(yy % 4) && yy % 100) || !(yy % 400))   
  {  
	  lyear = true;  
	  }  
		  if ((lyear==false) && (dd>=29))  
		  {  
			  alert('Please enter a valid date!');  
			  return false;  
		  }  
		  if ((lyear==true) && (dd>29))  
		  {  
			  alert('Please enter a valid date!');  
			  return false;  
		  }  
	  }  
  }  
  else  
  {  
  alert("Please enter a valid date!");  
  document.registration.requestedDt.focus();  
  return false;  
  }
  //success after all validation
  document.registration.requestedTime.focus();
  return true;  
  
  }
  
  // This function will validate Email.
  function ValidateEmail()
  {
	  var uemail = document.registration.emailId;
	  var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	  if(uemail.value.match(mailformat))
	  {
		  document.registration.passId.focus();
		  return true;
	  }
	  else
	  {
		  alert("You have entered an invalid email address!");
		  uemail.focus();
		  return false;
	  }
  }
