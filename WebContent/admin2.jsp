<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="form-horizontal" role="form">
            <div class="form-group">
                <label class="control-label col-sm-2" >PhD Stream</label>
                <div class="col-sm-4">
                     <input type="text" name="stream">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Graduation Degree</label>
                <div class="col-sm-4">
                     <input type="text" name="gradDegree">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Post Graduation Degree</label>
                <div class="col-sm-4">
                     <input type="text" name="pgDegree">
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
                     <input type="text" name="gradDepartment">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Department(Post Graduation)</label>
                <div class="col-sm-4">
                     <input type="text" name="pgDepartment">
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
                     <input type="text" name="gState">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >State(Post Graduation from)</label>
                <div class="col-sm-4">
                     <input type="text" name="pgState">
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
                <label class="control-label col-sm-2" >Graduation Marks Percentage</label>
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
                <label class="control-label col-sm-2" >Post Graduation Marks Percentage</label>
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