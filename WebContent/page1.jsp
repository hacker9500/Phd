<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form class="form-horizontal" role="form" action="tab1" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" >Email*</label>
    <div class="col-sm-4">
      <input type="email" class="form-control"  placeholder="Enter email" name="email" value=<%= (String)session.getAttribute("email") %> disabled>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Name*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control"  placeholder="Enter Name" name="name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Enrollment Number*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="enroll" value=<%= session.getAttribute("enroll").toString() %> disabled>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Area of<br>Corresspondance*</label>
    <div class="col-sm-4">
      <textarea class="form-control" rows="3" name="areaCorrespondence"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Mobile*</label>
    <div class="col-sm-4">
      <input type="number" class="form-control" min="1000000000" max="9999999999" name="contact">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >PhD Stream*</label>
    <div class="col-sm-4">
      <div class="radio">
        <label><input type="radio" id="CSE" name="phdpref" value="Computer Science">Computer Science</label>
      </div>
      <div class="radio">
        <label><input type="radio" name="phdpref" id="ECE" value="Electronics and Communication">Electronics and Communication</label>
      </div>
      <div class="radio">
        <label><input type="radio" name="phdpref" id="CB" value="Computational Biology">Computational Biology</label>
      </div>
    </div>
  </div>

  <div class="form-group">
      <label class="control-label col-sm-2" >PhD Area Preference 1*</label>
       <div class="col-sm-4">
        <select class="form-control" id="phdpref1" name="phdpref1">
          <option>--------</option>
        </select>
       </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >PhD Area Preference 2*</label>
        <div class="col-sm-4">
          <select class="form-control" id="phdpref2" name="phdpref2">
              <option>--------</option>
          </select>
        </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >PhD Area Preference 3*</label>
      <div class="col-sm-4">
        <select class="form-control" id="phdpref3" name="phdpref3">
          <option>--------</option>
        </select>
      </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Gender*</label>
    <div class="col-sm-4">
      <div class="radio">
        <label><input type="radio" name="gender" value="Male">Male</label>
      </div>
      <div class="radio">
        <label><input type="radio" name="gender" value="Female">Female</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Category*</label>
    <div class="col-sm-4">
      <div class="radio">
        <label><input type="radio" name="category" value="General">General</label>
      </div>
      <div class="radio">
        <label><input type="radio" name="category" value="SC">SC</label>
        <label><input type="radio" name="category" value="ST">ST</label>
        <label><input type="radio" name="category" value="OBC">OBC</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Physically Disabled*</label>
    <div class="col-sm-4">
      <div class="radio">
        <label><input type="radio" name="pod" value="Yes">Yes</label>
      </div>
      <div class="radio">
        <label><input type="radio" name="pod" value="No">No</label>
      </div>
    </div>
  </div>
  <div class="form-group">
     <label class="control-label col-sm-2" >Date of Birth*</label>
     <div class="col-sm-4">
      <div class="date">
        <input type="date" name="dob">
      </div>
     </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Children/War Widows of Defence Personnel killed/Disabled in Action*</label>
    <div class="col-sm-4">
      <div class="radio">
        <label><input type="radio" name="cow" value="Yes">Yes</label>
      </div>
      <div class="radio">
        <label><input type="radio" name="cow" value="No">No</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Father's Name*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control"  placeholder="Enter Name" name="fatherName">
    </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >Nationality*</label>
      <div class="col-sm-4">
        <select class="form-control" name="country">
        <script>
          var nat=["Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Democratic Republic", "Congo, Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Greenland", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Mongolia", "Morocco", "Monaco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Samoa", "San Marino", " Sao Tome", "Saudi Arabia", "Senegal", "Serbia and Montenegro", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"];
          var i;
          for(i=0;i<nat.length;i++)
          {
            document.write("<option>");
            document.write(nat[i]);
            document.write("</option>");
          }
        </script>
        </select>
      </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Permanent Address*</label>
    <div class="col-sm-4">
      <textarea class="form-control" rows="3" name="permanentAddress"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Pin Code*</label>
    <div class="col-sm-4">
      <input type="number" class="form-control" min="100000" max="999999" name="pinCode">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-4">
    	<% if(session.getAttribute("save1").equals("1")) {%>
      <button type="submit" class="btn btn-default" disabled>Save</button>
      <%} else{ %>
      <button type="submit" class="btn btn-default">Save</button>
      <%} %>
    </div>
  </div>
</form>