package com.iiitd;
/* @author Parikshit_Diwan_2014074 @author Shubham_Goswami_2014100*/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;;

public class show extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("coming post");
		String email = req.getParameter("email");
		System.out.println(email);
		//xml file Structure
		File fXmlFile;
		DocumentBuilderFactory docFactory;
		DocumentBuilder docBuilder;
		Document doc = null;
		Element toadd,data;
		
		try{
			fXmlFile = new File("/Users/ShubhamGoswami/Desktop/tmp/temp.xml");
			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			}catch(Exception e){System.out.println("xml ni khuli");
			resp.setStatus(404);
			return;
			}
		
		NodeList nl = doc.getElementsByTagName("entry");
		System.out.println(nl.getLength());
		int found=0;
		Element fnd = null;
		for(int i=0;i<nl.getLength();i++){
			Element e = (Element)nl.item(i);
			Element temp = (Element)e.getElementsByTagName("email").item(0);
			if(temp == null)
				System.out.println("temp is null");
			if(temp.getTextContent().equals(email)){
				found=1;
				fnd = e;
				break;
			}
		}
		
		if(found == 0){
			System.out.println("not found");
			resp.setStatus(404);
			return;
		} else {
			String st = "";
			NodeList nl1 = (NodeList)fnd.getChildNodes();
			for(int j=0;j<nl1.getLength();j++){
				Element tt = (Element)nl1.item(j);
				st += (tt.getTagName()+" "+tt.getTextContent()+"<br>");
			}
			req.setAttribute("str", st);
			req.getRequestDispatcher("/data.jsp").forward(req, resp);
		}
		
	}

}
