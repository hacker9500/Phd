package com.iiitd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;;

public class tab4 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person.save4(req, resp);
		req.getSession().setAttribute("feedback", "1");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
