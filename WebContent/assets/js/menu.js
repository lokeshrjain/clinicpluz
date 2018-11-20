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


//This is for editable table
function editRecord(id,action){
    var f=document.form;
    f.method="post";
    f.action='appointmentList.do?action=' + action + '&Id='+id;
    f.submit();
}

function deleteRecord(id,action){
    var f=document.form;
    f.method="post";
    f.action='appointmentList.do?action=' + action + '&Id='+id;
    f.submit();
}

//This is for editable table for ADMIN
function editArticleRecord(id,action){
    var f=document.form;
    f.method="post";
    f.action='managearticle.do?action=' + action + '&Id='+id;
    f.submit();
}

function deleteArticleRecord(id,action){
    var f=document.form;
    f.method="post";
    f.action='managearticle.do?action=' + action + '&Id='+id;
    f.submit();
}