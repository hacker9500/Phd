<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="form-horizontal" role="form">
            <div class="form-group">
                <label class="control-label col-sm-2" >Email</label>
                <div class="col-sm-4">
                     <input type="email" class="form-control" name="email">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Name</label>
                <div class="col-sm-4">
                     <input type="text" class="form-control" name="name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Enrollment Number</label>
                <div class="col-sm-4">
                     <input type="text" class="form-control" name="enroll">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Category</label>
                <div class="col-sm-4">
                     <select class="form-control" name="category">
                        <script>
                            var cate=["All","General","SC","ST","OBC"];
                            var i;
                            for(i=0;i<cate.length;i++)
                            {
                                document.write("<option>"+cate[i]+"</option>");
                            }
                        </script>
                     </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Gender</label>
                <div class="col-sm-4">
                    <div class="radio" name="gender" value="MALE">
                        <label><input type="radio">Male</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="gender" value="FEMALE ">Female</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Physically Disabled</label>
                <div class="col-sm-4">
                    <div class="radio">
                        <label><input type="radio" name="disabled" value="Yes">Yes</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio"  name="disabled" value="No">No</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Date of Birth</label>
                <div class="col-sm-4">
                    <div class="radio">
                        <label><input type="radio" name="dobRadio" value="before">Before</label>
                        <label><input type="radio" name="dobRadio" value="on">On</label>
                        <label><input type="radio" name="dobRadio" value="after">After</label>
                    </div>
                    <br>
                    <div class="date">
                        <input type="date" name="dob">
                    </div>
                </div>
            </div>
        </div>