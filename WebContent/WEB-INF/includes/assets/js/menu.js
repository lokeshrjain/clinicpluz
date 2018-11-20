function expand(s)
{
  var td = s;
  var d = td.getElementsByTagName("div").item(0);

  td.className = "menuHover";
  d.className = "menuHover";
}

function collapse(s)
{
  var td = s;
  var d = td.getElementsByTagName("div").item(0);

  td.className = "menuNormal";
  d.className = "menuNormal";
}

var minHeight = 900; // Define a minimum height for the middle div

var resizeMiddle = function() {
    var h = $('body').height() - $('#header').height() - $('#footer').height();
    h = h > minHeight ? h : minHeight;
    $('#body').height(h);
}

$(document).ready(resizeMiddle);
$(window).resize(resizeMiddle);

//This is for editable table
function editRecord(id){
    var f=document.form;
    f.method="post";
    f.action='webFront';
    f.submit();
}

function deleteRecord(id){
    var f=document.form;
    f.method="post";
    f.action='delete.jsp?id='+id;
    f.submit();
}
