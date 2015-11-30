<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<form class="form-horizontal" role="form">
<div>
  <h3>Schooling Information</h3>
  <hr>
  <div class="form-group">
    <label class="control-label col-sm-2" >Xth Board*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="xBoard">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Xth Marks(%)*</label>
    <div class="col-sm-4">
      <input type="number" class="form-control" min="0.0" max="100.0" name="xMarks">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Year of passing class Xth*</label>
    <div class="col-sm-4">
      <select class="form-control" name="xYear">
        <script>
          var i;
          for(i=2013;i>=1951;i--)
          {
            document.write("<option>"+i+"</option>");
          }
        </script>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >XIIth Board*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="xiiBoard">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >XIIth Marks(%)*</label>
    <div class="col-sm-4">
      <input type="number" class="form-control" min="0.0" max="100.0" name="xiiMarks">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Year of passing class XIIth*</label>
    <div class="col-sm-4">
      <select class="form-control" name="xiiYear">
        <script>
          var i;
          for(i=2015;i>=1951;i--)
          {
            document.write("<option>"+i+"</option>");
          }
        </script>
      </select>
    </div>
  </div>
</div>
<div>
  <h3>Graduation Information</h3>
  <hr>
  <div class="form-group">
    <label class="control-label col-sm-2" >Degree*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="gradDegree">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Department/Discipline*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="gradDepartment">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Name of College*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="gCollege">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Name of University*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="gUniversity">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >City*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="gCity">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >State*</label>
    <div class="col-sm-4">
      <select class="form-control" name="gState">
        <script>
        var state=["Arunachal Pradesh","Assam","Bihar","J&K","Rajasthan","Uttar Pradesh","Punjab","Himachal Pradesh","Uttrakhand","Harayana","Madhya Pradesh","West Bengal","Chattisgarh","Tamil Nadu","Nagaland","Manipur","Mizoram","Tripura","Telangana","Kerala","Karantaka","Gujarat","Maharashtra","Delhi","Jharkhand","Anadaman & Nicobar Islands","Daman and Diu","Pondicherry","Sikkim","Orissa","Dadar and Nagar Haveli","Goa","Chandigarh","Meghalya","Other"];
        state.sort();
        var i;
        for(i=0;i<state.length;i++)
        {
            document.write("<option>"+state[i]+"</option>");
        }
        </script>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2">Year of Graduation*</label>
    <div class="col-sm-4">
      <select class="form-control" name="gYear">
        <script>
          var i;
          for(i=2015;i>=1951;i--)
          {
            document.write("<option>"+i+"</option>");
          }
        </script>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >CGPA or Marks*</label>
    <div class="col-sm-4">
     <div class="radio">
        <label><input type="radio" name="gCheck" value="CGPA">CGPA</label><br>
     </div>
      <input type="number" class="form-control">/<select class="form-control"><option>4</option><option>10</option></select><br>
      <div class="radio">
        <label><input type="radio" name="gCheck" value="Marks">Marks(%)</label><br>
        <input type="number" class="form-control" min="0.0" max="100.0">
      </div>
    </div>
  </div>
</div>
<div class="form-group">
    <div class="checkbox col-sm-4">
        <label><input type="checkbox" id="chk1">Are you applying for ECE PhD? </label>
    </div>
</div>
<div id="chkDiv1" style="display: none">
    <h3>ECE PhD Subject Preference</h3><hr>
    <div class="form-group">
      <label class="control-label col-sm-2" >Preference 1* </label>
      <div class="col-sm-4">
        <select class="form-control">
          <option>--------</option>
          <script>
            var opt=["Advanced Signal Processing","Statistical Signal Processing","Digital VLSI Design","Analaog CMOS Design","Digital Communications","Communication Networks","Linear Systems","Introduction to Robotics","RF Circuit Design","Antennas and Propagation","Embedded Systems"];

            for(i=0;i<opt.length;i++)
            {
              document.write("<option>"+opt[i]+"</option>");
            }
          </script>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Preference 2* </label>
      <div class="col-sm-4">
        <select class="form-control">
          <option>--------</option>
          <script>
          var opt=["Advanced Signal Processing","Statistical Signal Processing","Digital VLSI Design","Analaog CMOS Design","Digital Communications","Communication Networks","Linear Systems","Introduction to Robotics","RF Circuit Design","Antennas and Propagation","Embedded Systems"];

          for(i=0;i<opt.length;i++)
            {
              document.write("<option>"+opt[i]+"</option>");
            }
          </script>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Preference 3* </label>
      <div class="col-sm-4">
        <select class="form-control">
          <option>--------</option>
          <script>
            var opt=["Advanced Signal Processing","Statistical Signal Processing","Digital VLSI Design","Analaog CMOS Design","Digital Communications","Communication Networks","Linear Systems","Introduction to Robotics","RF Circuit Design","Antennas and Propagation","Embedded Systems"];

            for(i=0;i<opt.length;i++)
            {
              document.write("<option>"+opt[i]+"</option>");
            }
          </script>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Preference 4 </label>
      <div class="col-sm-4">
        <select class="form-control">
          <option>--------</option>
          <script>
            var opt=["Advanced Signal Processing","Statistical Signal Processing","Digital VLSI Design","Analaog CMOS Design","Digital Communications","Communication Networks","Linear Systems","Introduction to Robotics","RF Circuit Design","Antennas and Propagation","Embedded Systems"];

            for(i=0;i<opt.length;i++)
            {
              document.write("<option>"+opt[i]+"</option>");
            }
          </script>
        </select>
      </div>
    </div>
