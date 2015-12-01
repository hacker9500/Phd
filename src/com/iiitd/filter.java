package com.iiitd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;;

public class filter extends HttpServlet{

	// Data structures used
	ArrayList<Entry> list;
	ArrayList<Entry> finalList;
	ArrayList<Entry> rmList;
	HashMap<String,Integer> dates;
	
	//tabs Data
	String gUniversity,pgUniversity,xPercent,xiiPercent,gPercent,pgPercent,gateScore,
	stream,gDegree,pgDegree,xBoard,xiiBoard,gDepartment,pgDepartment,gState,pgState,
	xgt,xlt,xeq,xiigt,xiilt,xiieq,glt,geq,ggt,pglt,pgeq,pggt,gategt,gatelt,gateeq,	
	//tab1
	email,name,enrollmentNumber,dob, category, gender,disabled,dobRadio,
	//tab3
	dateFrom,dateTo;
	
	private int InitStructures(HttpServletRequest req){
		try{
			File fXmlFile;
			DocumentBuilderFactory docFactory;
			DocumentBuilder docBuilder;
			Document doc;
			fXmlFile = new File("./src/temp.xml");
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nl1 = doc.getElementsByTagName("entry");
			int indx = 0;
			for(indx = 0;indx<nl1.getLength();indx++){
				Element e1= (Element)nl1.item(indx);
				if(e1.getAttribute("submit").equals("1"))
				{
					Entry tmp = new Entry();
					tmp.e = e1;
					tmp.name = e1.getElementsByTagName("name").item(0).getTextContent();
					tmp.category = e1.getElementsByTagName("category").item(0).getTextContent();
					tmp.dob = e1.getElementsByTagName("dob").item(0).getTextContent();
					tmp.email = e1.getElementsByTagName("email").item(0).getTextContent();
					tmp.enrollmentNumber = e1.getElementsByTagName("eno").item(0).getTextContent();
					try{
					tmp.gateScore = e1.getElementsByTagName("gateScore").item(0).getTextContent();}catch(Exception e){
						tmp.gateScore ="";
					}
					tmp.gDegree = e1.getElementsByTagName("degree").item(0).getTextContent();
					tmp.gDepartment = e1.getElementsByTagName("department").item(0).getTextContent();
					tmp.gPercent = e1.getElementsByTagName("degreeMarks").item(0).getTextContent();
					tmp.gState = e1.getElementsByTagName("coljState").item(0).getTextContent();
					tmp.gUniversity = e1.getElementsByTagName("universityName").item(0).getTextContent();
					try{
					tmp.pgDegree = e1.getElementsByTagName("pgDegree").item(0).getTextContent();
					tmp.pgDepartment = e1.getElementsByTagName("pgDepartment").item(0).getTextContent();
					tmp.pgPercent = e1.getElementsByTagName("pgMarks").item(0).getTextContent();
					tmp.pgState = e1.getElementsByTagName("pgState").item(0).getTextContent();
					tmp.pgUniversity = e1.getElementsByTagName("pgName").item(0).getTextContent();
					}catch(Exception e){
						tmp.pgDegree = "";
						tmp.pgDepartment = "";
						tmp.pgPercent = "";
						tmp.pgState = "";
						tmp.pgUniversity = "";
					}
					tmp.stream = e1.getElementsByTagName("stream").item(0).getTextContent();
					tmp.xBoard = e1.getElementsByTagName("xBoard").item(0).getTextContent();
					tmp.xiiBoard = e1.getElementsByTagName("xiiBoard").item(0).getTextContent();
					tmp.xiiPercent = e1.getElementsByTagName("xiiPercent").item(0).getTextContent();
					tmp.xPercent = e1.getElementsByTagName("xPercent").item(0).getTextContent();
					tmp.dated = e1.getElementsByTagName("dated").item(0).getTextContent();
					tmp.gender = e1.getElementsByTagName("gender").item(0).getTextContent();
					tmp.disabled = e1.getElementsByTagName("disabled").item(0).getTextContent();
					
					tmp.fileT = e1.getElementsByTagName("fileT").item(0).getTextContent();
					list.add(tmp);
				}
			}
				return 0;
			}catch(Exception e){
				System.out.println("oops");
				return 1;
			}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("coming post");
		
		//implement filtration here and serve table
		if(InitStructures(req) == 1){
			resp.setStatus(404);
			return;
		}
		if(InitVariables(req) == 1){
			resp.setStatus(404);
			return;
		}
		if(filterData() == 1){
			resp.setStatus(404);
			return;
		}
		
		//serving table
		RequestDispatcher rd = req.getRequestDispatcher("table.jsp");
		
	}
	
