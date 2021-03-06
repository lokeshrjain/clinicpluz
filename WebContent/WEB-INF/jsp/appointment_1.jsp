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
<title>Appointment Page</title>
</head>
<body>
<!-- <ac:allcheck/> -->
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
					<legend>Appointment Form</legend>
					<form:form commandName="appointment" method="POST" name="appointment"
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
							<label class="control-label">Gender:</label>
							<div class="controls">
								<form:radiobutton path="gender" value="M" />Male
								<form:radiobutton path="gender" value="F" />Female
								<form:errors path="gender" cssClass="help-inline" element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Appointment Note:</label>
							<div class="controls">
								<form:textarea path="appointmentNote" rows="3" cols="20" />
								<form:errors path="appointmentNote" cssClass="help-inline" element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Gender:</label>
							<div class="controls">
								<form:radiobutton path="isNewAppt" value="Y" />Male
								<form:radiobutton path="isNewAppt" value="N" />Female
								<form:errors path="gender" cssClass="help-inline" element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Additional Note:</label>
							<div class="controls">
								<form:textarea path="additionalNote" rows="3" cols="20" />
								<form:errors path="additionalNote" cssClass="help-inline" element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Phone No:</label>
							<div class="controls">
								<form:input path="phoneNo" />
								<form:errors path="phoneNo" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Mobile No:</label>
							<div class="controls">
								<form:input path="mobileNo" />
								<form:errors path="mobileNo" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Phone No:</label>
							<div class="controls">
								<form:input path="requestedDt" />
								<form:errors path="requestedDt" cssClass="help-inline"
									element="span" />
							</div>
						</div>
						<div class="control-group">
							<div class="controls ">
								<button name="submit" type="submit" value="Book Appointment" class="btn">Book Appointment</button>
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