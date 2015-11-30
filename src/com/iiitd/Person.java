package com.iiitd;

import java.io.File;

import javax.servlet.http.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Person {
	static String 
	//tab1
	email, name, enroll, areaCorrespondence, contact, stream, phdPref1, phdPref2,
	phdPref3, gender, category, disabled, dob,pow, fatherName, country, permanentAddress, pinCode,
	
	//tab2
	xBoard, xMarks, xYear, xiiBoard, xiiMarks, xiiYear,
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
	otherInformation, cvPath, purposePath,
	
	//tab3
	paymentMode, bankName, bankBranch, ddNo,
	
	//tab4
	hearIIITD;
	static String[] whyIIITD;
	
	//xml file Structure
	static File fXmlFile;
	static DocumentBuilderFactory docFactory;
	static DocumentBuilder docBuilder;
	static Document doc;
	static Element toadd,data;
	
	public static Element getElement(String email){
		
		try{
			fXmlFile = new File("./src/temp.xml");
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			}catch(Exception e){}
		// found the entry with the same email if found
		NodeList nl = doc.getElementsByTagName("data");
		data = (Element)nl.item(0);
		Element e = null;
		NodeList tags = data.getElementsByTagName("entry");
		for(int i=0;i<tags.getLength();i++)
		{
			Element temp = (Element)tags.item(i);
			if(temp.getAttribute("email").equals(email))
			{
				e = temp;
				break;
			}
		}
		// if not found by email create a new element
		if(e==null){
			e = doc.createElement("entry");
			e.setAttribute("email", email);
			e.setAttribute("save1", "0");
			e.setAttribute("save2", "0");
			e.setAttribute("payment", "0");
			e.setAttribute("feedback", "0");
			e.setAttribute("submit", "0");
			e.setAttribute("enroll","0");
		}
		
		toadd = e;
		return toadd;
	}

	//these methods return 1 whe there is an error
	public static int s1(HttpServletRequest req, HttpServletResponse resp, Element e){
		return 1;
	}
	public static int s2(HttpServletRequest req, HttpServletResponse resp, Element e){
		return 1;
	}
	public static int s3(HttpServletRequest req, HttpServletResponse resp, Element e){
		return 1;
	}
	public static int s4(HttpServletRequest req, HttpServletResponse resp, Element e){
		return 1;
	}
	
	public static void save1(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(toadd.getAttribute("save1").equals("1") || s1(req,resp,e) == 1){
			resp.setStatus(405);
			return;
		}
		toadd.setAttribute("save1", "1");
		saveData();
	}
	public static void save2(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(toadd.getAttribute("save2").equals("1") || s2(req,resp,e) == 1){
			resp.setStatus(406);
			return;
		}
		toadd.setAttribute("save2", "1");
		saveData();
	}
	public static void save3(HttpServletRequest req, HttpServletResponse resp){
		//Payment
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(toadd.getAttribute("payment").equals("1") || s3(req,resp,e) == 1){
			resp.setStatus(407);
			return;
		}
		toadd.setAttribute("payment", "1");
		saveData();
	}
	public  static void save4(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(toadd.getAttribute("feedback").equals("1") || s4(req,resp,e) == 1){
			resp.setStatus(408);
			return;
		}
		toadd.setAttribute("feedback", "1");
		saveData();
	}
	public static void submit(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(s1(req,resp,e) == 1){
			resp.setStatus(405);
		}
		else if(s2(req,resp,e) == 1){
			resp.setStatus(406);
		}
		else if(s3(req,resp,e) == 1){
			resp.setStatus(407);
		}
		else if(s4(req,resp,e) == 1){
			resp.setStatus(408);
		}
		else{
			e.setAttribute("submit", "1");
			saveData();
		}
	}
	public static void saveData(){
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try{
			data.appendChild(toadd);
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("./src/temp.xml"));
			transformer.transform(source, result);
			System.out.println("File saved!");
			}catch(Exception e){
				System.out.println("omg!!!");
			}
	}
	
	public static int initS1(HttpServletRequest req){
		return 1;
	}
	public static int initS2(HttpServletRequest req){
		return 1;
	}
	public static int initS3(HttpServletRequest req){
		return 1;
	}
	public static int initS4(HttpServletRequest req){
		return 1;
	}
}