</div>
<div class="form-group">
  <div class="checkbox col-sm-4">
        <label><input type="checkbox" id="chk2">Have you completed your Post Graduation?  </label>
  </div>
</div>
<div id="chkDiv2" style="display:none">
  <h3>Post Graduation Information</h3>
  <hr>
  <div class="form-group">
      <label class="control-label col-sm-2" >Name of College</label>
      <div class="col-sm-4">
        <input type="text" class="form-control">
      </div>
  </div>
  <div class="form-group">
   <label class="control-label col-sm-2" >City</label>
    <div class="col-sm-4">
      <input type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
  <label class="control-label col-sm-2" >State</label>
  <div class="col-sm-4">
    <select class="form-control">
      <script>
        var state=["Arunachal Pradesh","Assam","Bihar","J&K","Rajasthan","Uttar Pradesh","Punjab","Himachal Pradesh","Uttrakhand","Harayana","Madhya Pradesh","West Bengal","Chattisgarh","Tamil Nadu","Nagaland","Manipur","Mizoram","Tripura","Telangana","Kerala","Karantaka","Gujarat","Maharashtra","Delhi","Jharkhand","Anadaman & Nicobar Islands","Daman and Diu","Pondicherry","Sikkim","Orissa","Dadar and Nagar Haveli","Goa","Chandigarh","Meghalya","Other"];
        state.sort();
        var i;
        for(i=0;i<state.length;i++)
        {
          document.write("<option>"+state[i]+"</option>");
        }
      </script>
    </select>
  </div>
  </div>
  <div class="form-group">
     <label class="control-label col-sm-2" >Department/Discipline</label>
      <div class="col-sm-4">
        <input type="text" class="form-control">
      </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >Degree</label>
      <div class="col-sm-4">
        <input type="text" class="form-control">
      </div>
  </div>
  <div class="form-group">
     <label class="control-label col-sm-2" >Thesis Title</label>
      <div class="col-sm-4">
        <input type="text" class="form-control">
      </div>
  </div>
  <div class="form-group">
     <label class="control-label col-sm-2" >Year of Graduation*</label>
      <div class="col-sm-4">
        <select class="form-control">
          <script>
            var i;
            for(i=2015;i>=1951;i--)
            {
              document.write("<option>"+i+"</option>");
            }
          </script>
        </select>
      </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >CGPA or Marks*</label>
      <div class="col-sm-4">
        <div class="radio">
            <label><input type="radio">CGPA</label><br>
        </div>
        <input type="number" class="form-control">/<select class="form-control"><option>4</option><option>10</option></select><br>
        <div class="radio">
          <label><input type="radio">Marks(%)</label><br>
          <input type="number" class="form-control" min="0.0" max="100.0">
        </div>
      </div>
  </div>
</div>
<div class="form-group">
    <div class="checkbox col-sm-4">
          <label><input type="checkbox" id="chk3">Other Academic Degrees?  </label>
    </div>
</div>
<div id="chkDiv3" style="display:none">
    <h3>Other Academic degrees</h3>
    <hr>
    <div class="form-group">
      <label class="control-label col-sm-2" >Exam Name</label>
      <div class="col-sm-4">
        <input type="text" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Subject</label>
      <div class="col-sm-4">
        <input type="text" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Year*</label>
      <div class="col-sm-4">
        <select class="form-control">
          <script>
            var i;
            for(i=2015;i>=1951;i--)
            {
              document.write("<option>"+i+"</option>");
            }
          </script>
        </select>
      </div>
    </div>
    <div class="form-group">
       <label class="control-label col-sm-2" >Score</label>
        <div class="col-sm-4">
          <input type="number" class="form-control">
        </div>
    </div>
    <div class="form-group">
       <label class="control-label col-sm-2" >Rank</label>
        <div class="col-sm-4">
          <input type="number" class="form-control">
        </div>
    </div>
</div>
<div class="form-group">
  <div class="checkbox col-sm-4">
      <label><input type="checkbox" id="chk4">Taken Gate Exam?  </label>
  </div>
</div>
<div  id="chkDiv4" style="display:none" class="form-group">
  <h3>Gate</h3><hr>
  <div class="form-group">
    <label class="control-label col-sm-2" >Area*</label>
    <div class="col-sm-4">
      <input type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >Year of Graduation*</label>
      <div class="col-sm-4">
        <select class="form-control">
          <script>
            var i;
            for(i=2015;i>=1951;i--)
            {
              document.write("<option>"+i+"</option>");
            }
          </script>
        </select>
      </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >Marks</label>
      <div class="col-sm-4">
        <input type="number" class="form-control" max="100" min="0">
      </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >Score</label>
      <div class="col-sm-4">
        <input type="number" class="form-control" max="100" min="0">
      </div>
  </div>
  <div class="form-group">
      <label class="control-label col-sm-2" >Rank</label>
      <div class="col-sm-4">
        <input type="number" class="form-control" max="100" min="0">
      </div>
  </div>
</div>
<div>
   <h3>Achivements,CV and other info</h3><hr>
    <div class="form-group">
      <label class="control-label col-sm-2" >Achievements (Other information like ranks, medals etc.)</label>
      <div class="col-sm-4">
        <input type="text" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >CV/Resume*</label>
      <div class="col-sm-4">
        <button type="button">browse</button>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Statement of Purpose*</label>
      <div class="col-sm-4">
        <button type="button">browse</button>
    </div>
</div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
</div>
</form>