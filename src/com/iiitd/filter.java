package com.iiitd;
/* @author Parikshit_Diwan_2014074 @author Shubham_Goswami_2014100*/
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
			list = new ArrayList<>();
			finalList = new ArrayList<>();
			rmList = new ArrayList<>();
			dates = new HashMap<String,Integer>();
			dates.put("jan", 1);
			dates.put("feb", 2);
			dates.put("mar", 3);
			dates.put("apr", 4);
			dates.put("may", 5);
			dates.put("jun", 6);
			dates.put("jul", 7);
			dates.put("aug", 8);
			dates.put("sep", 9);
			dates.put("oct", 10);
			dates.put("nov", 11);
			dates.put("dec", 12);
			File fXmlFile;
			DocumentBuilderFactory docFactory;
			DocumentBuilder docBuilder;
			Document doc;
			fXmlFile = new File("/Users/ShubhamGoswami/Desktop/tmp/temp.xml");
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nl1 = doc.getElementsByTagName("entry");
			int indx = 0;
			for(indx = 0;indx<nl1.getLength();indx++){
				//System.out.println("" + indx);
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
				System.out.println("oops "+e.toString());
				return 1;
			}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("coming post");
		
		//implement filtration here and serve table
		if(InitStructures(req) == 1){
			resp.setStatus(404);
			return;
		}
		if(InitVariables(req) == 1){
			resp.setStatus(404);
			return;
		}
		if(filterData(req) == 1){
			resp.setStatus(404);
			return;
		}
		
		//serving table
		RequestDispatcher rd = req.getRequestDispatcher("table.jsp");
		req.setAttribute("finalList", finalList);
		rd.forward(req, resp);
		
	}
	
	public int dtComp(int[] d1,int[] d2){
		//System.out.println(""+d1[0]+"-"+d1[1]+"-"+d1[2]+" "+d2[0]+"-"+d2[1]+"-"+d2[2]);
		if(d1[0]>d2[0]){
			//System.out.println(""+d1[0]+"-"+d2[0]);
			return 1;
		}
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
	
	public  void filter1(){
		for(Entry e : rmList)
			finalList.remove(e);
		rmList.clear();
	}
	
	private int filterData(HttpServletRequest req){
		//filtering
				rmList.clear();
				finalList.clear();
				for(Entry e:list)
					finalList.add(e);
				System.out.println(""+finalList.size());
				//filter name
				if(!name.isEmpty())
					for(Entry e:finalList)
						if(!e.name.toLowerCase().equals(name.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter email
				if(!email.isEmpty())
					for(Entry e:finalList)
						if(!e.email.toLowerCase().equals(email.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter enrollment no
				if(!enrollmentNumber.isEmpty())
					for(Entry e:finalList)
						if(!e.enrollmentNumber.equals(enrollmentNumber))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size()+" "+category);
				//filter category
				if(category != null && !category.isEmpty())
					for(Entry e:finalList)
						if(!e.category.toLowerCase().equals(category.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter gender
				try{
				System.out.println(gender);
				if(gender!= null && !gender.isEmpty()){
					for(Entry e:finalList){
						if(!e.gender.toLowerCase().equals(gender.toLowerCase()))
							rmList.add(e);
					}
					filter1();
					System.out.println(""+finalList.size());
				}
				}catch(Exception e){System.out.println("gender error "+e.getMessage());}
				try{
					if(!disabled.isEmpty())
						for(Entry e:finalList)
							if(!e.disabled.toLowerCase().equals(disabled.toLowerCase()))
								rmList.add(e);
					filter1();
					System.out.println(""+finalList.size());
					}catch(Exception e){}
				//filter dob
				//SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				try{
					String[] temp = dob.split("-");
				int[] dat = {Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2])};
				System.out.println(dob.toString());
				System.out.println(dobRadio);
				if(!dob.isEmpty())
					for(Entry e:finalList){
						String[] dt = e.dob.split("-");
						int[] d2 = {Integer.parseInt(dt[2]), Integer.parseInt(dt[1]), Integer.parseInt(dt[0])};
						//System.out.println(""+dtComp(dat,d2));
						if(dobRadio.equals("before")){
							if(dtComp(d2,dat) >= 0)
							{
								//System.out.println(e.dob);
								rmList.add(e);
							}
						}
						else if(dobRadio.equals("on")){
							if(dtComp(d2,dat)!=0)
								rmList.add(e);
						}
						else if(dobRadio.equals("after")){
							if(dtComp(d2,dat) <= 0)
								rmList.add(e);
						}
					}
				filter1();
				System.out.println(""+finalList.size());
				}catch(Exception e){System.out.println("error dob");}
				//filter stream
				if(!stream.isEmpty())
					for(Entry e:finalList)
						if(!e.stream.equals(stream))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter gDegree
				System.out.println(gDegree);
				if(!gDegree.isEmpty())
					for(Entry e:finalList)
						if(!e.gDegree.toLowerCase().equals(gDegree.toLowerCase())){
							System.out.println(e.gDegree);
							rmList.add(e);
						}
				filter1();
				System.out.println(""+finalList.size());
				//filter pgDegree
				if(!pgDegree.isEmpty())
					for(Entry e:finalList)
						if(!e.pgDegree.toLowerCase().equals(pgDegree.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter xBoard
				if(!xBoard.isEmpty())
					for(Entry e:finalList)
						if(!e.xBoard.toLowerCase().equals(xBoard.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter xiiBoard
				if(!xiiBoard.isEmpty())
					for(Entry e:finalList)
						if(!e.xiiBoard.toLowerCase().equals(xiiBoard.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter gDepartment
				if(!gDepartment.isEmpty())
					for(Entry e:finalList)
						if(!e.gDepartment.toLowerCase().equals(gDepartment.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter pgDepartment
				if(!pgDepartment.isEmpty())
					for(Entry e:finalList)
						if(!e.pgDepartment.toLowerCase().equals(pgDepartment.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter gstate
				if(!gState.isEmpty())
					for(Entry e:finalList)
						if(!e.gState.toLowerCase().equals(gState.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter pgState
				if(!pgState.isEmpty())
					for(Entry e:finalList)
						if(!e.pgState.toLowerCase().equals(pgState.toLowerCase()))
						{
							rmList.add(e);
						}
				filter1();
				System.out.println(""+finalList.size());
				//filter gUniversity
				if(!gUniversity.isEmpty())
					for(Entry e:finalList)
						if(!e.gUniversity.toLowerCase().equals(gUniversity.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println(""+finalList.size());
				//filter pg university
				if(!pgUniversity.isEmpty())
					for(Entry e:finalList)
						if(!e.pgUniversity.toLowerCase().equals(pgUniversity.toLowerCase()))
							rmList.add(e);
				filter1();
				System.out.println("x per "+finalList.size());
				//filter xPercent
				if(req.getParameterValues("xCheck")!=null && !xPercent.isEmpty())
					for(Entry e:finalList)
						for(String val: req.getParameterValues("xCheck"))
							if(val.equals("gt")){
								if(Double.parseDouble(e.xPercent)<=Double.parseDouble(xPercent))
									rmList.add(e);
							}
							else if(val.equals("eq")){
								if(Double.parseDouble(e.xPercent) != Double.parseDouble(xPercent))
									rmList.add(e);
							}
							else if(val.equals("lt")){
								if(Double.parseDouble(e.xPercent) >= Double.parseDouble(xPercent))
									rmList.add(e);
							}
				filter1();
				System.out.println(""+finalList.size());
				//filter xiiPercent
				if(req.getParameterValues("xiiCheck")!=null && !xiiPercent.isEmpty())
					for(Entry e:finalList)
						for(String val: req.getParameterValues("xiiCheck"))
							if(val.equals("gt")){
								if(Double.parseDouble(e.xiiPercent)<=Double.parseDouble(xiiPercent))
									rmList.add(e);
							}
							else if(val.equals("eq")){
								if(Double.parseDouble(e.xiiPercent) != Double.parseDouble(xiiPercent))
									rmList.add(e);
							}
							else if(val.equals("lt")){
								if(Double.parseDouble(e.xiiPercent) >= Double.parseDouble(xiiPercent))
									rmList.add(e);
							}
				filter1();
				System.out.println(""+finalList.size());
				//filter gPercent
				if(req.getParameterValues("gCheck")!=null && !gPercent.isEmpty())
					for(Entry e:finalList)
						for(String val: req.getParameterValues("gCheck"))
						if(val.equals("gt")){
							if(Double.parseDouble(e.gPercent)<=Double.parseDouble(gPercent))
								rmList.add(e);
						}
						else if(val.equals("eq")){
							if(Double.parseDouble(e.gPercent) != Double.parseDouble(gPercent))
								rmList.add(e);
						}
						else if(val.equals("lt")){
							if(Double.parseDouble(e.gPercent) >= Double.parseDouble(gPercent))
								rmList.add(e);
						}
				filter1();
				System.out.println("above pg"+finalList.size());
				//filter pgPercent
				System.out.println(req.getParameterValues("pgCheck") +" "+pgPercent);
				if(req.getParameterValues("pgCheck")!=null && pgPercent != null && !pgPercent.isEmpty())
					for(Entry e:finalList)
						for(String val: req.getParameterValues("pgCheck"))
							if(val.equals("gt")){
								if(e.pgPercent == null || (e.pgPercent.isEmpty() || Double.parseDouble(e.pgPercent)<=Double.parseDouble(pgPercent))){
									rmList.add(e);
								}
							}
							else if(val.equals("eq")){
								if(e.pgPercent == null || (e.pgPercent.isEmpty() || Double.parseDouble(e.pgPercent) != Double.parseDouble(pgPercent)))
									rmList.add(e);
							}
							else if(val.equals("lt")){
								if(e.pgPercent == null || (e.pgPercent.isEmpty() || Double.parseDouble(e.pgPercent) >= Double.parseDouble(pgPercent)))
									rmList.add(e);
							}
				filter1();
				System.out.println("pg "+finalList.size());
				System.out.println(""+gateScore);
				if(req.getParameterValues("gateCheck") !=null && gateScore!=null && !gateScore.isEmpty())
					for(Entry e:finalList)
						for(String val: req.getParameterValues("gateCheck"))
							if(val.equals("gt")){
								if(e.gateScore.isEmpty() || Double.parseDouble(e.gateScore)<=Double.parseDouble(gateScore)){
									//System.out.println("gscore "+e.gateScore);
									rmList.add(e);
								}
							}
							else if(val.equals("eq")){
								if(e.gateScore.isEmpty() || Double.parseDouble(e.gateScore) != Double.parseDouble(gateScore))
									rmList.add(e);
							}
							else if(val.equals("lt")){
								if(e.gateScore.isEmpty() || Double.parseDouble(e.gateScore) >= Double.parseDouble(gateScore)){
									//System.out.println("gscore "+e.gateScore);
									rmList.add(e);
								}
							}
				filter1();
				System.out.println(""+finalList.size());
				//filter in dates
				try{
					int[] dat1;
					dat1 = new int[3];
					System.out.println(dateFrom);
					String[] dt1 = dateFrom.split("-");
					if(!dt1.toString().isEmpty()){
						dat1[0] = Integer.parseInt(dt1[0]);
						dat1[1] = Integer.parseInt(dt1[1]);
						dat1[2] = Integer.parseInt(dt1[2]);
					}
					else{
						dat1[0] = 0;
						dat1[1] = 0;
						dat1[2] = 0;
					}
					//System.out.println(dateFrom.toString());
					if(!dt1.toString().isEmpty())
						for(Entry e1:finalList){
							String[] dt = e1.dated.split(" ")[0].split("-");
							int[] dtf = {Integer.parseInt(dt[0]),dates.get(dt[1].toLowerCase()),Integer.parseInt(dt[2])};
							if(dtComp(dat1,dtf)>0){
								rmList.add(e1);
							}
						}
					filter1();
					
					}catch(Exception ex){System.out.println(ex.toString());}
				try{
					int[] dat2;
					dat2 = new int[3];
					String[] dt2 = dateTo.split("-");
					if(!dt2.toString().isEmpty()){
						dat2[0] = Integer.parseInt(dt2[0]);
						dat2[1] = Integer.parseInt(dt2[1]);
						dat2[2] = Integer.parseInt(dt2[2]);
					}
					else{
						dat2[0] = 0;
						dat2[1] = 0;
						dat2[2] = 0;
					}
					//System.out.println(dateFrom.toString());
					if(!dt2.toString().isEmpty())
						for(Entry e1:finalList){
							String[] dt = e1.dated.split(" ")[0].split("-");
							int[] dtf = {Integer.parseInt(dt[0]),dates.get(dt[1].toLowerCase()),Integer.parseInt(dt[2])};
							if(dtComp(dat2,dtf)<0)
								rmList.add(e1);
						}
					filter1();
					System.out.println(""+finalList.size());
					}catch(Exception ex){System.out.println("tab 3 error dt2");}
				return 0;
}
}