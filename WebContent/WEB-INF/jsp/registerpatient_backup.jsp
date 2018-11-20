<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--  <%@ taglib uri="http://www.clinic.Tags.com/AllCheck" prefix="ac"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="assets/js/validation.js"></script>
<link type="text/css" href="assets/css/bootstrap.css" rel="stylesheet"/>

<title>Registration Page</title>
</head>
<body>
	<form:form commandName="customer" method="POST" name="registration"
		class="UserDisplayForm">

		<!-- <ac:allcheck/> -->
		<c:if test="${not empty msg}">
			<h5>
				<c:out value="${msg}"></c:out>
			</h5>
		</c:if>


		<div id="loginContainer">
			<h1>Registration Form:</h1>
			<br />
			<div>
				<label>First Name [Alphabates characters] :</label>
				<div>
					<form:input path="firstName" />
					<form:errors path="firstName" cssClass="error" element="span"/>
				</div>
			</div>
			<label>Last Name [Alphabates characters] :</label>
			<div>
				<form:password path="lastName" />
				<form:errors path="lastName" cssClass="error" element="span" />
			</div>
			<label>Address :</label>
			<div>
				<form:textarea path="address" rows="3" cols="20" />
				<form:errors path="address" cssClass="error" element="span" />
			</div>
			<div>
				<label>Post Code [numeric characters]:</label>
				<div>
					<form:input path="postcode" />
					<form:errors path="postcode" cssClass="error" element="span" />
				</div>
			</div>

			<label>Email [Valid email] :</label>
			<div>
				<form:input path="emailId" />
				<form:errors path="emailId" cssClass="error" element="span" />
			</div>
			<label>Password :</label>
			<div>
				<form:password path="passId" />
				<form:errors path="passId" cssClass="error" element="span" />
			</div>
			<label>Confirm Password :</label>
			<div>
				<form:password path="passIdConfirm" />
				<form:errors path="passIdConfirm" cssClass="error" element="span" />
			</div>
			<label>Sex [Select Male or Female]:</label>
			<div>
				<form:radiobutton path="gender" value="M" />
				Male
				<form:radiobutton path="gender" value="F" />
				Female
				<form:errors path="gender" cssClass="error" element="span" />
			</div>
			<label>Note [Optional up to 1000 charactors] :</label>
			<div>
				<form:textarea path="note" rows="3" cols="20" />
				<form:errors path="note" cssClass="error" element="span" />
			</div>

			<label>&nbsp</label>
			<div>
				<input name="submit" type="submit" value="Register" /><br />
			</div>
		</div>
	</form:form>

</body>
</html>