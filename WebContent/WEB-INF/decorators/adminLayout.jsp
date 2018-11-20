<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>

<html>
<head>
	<decorator:head />
</head>
<% response.flushBuffer(); %>
<!-- Above line Flush the Buffer Early so that buffer size required will be low though buffer size can be configured-->
<body>

<div id="wrapper">

<%@ include file="/WEB-INF/includes/adminNavigationLeft.jsp"%>

 <div id="page-wrapper">
	<decorator:body />
 </div><!-- /#page-wrapper -->

 </div><!-- /#wrapper -->

 <!-- JavaScript -->
 <script src="js/jquery-1.10.2.js"></script>
 <script src="js/bootstrap.js"></script>

 </body>
</html>