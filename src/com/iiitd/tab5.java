package com.iiitd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;;

public class tab5 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person.submit(req, resp);
		req.getSession().setAttribute("submit", "1");
		req.getRequestDispatcher("./thank.jsp").forward(req, resp);
	}

}
