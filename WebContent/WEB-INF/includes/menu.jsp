
  <!-- This dropdown menu is created by using a table named "navbar". It has a default width of 800 pixels -->
  <table class="navbar" >
    <tr>
     <!-- We are creating the first column in the table and assigning the css attributes assigned to "menuNormal". We are defining 		the width to be 160 pixels. We will trigger javascript functions on both the onmouseover and onmouseout events. -->

      <td class="menuNormal" width="250" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
         <p><a href="index.jsp" class="menuitem">Home</a></p>
      </td>

      <td class="menuNormal" width="250" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
        <!-- This is the menu item name that will appear at the top of the screen -->
        <p>Services for Patients</p>
        <div class="menuNormal" width="155">
          <table class="menu" width="155">
            <tr><td class="menuNormal">
              <a href="AppointmentPatient.jsp" class="menuitem">Appointment</a>
            </td></tr>
            <tr><td class="menuNormal">
              <a href="PatientCheckupService.jsp" class="menuitem">Routine Check up of your baby</a>
            </td></tr>
          </table>
        </div>
      </td>

      <td class="menuNormal" width="250" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
        <p>
        <a href="CorporateServices.jsp" class="menuitem">Our Corporate Services</a>
        </p>
      </td>

      <td class="menuNormal" width="250" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
        <p><a href="Contactus.htm" class="menuitem">Contact us</a></p>
      </td>
      <td class="menuNormal" width="250" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
        <p><a href="registerPatient.jsp" class="menuitem">Register with US</a></p>
      </td>
    </tr>
  </table>
