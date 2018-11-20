// JavaScript Document... save this with the file name getEmployee.js
var xmlHttp; 

function sendRequest(str)
  { 
  xmlHttp=CreateXmlHttpObject();
  if (xmlHttp==null)
  {
  alert ("Browser does not support HTTP Request");
  return;
  } 
  
  var url="webFront";
  url=url+"?qparam="+str;
  url=url+"&sid="+Math.random(); // to avoid cached data.
  
  xmlHttp.onreadystatechange=stateChanged; 
  xmlHttp.open("GET",url,true);
  xmlHttp.send(null);
  }
function stateChanged() 
  { 
  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
  { 
	  ProcessData(xmlHttp.responseXML); 
  } 
  } 

function CreateXmlHttpObject()
  { 
  var objXMLHttp=null;
  if (window.XMLHttpRequest)
  {
  objXMLHttp=new XMLHttpRequest();
  }
  else if (window.ActiveXObject)
  {
  objXMLHttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  return objXMLHttp;
  }



