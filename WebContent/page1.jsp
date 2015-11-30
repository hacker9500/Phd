<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
	<form class="form-horizontal" role="form" action="/Phd/tab1" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" >Email*</label>
    <div class="col-sm-4">
      <input type="email" class="form-control"  placeholder="Enter email">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Name*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control"  placeholder="Enter Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Enrollment Number*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Area of<br>Corresspondance*</label>
    <div class="col-sm-4">
     	<textarea class="form-control" rows="3"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Mobile*</label>
    <div class="col-sm-4">
      <input type="number" class="form-control" min="1000000000" max="9999999999">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >PhD Stream*</label>
    <div class="col-sm-4">
      <div class="radio">
      	<label><input name="stream" type="radio">Computer Science</label>
      </div>
      <div class="radio">
      	<label><input type="radio" name="stream">Electronics and Communication</label>
      </div>
    <div class="radio">
      	<label><input type="radio" name="stream">Computational Biology</label>
  	</div>
  </div>
  </div>
	<script>
		var phd = 
			["---------","Artificial Intelligence and Robotics - CSE", "Biophysics - CB", "Compilers - CSE", "Computer Architecture and Systems Design - ECE", "Computer Architecture and Systems Design - CSE", "Computer Graphics - CSE", "Computer Vision - CSE", "Controls and Robotics - ECE", "Digital and Analog VLSI Systems Design - ECE", "Electromagnetics - ECE", "Embedded and VLSI systems design - ECE", "Embedded Systems - ECE", "Fiber-Wireless Architectures - ECE", "Image Analysis and Biometrics - CSE", "Information Management and Data Engineering - CSE", "Machine Learning - CSE", "Machine Learning - ECE", "Massively Parallel Systems - CSE", "Mobile Computing and Networking Applications - CSE", "OFDM based Optical Access Networks - ECE", "Optical Wireless Communication Systems - ECE", "Program Analysis - CSE", "RF and mixed signal electronics - ECE", "Security and Privacy - CSE", "Signal and Image Processing - ECE", "Signal and Image Processing - CSE", "Software Engineering - CSE", "Structural Biology - CB", "Systems Biology - CB", "Theoretical Computer Science - CSE", "Wireless Communication - ECE", "Wireless Networks - ECE", "Wireless Networks - CSE"];
	</script>
  <div class="form-group">
  		<label class="control-label col-sm-2" >PhD Area Preference 1*</label>
  		 <div class="col-sm-4">
  		 	<select id="pref1" name="pref1" class="form-control">
  		 	<script>
  		 			document.write("<option>");
  		 			document.write("---------");
  		 			document.write("</option>");
  		 	</script>
  		 	</select>
  		 </div>
  </div>
   <div class="form-group">
  		<label class="control-label col-sm-2" >PhD Area Preference 2*</label>
  		 <div class="col-sm-4">
  		 	<select class="form-control" id="perf2" name="pref2">
  		 	<script>
  		 			document.write("<option>");
  		 			document.write("---------");
  		 			document.write("</option>");
  		 	</script>
  		 	</select>
  		 </div>
  </div>
   <div class="form-group">
  		<label class="control-label col-sm-2" >PhD Area Preference 3*</label>
  		 <div class="col-sm-4">
  		 	<select class="form-control" id="pref3" name="pref3">
  		 	<script>
  		 			document.write("<option>");
  		 			document.write("---------");
  		 			document.write("</option>");
  		 	</script>
  		 	</select>
  		 </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" >Gender*</label>
    <div class="col-sm-4">
      <div class="radio">
      	<label><input name="gender" type="radio">Male</label>
      </div>
      <div class="radio">
      	<label><input type="radio" name="gender">Female</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Category*</label>
    <div class="col-sm-4">
      <div class="radio">
      	<label><input type="radio" name="category">General</label>
      </div>
      <div class="radio">
      	<label><input type="radio" name="category">SC</label>
      	<label><input type="radio" name="category">ST</label>
      	<label><input type="radio" name="category">OBC</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Physically Disabled*</label>
    <div class="col-sm-4">
      <div class="radio">
      	<label><input type="radio" name="pd">Yes</label>
      </div>
      <div class="radio">
      	<label><input type="radio" name="pd">No</label>
      </div>
    </div>
  </div>
  <div class="form-group">
  	 <label class="control-label col-sm-2" >Date of Birth*</label>
  	 <div class="col-sm-4">
  	 <div class="date">
  	 	<input type="date">
  	 </div>
  	 </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Children/War Widows of Defence Personnel killed/Disabled in Action*</label>
    <div class="col-sm-4">
      <div class="radio">
      	<label><input type="radio">Yes</label>
      </div>
      <div class="radio">
      	<label><input type="radio">No</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Father's Name*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control"  placeholder="Enter Name">
    </div>
  </div>
   <div class="form-group">
  		<label class="control-label col-sm-2" >Nationality*</label>
  		 <div class="col-sm-4">
  		 	<select class="form-control">
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
     	<textarea class="form-control" rows="3"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Pin Code*</label>
    <div class="col-sm-4">
      <input type="number" class="form-control" min="100000" max="999999">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
  </div>
</form>