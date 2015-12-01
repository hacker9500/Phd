package com.iiitd;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class googleplus
 */
@WebServlet("/googleplus")
public class googleplus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLIENT_ID = "367105593384-7f9h014nrb15s8ukf1g7iautri84i6af.apps.googleusercontent.com";
	private static final String CLIENT_SECRET = "tyeimwtbbe3VdHG8NPmMTx9h";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public googleplus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	System.out.println("eff");
		ServiceBuilder builder= new ServiceBuilder(); 
	//	System.out.print("f");
		  OAuthService service = builder.provider(	Google2Api.class).apiKey(CLIENT_ID) 
	         .apiSecret(CLIENT_SECRET) 
	         .callback("http://localhost:8080/Phd/oauth2callback")
	         .scope("openid profile email " + 
	               "https://www.googleapis.com/auth/plus.login " + 
	               "https://www.googleapis.com/auth/plus.me") /*+
	               "https://www.googleapis.com/auth/userinfo.email" +
	               "https://www.googleapis.com/auth/userinfo.profile") */
	         .debug() 
	         .build(); //Now build the call
	      HttpSession sess = request.getSession(); 
	      sess.setAttribute("oauth2Service", service);
	      response.sendRedirect(service.getAuthorizationUrl(null));
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
