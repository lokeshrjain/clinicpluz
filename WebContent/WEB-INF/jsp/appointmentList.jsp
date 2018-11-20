<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.clinicpluz.model.Appointment,java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
    
<html>
<head>
</head>
<body>
<c:if test="${not empty message}">
    <h5><c:out value="${message}"></c:out></h5>
</c:if>
  <c:if test="${!empty appointmentList}">
      <h3>Current appointments... </h3>
      <table class="table table-bordered table-striped">
          <thead>
          <tr><th>Name</th><th>Email</th><th>Address</th><th>Phone No.</th><th>Mobile No.</th><th>Is New</th><th>Requested Time</th><th colspan="2">Actions	</th></tr>
          </thead>
          <tbody>
          <c:forEach items="${appointmentList}" var="appointment">
              <tr>
                  <td>${appointment.lastName}, ${appointment.firstName}</td>
                  <td>${appointment.emailId}</td>
				  <td>${appointment.address},  ${appointment.postcode}</td>
                  <td>${appointment.phoneNo}</td>
                  <td>${appointment.mobileNo}</td>
                  <td>${appointment.isNewAppt}</td>
                  <td>${appointment.requestedDt}</td>
                  <td>
                      <form action="deleteappointment.htm" method="post"><input type="hidden" name="custId" value="${appointment.custId}" /><input type="hidden" name="apptId" value="${appointment.apptId}" /><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form>
                      <form action="editappointment.htm" method="post"><input type="hidden" name="custId" value="${appointment.custId}" /><input type="hidden" name="apptId" value="${appointment.apptId}" /><input type="submit" class="btn btn-mini" value="Edit"/></form>
                  </td>
              </tr>
          </c:forEach>
          </tbody>
      </table>
  </c:if>
</body>
</html>