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
		String marksField = null;
		String cgpaField = null;
		String chk1 = null;
		String chk2 = null;
		String chk3 = null;
		String chk4 = null;
		String phdMARKS = null;
		String phdCGPA = null;
		try{
			xBoard = req.getParameter("xBoard");
			xMarks = req.getParameter("xMarks");
			xYear = req.getParameter("xYear");
			xiiBoard = req.getParameter("xiiBoard");
			xiiMarks = req.getParameter("xiiMarks");
			xiiYear = req.getParameter("xiiYear");
			gradDegree = req.getParameter("gradDegree");
			gradDepartment = req.getParameter("gradDepartment");
			gCollege = req.getParameter("gCollege");
			gUniversity = req.getParameter("gUniversity");
			gCity = req.getParameter("gCity");
			gState = req.getParameter("gState");
			gYear = req.getParameter("gYear");
			marksField = req.getParameter("Marks");
			cgpaField = req.getParameter("CGPA");
			// Applying for ECE
			if(req.getParameterValues("chk1") == null){
				chk1 = req.getParameterValues("chk1")[0];
				ecePref1 = req.getParameter("ecePref1");
				ecePref2 = req.getParameter("ecePref2");
				ecePref3 = req.getParameter("ecePref3");
				ecePref4 = req.getParameter("ecePref4");
			}
			if(req.getParameterValues("chk2") == null){
				chk2 = req.getParameterValues("chk2")[0];
				phdCollege  = req.getParameter("phdCollege");
				phdCity = req.getParameter("phdCity");
				phdState = req.getParameter("phdState");
				phdDepartment = req.getParameter("phdDepartment");
				phdDegree = req.getParameter("phdDegree");
				phdTitle = req.getParameter("phdTitle");
				phdYear = req.getParameter("phdYear");
				phdMarks = req.getParameter("phdMarks");
				
			}
			if(req.getParameterValues("chk3") == null){
				chk3 = req.getParameterValues("chk3")[0];
				examName = req.getParameter("examName");
				examSubject = req.getParameter("examSubject");
				examYear = req.getParameter("examYear");
				examScore = req.getParameter("examScore");
				examRank = req.getParameter("examRank");
			}
			if(req.getParameterValues("chk4") == null){
				chk4 = req.getParameterValues("chk4")[0];
				gateArea = req.getParameter("gateArea");
				gateYear = req.getParameter("gateYear");
				gateMarks = req.getParameter("gateMarks");
				gateScore = req.getParameter("gateScore");
				gateRank = req.getParameter("gateRank");
			}
		}catch(Exception ex){return 1;}
		
		try{
		if(xBoard.isEmpty()||xMarks.isEmpty()||xiiBoard.isEmpty()||xiiMarks.isEmpty()||gradDegree.isEmpty()||gradDepartment.isEmpty()||gCollege.isEmpty()|| gUniversity.isEmpty()|| gCity.isEmpty())
			return 1;
		else if(gState.isEmpty()||gYear.isEmpty() || xYear.isEmpty()||xiiYear.isEmpty())
			return 1;
//		else if(cvText1.equals("No File chosen") || statePurposeTxt1.equals("No File chosen"))
//			return 1;
		else{
			try{
				try{
					if(Double.parseDouble(xMarks) > 100 || Double.parseDouble(xMarks) < 0 || Double.parseDouble(xiiMarks)>100 || Double.parseDouble(xiiMarks)<0){
						return 1;
					}
					}catch(Exception e){
						return 1;
					}
				if(chk1 != null && !chk1.isEmpty()){
					if(ecePref1.isEmpty()|| ecePref2.isEmpty()||ecePref3.isEmpty()||ecePref4.isEmpty())
						return 1;
					else if(ecePref1.equals(ecePref2)||ecePref1.equals(ecePref3)||ecePref1.equals(ecePref4)||ecePref2.equals(ecePref3)||ecePref2.equals(ecePref4)||ecePref3.equals(ecePref4))
						return 1;
					else{
						
						Element pr1,pr2,pr3,pr4;
						pr1 = doc.createElement("ECEPref1");
						pr2 = doc.createElement("ECEPref2");
						pr3 = doc.createElement("ECEPref3");
						pr4 = doc.createElement("ECEPref4");
						
						pr1.setTextContent(ecePref1);
						pr2.setTextContent(ecePref2);
						pr3.setTextContent(ecePref3);
						pr4.setTextContent(ecePref4);
						
						toadd.appendChild(pr1);
						toadd.appendChild(pr2);
						toadd.appendChild(pr3);
						toadd.appendChild(pr4);
					}
				}
				if(chk2 != null && !chk2.isEmpty()){
					if(phdCollege.isEmpty()||phdCity.isEmpty()||phdDepartment.isEmpty()||phdDegree.isEmpty()||phdTitle.isEmpty())
						return 1;
					else if(phdState.isEmpty()||phdYear.isEmpty())
						return 1;
					else{
						try{
							Element pname,pcity,pdep,pdeg,pth,pmrks,pstate,pyear;
							pname = doc.createElement("pgName");
							pcity = doc.createElement("pgCity");
							pdep = doc.createElement("pgDepartment");
							pdeg = doc.createElement("pgDegree");
							pth = doc.createElement("pgThesis");
							pmrks = doc.createElement("pgMarks");
							pstate = doc.createElement("pgState");
							pyear = doc.createElement("pgYear");
							
							pname.setTextContent(phdCollege);
							pcity.setTextContent(phdCity);
							pdep.setTextContent(phdDepartment);
							pdeg.setTextContent(phdDegree);
							pth.setTextContent(phdTitle);
							String phdRadio = req.getParameter("phdRadio");
							if(phdRadio.equals("MARKS"))
								pmrks.setTextContent(String.valueOf(Double.parseDouble(req.getParameter("phdMARKS"))/Double.parseDouble(req.getParameter("phdFactor").toString())));
							else
								pmrks.setTextContent(req.getParameter("phdCGPA"));
							pstate.setTextContent(phdState);
							pyear.setTextContent(phdYear);
							
							toadd.appendChild(pname);
							toadd.appendChild(pcity);
							toadd.appendChild(pdep);
							toadd.appendChild(pdeg);
							toadd.appendChild(pth);
							toadd.appendChild(pmrks);
							toadd.appendChild(pstate);
							toadd.appendChild(pyear);
						}catch(Exception e){
							return 1;
						}
					}
				}
				if(chk3 != null && !chk3.isEmpty()){
					if(examYear.toString().isEmpty()||examName.isEmpty()||examSubject.isEmpty()||examScore.isEmpty()||examRank.isEmpty())
						return 1;
					else{
						Element oexam,osub,oscore,orank,oyear;
						oexam = doc.createElement("otherExam");
						osub = doc.createElement("otherSubject");
						oscore = doc.createElement("otherScore");
						orank = doc.createElement("otherRank");
						oyear = doc.createElement("otherYear");
						
						oexam.setTextContent(examName);
						osub.setTextContent(examSubject);
						oscore.setTextContent(examScore);
						orank.setTextContent(examRank);
						oyear.setTextContent(examYear);
						
						toadd.appendChild(oexam);
						toadd.appendChild(osub);
						toadd.appendChild(oscore);
						toadd.appendChild(orank);
						toadd.appendChild(oyear);
					}
				}
				if(chk1 != null && !chk1.isEmpty()){
					if(gateYear.isEmpty()||gateArea.isEmpty()||gateMarks.isEmpty()||gateScore.isEmpty()||gateRank.isEmpty())
						return 1;
					else{
						try{
							if(Double.parseDouble(gateMarks)<0 || Double.parseDouble(gateMarks)>1000){
								return 1;
							}
						}catch(Exception e){
							return 1;
						}
						Element garea,gmarks,gscore,grank,gyear;
						garea = doc.createElement("gateArea");
						gmarks = doc.createElement("gateMarks");
						gscore = doc.createElement("gateScore");
						grank = doc.createElement("gateRank");
						gyear = doc.createElement("gateYear");
						garea.setTextContent(gateArea);
						gmarks.setTextContent(gateMarks);
						gscore.setTextContent(gateScore);
						grank.setTextContent(gateRank);
						gyear.setTextContent(gateYear);
						
						toadd.appendChild(garea);
						toadd.appendChild(gmarks);
						toadd.appendChild(gscore);
						toadd.appendChild(grank);
						toadd.appendChild(gyear);
						
					}
				}
//				
				
				Element xbr,xpr,xiibr,xiipr,deg,dep,cljname,uniname,coljcity,mrks,coljstate,grayear,markdiv,xpass,xiipass,cv,purpose;
				xbr = doc.createElement("xBoard");
				xpr = doc.createElement("xPercent");
				xiibr = doc.createElement("xiiBoard");
				xiipr = doc.createElement("xiiPercent");
				deg = doc.createElement("degree");
				dep = doc.createElement("department");
				cljname = doc.createElement("coljName");
				uniname = doc.createElement("universityName");
				coljcity = doc.createElement("coljCity");
				mrks = doc.createElement("degreeMarks");
				coljstate = doc.createElement("coljState");
				grayear = doc.createElement("graduationYear");
				markdiv = doc.createElement("markDiv");
				xpass = doc.createElement("xPassingYear");
				xiipass = doc.createElement("xiiPassingYear");
				cv = doc.createElement("cvPath");
				purpose = doc.createElement("purposePath");
				
				xbr.setTextContent(xBoard);
				xpr.setTextContent(xMarks);
				xiibr.setTextContent(xiiBoard);
				xiipr.setTextContent(xiiMarks);
				deg.setTextContent(gradDegree);
				dep.setTextContent(gradDepartment);
				cljname.setTextContent(gCollege);
				uniname.setTextContent(gUniversity);
				coljcity.setTextContent(gCity);
				if(req.getParameter("gCheck").equals("MARKS")){
					mrks.setTextContent(String.valueOf((Double.parseDouble(req.getParameter("MARKS"))/Double.parseDouble(req.getParameter("gFactor")))));
				}
				else{
					mrks.setTextContent(req.getParameter("CGPA"));
				}
				coljstate.setTextContent(gState);
				grayear.setTextContent(gYear);
				markdiv.setTextContent(req.getParameter("gFactor"));
				xpass.setTextContent(xYear);
				xiipass.setTextContent(xiiYear);
				
				cvPath = "hello";
				purposePath = "hello";
				
				cv.setTextContent(cvPath);
				purpose.setTextContent(purposePath);
				
				toadd.appendChild(xbr);
				toadd.appendChild(xpr);
				toadd.appendChild(xiibr);
				toadd.appendChild(xiipr);
				toadd.appendChild(deg);
				toadd.appendChild(dep);
				toadd.appendChild(cljname);
				toadd.appendChild(uniname);
				toadd.appendChild(coljcity);
				toadd.appendChild(coljstate);
				toadd.appendChild(mrks);
				toadd.appendChild(grayear);
				toadd.appendChild(markdiv);
				toadd.appendChild(xpass);
				toadd.appendChild(xiipass);
				toadd.appendChild(cv);
				toadd.appendChild(purpose);
				
				toadd.setAttribute("save2", "1");
				System.out.println("saved 2");
				//uploadFiles();
			}catch(Exception e){
				return 1;
			}
		}
		}catch(Exception ex1){ return 1;}
		return 0;
	}
	public static int s3(HttpServletRequest req, HttpServletResponse resp){
		//paymentMode, bankName, bankBranch, ddNo,
		if(req.getParameterValues("dd") != null && req.getParameterValues("dd")[0].equals("true")){
			Element pay = doc.createElement("pay");
			pay.setTextContent("Card payment");
			toadd.appendChild(pay);
			return 0;
		}
		else{
			bankName = req.getParameter("bankName");
			bankBranch = req.getParameter("bankBranch");
			ddNo = req.getParameter("ddNumber");
			if(bankName.isEmpty()||bankBranch.isEmpty()|| ddNo.isEmpty())
				return 1;
			else{
				Element pay = doc.createElement("pay");
				pay.setTextContent("DD Details "+bankName+" "+bankBranch+" "+ddNo);
				toadd.appendChild(pay);
				toadd.setAttribute("payment", "1");
				System.out.println("paid");
				return 0;
			}
		}
	}
	public static int s4(HttpServletRequest req, HttpServletResponse resp){
		String feed1 = req.getParameter("feed1");
		try{
			Element hear = doc.createElement("hear");
			hear.setTextContent(feed1);
			toadd.appendChild(hear);
		}catch(Exception e){return 1;}
		Element interested = doc.createElement("interested");
		toadd.appendChild(interested);
		for(String s: req.getParameterValues("feed2")){
			Element e = doc.createElement("in");
			e.setTextContent(s);
			interested.appendChild(e);
		}
		System.out.println("ok submitted");
		return 0;
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
}
