package com.iiitd;
/* @author Parikshit_Diwan_2014074 @author Shubham_Goswami_2014100*/
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;;

public class upload extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person.upload(req, resp);
		req.getSession().setAttribute("upload", "1");
	}

}
