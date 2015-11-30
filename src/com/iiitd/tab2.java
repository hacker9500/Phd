package com.iiitd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class tab2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xBoard, xMarks, xYear, xiiBoard, xiiMarks, xiiYear,
		gradDegree, gradDepartment, gCollege, gUniversity, gCity, gState, gYear, gMarks,
		//if ECE PHD Applied
		ecePref1, ecePref2, ecePref3, ecePref4,
		// if post graduation completed
		phdCollege, phdCity, phdState, phdDepartment, phdDegree, phdTitle,phdYear, phdMarks,
		//other Academic Degrees
		examName, examSubject, examYear, examScore, examRank,
		//GATE Exam taken
		gateArea, gateYear, gateMarks, gateScore, gateRank,
		// achivements and attachments
		otherInformation;
		;
	}

}
