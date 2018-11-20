<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
	<title>http://todlerclinic.com | <decorator:title default="Todler Clinic" /></title>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="assets/css/styles.css"/>
    <link type="text/css" href="assets/css/bootstrap.css" rel="stylesheet"/>
    <link type="text/css" href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link type="text/css" href="bootstrap-datetimepicker.min.css" rel="stylesheet"/>

	<decorator:head />

</head>
<% response.flushBuffer(); %>
<!-- Above line Flush the Buffer Early so that buffer size required will be low though buffer size can be configured-->
<body>
<div id="pageWrapper">

<div id="header">
     <%@ include file="/WEB-INF/includes/header.jsp"%>
</div><!-- header -->

<div id="menu">
    <%@ include file="/WEB-INF/includes/menu1.jsp"%>
</div> <!-- End of menu -->

<div id="navigationRight">
<div id="menuItem">
	    <%@ include file="/WEB-INF/includes/navigationRight.jsp"%>
<hr></hr>
</div>

<div id="menuItem">
<h5 class="widgettitle">Latest Post</h5>
	    <%@ include file="/WEB-INF/includes/articleList.jsp"%>
</div>
    
</div><!-- rightSidebar -->

<div id="middleContainer">
	  <decorator:body />
</div><!-- middleContainer -->


<div id="footer">
    <%@ include file="/WEB-INF/includes/footer.jsp"%>
</div><!-- footer -->

</div> <!-- pageWrapper -->

    <script src="assets/js/jquery-1.10.2.min.js"></script>
    
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="assets/js/common.js"></script>
    <script type="text/javascript" src="assets/js/menu.js"></script>
	<script type="text/javascript">  
        $(document).ready(function () {  
            $('.dropdown-toggle').dropdown();  
        });  
       
   </script>
   <script type="text/javascript">
  $(function() {
    $('#requestedDt').datetimepicker({
      language: 'en',
      pick12HourFormat: true,
      autoclose: true,
      todayBtn: true
    });
  });
</script>  
</body>
</html>