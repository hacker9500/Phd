package com.iiitd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class tab2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person.save2(req, resp);
		req.getSession().setAttribute("save2", "1");
		req.getRequestDispatcher("./index.jsp").forward(req, resp);
	}

}
