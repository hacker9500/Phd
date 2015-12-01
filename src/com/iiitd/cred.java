package com.iiitd;
/* @author Parikshit_Diwan_2014074 @author Shubham_Goswami_2014100*/
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class cred extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("user").equals("shubham") && req.getParameter("password").equals("1234")){
			System.out.println("comig match");
			req.getSession().setAttribute("admin", "1");
			req.getRequestDispatcher("/admin.jsp").forward(req, resp);
		}
		else
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
