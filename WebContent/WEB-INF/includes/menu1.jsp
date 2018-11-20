<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <!-- NAVBAR
    ================================================== -->
    <div class="navbar-wrapper navbar">
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">

        <div class="navbar navbar-inverse">
          <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
              <ul class="nav">
                <li class="active"><a href="index.htm">Home</a></li>
                <!-- Read about Bootstrap dropdowns at http://twbs.github.com/bootstrap/javascript.html#dropdowns -->
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Serives<b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="createappointment.htm">New appointment</a></li>
                    <li><a href="childcheckup.htm">Routine Child Check UP</a></li>
                    <li class="divider"></li>
                    <li class="nav-header">Corporate Services</li>
                    <li><a href="#">NICU Setup</a></li>
                    <li><a href="#">Consultency</a></li>
                  </ul>
                </li>
                <li ><a href="aboutus.htm">About Us</a></li>
                <li ><a href="contactus.htm">Contact Us</a></li>
                <li ><a href="registerpatient.htm">Register With Us</a></li>
                
              </ul>
         	<form:form action="login.htm" commandName="customer" method="POST" name="login" class="navbar-form pull-right">
              <input class="span2" name="emailId" type="text" placeholder="Email">
              <input class="span2" name="passId" type="password" placeholder="Password">
              <button type="submit" class="btn">Sign in</button>
            </form:form>
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->

      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->