	public int dtComp(int[] d1,int[] d2){
		//System.out.println(""+d1[0]+"-"+d1[1]+"-"+d1[2]+" "+d2[0]+"-"+d2[1]+"-"+d2[2]);
		if(d1[0]>d2[0])
			return 1;
		if(d1[0]<d2[0])
			return -1;
		if(d1[1]>d2[1])
			return 1;
		if(d1[1]<d2[1])
			return -1;
		if(d1[2]>d2[2])
			return 1;
		if(d1[2]<d2[2])
			return -1;
		return 0;
	}
	
	private int InitVariables(HttpServletRequest req){
		//Initialising to null
		gUniversity = null;
		pgUniversity = null;
		xPercent = null;
		xiiPercent = null;
		gPercent = null;
		pgPercent = null;
		gateScore = null;
		disabled = null;
		stream = null;
		gDegree = null;
		pgDegree = null;
		xBoard = null;
		gender = null;
		xiiBoard = null;
		dobRadio = null;
		gDepartment = null;
		pgDepartment = null;
		gState = null;
		pgState = null;
		xgt = null;
		xlt = null;
		xeq = null;
		xiigt = null;
		xiilt = null;
		xiieq = null;
		glt = null;
		geq = null;
		ggt = null;
		pglt = null;
		pgeq = null;
		pggt = null;
		gategt = null;
		gatelt = null;
		gateeq	 = null;
		email = null;
		name = null;
		enrollmentNumber = null;
		dob = null;
		category = null;
		dateFrom = null;
		dateTo = null;
		
		//taking data from admin.jsp
		try{
		gUniversity = req.getParameter("gUniversity");
		}catch(Exception e){}
		try{
		pgUniversity = req.getParameter("pgUniversity");
		}catch(Exception e){}
		try{
		xPercent = req.getParameter("xMarks");
		}catch(Exception e){}
		try{
		xiiPercent = req.getParameter("xiiMarks");
		}catch(Exception e){}
		try{
			dobRadio = req.getParameter("dobRadio");
		}catch(Exception e){}
		try{
		gPercent = req.getParameter("gMarks");
		}catch(Exception e){}
		try{
		pgPercent = req.getParameter("pgMarks");
		}catch(Exception e){}
		try{
		gateScore = req.getParameter("gateScore");
		}catch(Exception e){}
		try{
		stream = req.getParameter("stream");
		}catch(Exception e){}
		try{
		gDegree = req.getParameter("gradDegree");
		}catch(Exception e){}
		try{
		pgDegree = req.getParameter("pgDegree");
		}catch(Exception e){}
		try{
		xBoard = req.getParameter("xBoard");
		}catch(Exception e){}
		try{
			disabled = req.getParameter("disabled");
		}catch(Exception e){}
		try{
		xiiBoard = req.getParameter("xiiBoard");
		}catch(Exception e){}
		try{
		gDepartment = req.getParameter("gradDepartment");
		}catch(Exception e){}
		try{
		pgDepartment = req.getParameter("pgDepartment");
		}catch(Exception e){}
		try{
		gState = req.getParameter("gState");
		}catch(Exception e){}
		try{
		pgState = req.getParameter("pgState");
		}catch(Exception e){}
		try{
		email = req.getParameter("email");
		}catch(Exception e){}
		try{
		name = req.getParameter("name");
		}catch(Exception e){}
		try{
		enrollmentNumber = req.getParameter("enroll");
		}catch(Exception e){}
		try{
		dob = req.getParameter("dob");
		}catch(Exception e){}
		try{
		category = req.getParameter("category");
		}catch(Exception e){}
		try{
		dateFrom = req.getParameter("dateFrom");
		}catch(Exception e){}
		try{
		dateTo = req.getParameter("dateTo");
		}catch(Exception e){}
		try{
			gender = req.getParameter("gender");
		}catch(Exception e){}
		return 0;
	}
	
	private int filterData(){
		return 1;
	}

}
