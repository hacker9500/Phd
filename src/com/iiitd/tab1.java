package com.iiitd;
/* @author Parikshit_Diwan_2014074 @author Shubham_Goswami_2014100*/
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;;

public class tab1 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("coming post");
		Person.save1(req, resp);
		req.getSession().setAttribute("save1", "1");
		req.getRequestDispatcher("./index.jsp").forward(req, resp);
	}

}
