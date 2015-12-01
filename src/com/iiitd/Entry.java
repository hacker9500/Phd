package com.iiitd;
/* @author Parikshit_Diwan_2014074 @author Shubham_Goswami_2014100*/
import org.w3c.dom.Element;

/* @author Shubham_Goswami_2014100 @author Parikshit_Diwan_2014074*/

public class Entry {
	public String gUniversity,pgUniversity,xPercent,xiiPercent,gPercent,pgPercent,gateScore;
	public String stream,gDegree,pgDegree,xBoard,xiiBoard,gDepartment,pgDepartment,gState,pgState;
	public String email,name,enrollmentNumber,dated;
	public String dob;
	public String category;
	public Element e;
	public String gender,disabled;
	public String fileT;
	
	public String getFileT() {
		return fileT;
	}

	public void setFileT(String fileT) {
		this.fileT = fileT;
	}

	public Entry(){
		gender = "";
		disabled = "";
		gUniversity = "";
		pgUniversity = "";
		xPercent = "";
		xiiPercent = "";
		gPercent = "";
		pgPercent = "";
		gateScore = "";
		stream = "";
		gDegree = "";
		pgDegree = "";
		xBoard = "";
		xiiBoard = "";
		gDepartment = "";
		pgDepartment = "";
		gState = "";
		pgState = "";
		email = "";
		name = "";
		enrollmentNumber = "";
		dob = "";
		category = "";
		fileT = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}
}
