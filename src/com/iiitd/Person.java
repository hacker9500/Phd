package com.iiitd;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import javafx.scene.control.RadioButton;

public class Person {
	static String 
	//tab1
	email, name, enroll,areaCorrespondence, contact, stream, phdPref1, phdPref2,
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
			fXmlFile = new File("/Users/ShubhamGoswami/Desktop/temp.xml");
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			}catch(Exception e){System.out.println("xml ni khuli");}
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
	public static int s1(HttpServletRequest req, HttpServletResponse resp){
		try{
		//email = req.getSession().getAttribute("email").toString();
		name = req.getParameter("name");
		areaCorrespondence = req.getParameter("areaCorrespondence");
		contact = req.getParameter("contact");
		stream = req.getParameter("phdpref");
		System.out.println();
		phdPref1 = req.getParameter("phdpref1");
		phdPref2 = req.getParameter("phdpref2");
		phdPref3 = req.getParameter("phdpref3");
		gender = req.getParameter("gender");
		category = req.getParameter("category");
		disabled = req.getParameter("pod");
		dob = req.getParameter("dob");
		pow = req.getParameter("cow");
		fatherName = req.getParameter("fatherName");
		country = req.getParameter("country");
		permanentAddress = req.getParameter("permanentAddress");
		pinCode = req.getParameter("pinCode");
		} catch(Exception ex){ 
			System.out.println(ex.toString());
			return 1; }
		
		
		System.out.println(email);
		System.out.println(name);
		System.out.println(areaCorrespondence);
		System.out.println(contact);
		System.out.println(stream);
		System.out.println(phdPref1);
		System.out.println(phdPref2);
		System.out.println(phdPref3);
		System.out.println(gender);
		System.out.println(category);
		System.out.println(disabled);
		System.out.println(dob);
		System.out.println(pow);
		System.out.println(fatherName);
		System.out.println(country);
		System.out.println(permanentAddress);
		System.out.println(pinCode);
		
		// validating fields from backend
		try{
			email = "hello";
			enroll = "1234";
		if(email.isEmpty() || name.isEmpty() || contact.isEmpty())
			return 1;
		else if(fatherName.isEmpty()||country.isEmpty()||pinCode.isEmpty()||areaCorrespondence.isEmpty()|| permanentAddress.isEmpty())
			return 1;
		else if(phdPref1.isEmpty() || phdPref2.isEmpty() || phdPref3.isEmpty() || phdPref1.equals(phdPref2) ||phdPref1.equals(phdPref3)||phdPref2.equals(phdPref3)){
			return 1;
		}
		else{
				 if(gender.isEmpty() || category.isEmpty() || pow.isEmpty() || disabled.isEmpty() || stream.isEmpty())
						return 1;
					 if(dob.isEmpty())
					 {
						 return 1;
					 }
					 Element dated,db,mail,nam,eNo,mob,father,cntry,pin,addressc,addressp,arpref1,arpref2,arpref3,gen,cat,wd,strm,dis;
					 nam = doc.createElement("name");
					 eNo = doc.createElement("eno");
					 father = doc.createElement("fatherName");
					 cntry = doc.createElement("country");
					 pin = doc.createElement("pinCode");
					 addressp = doc.createElement("addressPermanent");
					 addressc = doc.createElement("addressCorrespondence");
					 arpref1 = doc.createElement("areaPref1");
					 arpref2 = doc.createElement("areaPref2");
					 arpref3 = doc.createElement("areaPref3");
					 gen = doc.createElement("gender");
					 cat = doc.createElement("category");
					 wd = doc.createElement("wod");
					 strm = doc.createElement("stream");
					 dis = doc.createElement("disabled");
					 mail = doc.createElement("email");
					 mob = doc.createElement("mobile");
					 db = doc.createElement("dob");
					 dated = doc.createElement("dated");
					 
					 nam.setTextContent(name);
					 mail.setTextContent(email);
					 eNo.setTextContent(enroll);
					 father.setTextContent(fatherName);
					 cntry.setTextContent(country);
					 pin.setTextContent(pinCode);
					 addressc.setTextContent(areaCorrespondence);
					 addressp.setTextContent(permanentAddress);
					 arpref1.setTextContent(phdPref1);
					 arpref2.setTextContent(phdPref2);
					 arpref3.setTextContent(phdPref3);
					 gen.setTextContent(gender);
					 cat.setTextContent(category);
					 wd.setTextContent(pow);
					 strm.setTextContent(stream);
					 dis.setTextContent(disabled);
					 mob.setTextContent(contact);
					 db.setTextContent(dob);
					 
					 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						Calendar cal = Calendar.getInstance();
						dated.setTextContent(dateFormat.format(cal.getTime()));
					 
					 toadd.appendChild(mail);
					 toadd.appendChild(db);
					 toadd.appendChild(nam);
					 toadd.appendChild(eNo);
					 toadd.appendChild(mob);
					 toadd.appendChild(father);
					 toadd.appendChild(cntry);
					 toadd.appendChild(pin);
					 toadd.appendChild(addressc);
					 toadd.appendChild(addressp);
					 toadd.appendChild(arpref1);
					 toadd.appendChild(arpref2);
					 toadd.appendChild(arpref3);
					 toadd.appendChild(gen);
					 toadd.appendChild(cat);
					 toadd.appendChild(wd);
					 toadd.appendChild(strm);
					 toadd.appendChild(dis);
					 toadd.appendChild(dated);
					 System.out.println("saved 1");
					 return 0;
		}
			}catch(Exception ex){
				System.out.println(ex.toString());
				return 1;
			}
	}
	public static int s2(HttpServletRequest req, HttpServletResponse resp){
		try{
			xBoard = req.getParameter("xBoard");
			xMarks = req.getParameter("xMarks");
			xYear = req.getParameter("xYear");
			xiiBoard = req.getParameter("xiiBoard");
			xiiMarks = req.getParameter("xiiMarks");
			xiiYear = req.getParameter("xiiYear");
			return 0;
		}catch(Exception ex){return 1;}
	}
	public static int s3(HttpServletRequest req, HttpServletResponse resp){
		return 1;
	}
	public static int s4(HttpServletRequest req, HttpServletResponse resp){
		return 1;
	}
	
	public static void save1(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement("hello");
		if(toadd.getAttribute("save1").equals("1") || s1(req,resp) == 1){
			resp.setStatus(405);
			return;
		}
		toadd.setAttribute("save1", "1");
		saveData();
	}
	public static void save2(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(toadd.getAttribute("save2").equals("1") || s2(req,resp) == 1){
			resp.setStatus(406);
			return;
		}
		toadd.setAttribute("save2", "1");
		saveData();
	}
	public static void save3(HttpServletRequest req, HttpServletResponse resp){
		//Payment
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(toadd.getAttribute("payment").equals("1") || s3(req,resp) == 1){
			resp.setStatus(407);
			return;
		}
		toadd.setAttribute("payment", "1");
		saveData();
	}
	public  static void save4(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(toadd.getAttribute("feedback").equals("1") || s4(req,resp) == 1){
			resp.setStatus(408);
			return;
		}
		toadd.setAttribute("feedback", "1");
		saveData();
	}
	public static void submit(HttpServletRequest req, HttpServletResponse resp){
		Element e = getElement(req.getSession().getAttribute("email").toString());
		if(s1(req,resp) == 1){
			resp.setStatus(405);
		}
		else if(s2(req,resp) == 1){
			resp.setStatus(406);
		}
		else if(s3(req,resp) == 1){
			resp.setStatus(407);
		}
		else if(s4(req,resp) == 1){
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
			StreamResult result = new StreamResult(new File("/Users/ShubhamGoswami/Desktop/temp.xml"));
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
