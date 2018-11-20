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
<title>Registration Page</title>
</head>
<body>
<!-- <ac:allcheck/> -->
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
					<legend>Registration Form</legend>
					<form:form commandName="customer" method="POST" name="registration"
						class="form-horizontal">

						<div class="control-group">
							<label class="control-label">First Name:</label>
							<div class="controls">
								<form:input path="firstName" />
								<form:errors path="firstName" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Last Name:</label>
							<div class="controls">
								<form:input path="lastName" />
								<form:errors path="lastName" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Address :</label>
							<div class="controls">
								<form:textarea path="address" rows="3" cols="20" />
								<form:errors path="address" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Post Code:</label>
							<div class="controls">
								<form:input path="postcode" />
								<form:errors path="postcode" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Email:</label>
							<div class="controls">
								<form:input path="emailId" />
								<form:errors path="emailId" cssClass="help-inline"
									element="span" />
							</div>

						</div>

						<div class="control-group">
							<label class="control-label">Password:</label>
							<div class="controls">
								<form:password path="passId" />
								<form:errors path="passId" cssClass="help-inline" element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Confirm Password:</label>
							<div class="controls">
								<form:password path="passIdConfirm" />
								<form:errors path="passIdConfirm" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Gender:</label>
							<div class="controls">
								<form:radiobutton path="gender" value="M" />Male
								<form:radiobutton path="gender" value="F" />Female
								<form:errors path="gender" cssClass="help-inline" element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Note:</label>
							<div class="controls">
								<form:textarea path="note" rows="3" cols="20" />
								<form:errors path="note" cssClass="help-inline" element="span" />
							</div>
						</div>
						<div class="control-group">
							<div class="controls ">
								<button name="submit" type="submit" value="Register" class="btn">Register</button>
								<button type="button" class="btn">Cancel</button>
							</div>
						</div>

					</form:form>
				</fieldset>
			</div>
		</div>
	</div>

</body>
</html>