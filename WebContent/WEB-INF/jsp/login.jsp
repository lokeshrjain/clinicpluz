<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring Sample - Login Page</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
					<legend>Login Form</legend>
					<div>${error}</div>
					<form:form commandName="customer" method="POST" name="login"
						class="form-horizontal">
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
							<div class="controls">
								<input name="submit" type="submit" value="Login" />
							</div>
						</div>
						
						<br />

						<div>
							<p>If you are not registered with us, please register by
								clicking on below link, if will help us to provide better
								medical services to your baby</p>
							<p>
								<a href="registerpatient.htm"> Please register with us to
									get an appointment </a>
							</p>
						</div>

					</form:form>
				</fieldset>

			</div>
		</div>
	</div>

</body>
</html>
