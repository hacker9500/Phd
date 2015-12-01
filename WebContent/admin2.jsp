<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="form-horizontal" role="form">
            <div class="form-group">
                <label class="control-label col-sm-2" >PhD Stream</label>
                <div class="col-sm-4">
                     <select type="text" name="stream">
                     <option></option>
                     <option>Computer Science</option>
                     <option>Electronics and Communication</option>
                     <option>Computational Biology</option>
                     </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Graduation Degree</label>
                <div class="col-sm-4">
                     <select type="text" name="gradDegree">
                     <option></option>
                     <option>B.Tech</option>
                     <option>B.E</option>
                     </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Post Graduation Degree</label>
                <div class="col-sm-4">
                     <select type="text" name="pgDegree">
                     <option></option>
                     <option>M.Tech</option>
                     <option>M.S</option>
                     </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Class X Board</label>
                <div class="col-sm-4">
                     <input type="text" name="xBoard">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Class XII Board</label>
                <div class="col-sm-4">
                     <input type="text" name="xiiBoard">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Department(Graduation)</label>
                <div class="col-sm-4">
                     <select type="text" name="gradDepartment">
                     <option></option>
                     <option>Computer Science</option>
                     <option>Electronics and Communication</option>
                     <option>Computational Biology</option>
                     <option>Information Technology</option>
                     </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Department(Post Graduation)</label>
                <div class="col-sm-4">
                     <select type="text" name="pgDepartment">
                     <option></option>
                     <option>Computer Science</option>
                     <option>Electronics and Communication</option>
                     <option>Computational Biology</option>
                     <option>Information Technology</option>
                     </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >University(Graduation)</label>
                <div class="col-sm-4">
                     <input type="text" class="form-control" name="gUniversity">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >University(Post Graduation)</label>
                <div class="col-sm-4">
                     <input type="text" class="form-control" name="pgUniversity">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >State(Graduation from)</label>
                <div class="col-sm-4">
                     <select type="text" name="gState">
                     <option></option>
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
                <label class="control-label col-sm-2" >State(Post Graduation from)</label>
                <div class="col-sm-4">
                     <select type="text" name="pgState">
                     <option></option>
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
                <label class="control-label col-sm-2" >Class X Board Percentage</label>
                <div class="col-sm-4">
                     <div class="checkbox">
                        <label><input type="checkbox" name="xCheck" value="gt">Greater than</label>
                        <label><input type="checkbox" name="xCheck" value="eq">Equals</label>
                        <label><input type="checkbox" name="xCheck" value="lt">Less than</label>
                        <input type="number" min="0.0" max="100.0" name="xMarks">
                     </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Class XII Board Percentage</label>
                <div class="col-sm-4">
                     <div class="checkbox">
                        <label><input type="checkbox"  name="xiiCheck" value="gt">Greater than</label>
                        <label><input type="checkbox"  name="xiiCheck" value="eq">Equals</label>
                        <label><input type="checkbox"  name="xiiCheck" value="lt">Less than</label>
                        <input type="number" min="0.0" max="100.0" name="xiiMarks">
                     </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Graduation CGPA</label>
                <div class="col-sm-4">
                     <div class="checkbox">
                        <label><input type="checkbox"  name="gCheck" value="gt">Greater than</label>
                        <label><input type="checkbox" name="gCheck" value="eq">Equals</label>
                        <label><input type="checkbox" name="gCheck" value="lt">Less than</label>
                        <input type="number" min="0.0" max="100.0" name="gMarks">
                     </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Post Graduation CGPA</label>
                <div class="col-sm-4">
                     <div class="checkbox">
                        <label><input type="checkbox" name="pgCheck" value="gt">Greater than</label>
                        <label><input type="checkbox" name="pgCheck" value="eq">Equals</label>
                        <label><input type="checkbox" name="pgCheck" value="lt">Less than</label>
                        <input type="number" min="0.0" max="100.0" name="pgMarks">
                     </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Gate score</label>
                <div class="col-sm-4">
                     <div class="checkbox">
                        <label><input type="checkbox" name="gateCheck" value="gt">Greater than</label>
                        <label><input type="checkbox" name="gateCheck" value="eq">Equals</label>
                        <label><input type="checkbox" name="gateCheck" value="lt">Less than</label>
                        <input type="number" min="0" name="gateScore">
                     </div>
                </div>
            </div>
        </div>