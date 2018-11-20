<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.clinicpluz.model.Article,java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<body>
<%


System.out.println("*** Session data ***");
Enumeration<String> e = session.getAttributeNames();
while (e.hasMoreElements()){
  String s = e.nextElement();
  System.out.println(s);
  System.out.println("**" + session.getAttribute(s));
}


%>
<c:forEach var="objArt" items="${articleList}">
	<p align="left"> <strong>Title : <a href="article.do?Id="${objArt.articleId}> ${objArt.title} </a></strong></p>
	<p align="left">
		<strong>Article Text :</strong> ${objArt.bodyText} 
    </p>
    <hr></hr>
</c:forEach>

</body>
</html>