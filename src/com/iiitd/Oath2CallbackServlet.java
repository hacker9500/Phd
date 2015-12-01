package com.iiitd;
/* @author Parikshit_Diwan_2014074 @author Shubham_Goswami_2014100*/
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

@WebServlet(urlPatterns={"/oauth2callback"}, asyncSupported=true) 

public class Oath2CallbackServlet extends HttpServlet { @Override 
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws IOException, ServletException {
      //Check if the user have rejected 
      String error = req.getParameter("error"); 
      if ((null != error) && ("access_denied".equals(error.trim()))) { 
         HttpSession sess = req.getSession(); 
         sess.invalidate(); 
         resp.sendRedirect(req.getContextPath()); 
         return; 
      }
      //OK the user have consented so lets find out about the user 
      System.out.println("working...");
      AsyncContext ctx = req.startAsync(); 
      ctx.start(new GetUserInfo(req, resp, ctx)); 
   } 
}


class GetUserInfo implements Runnable { 
   private HttpServletRequest req; 
   private HttpServletResponse resp; 
   private AsyncContext asyncCtx; 
   public GetUserInfo(HttpServletRequest req, HttpServletResponse resp, AsyncContext asyncCtx) { 
      this.req = req; 
      this.resp = resp; 
      this.asyncCtx = asyncCtx; 
   }
   @Override 
   public void run() {  
      HttpSession sess = req.getSession(); 
      OAuthService service = (OAuthService)sess.getAttribute("oauth2Service");
      //Get the all important authorization code 
      String code = req.getParameter("code"); 
      //Construct the access token 
      
      Token token = service.getAccessToken(null, new Verifier(code)); 
      //Save the token for the duration of the session 
      sess.setAttribute("token", token);
      //Perform a proxy login 
      try { 
         req.login("fred", "fredfred"); 
      } catch (ServletException e) { 
         //Handle error - should not happen 
      }
      //Now do something with it - get the user's G+ profile 
      OAuthRequest oReq = new OAuthRequest(Verb.GET, 
            "https://www.googleapis.com/oauth2/v2/userinfo");//Wait 
      service.signRequest(token, oReq); 
      Response oResp = oReq.send(); 

      //Read the result 
      System.out.println(oResp.getBody());
      JsonReader reader = Json.createReader(new ByteArrayInputStream( 
            oResp.getBody().getBytes())); 
      JsonObject profile = reader.readObject(); 
      //Save the user details somewhere or associate it with 
      sess.setAttribute("name", profile.getString("name")); 
      sess.setAttribute("email", profile.getString("email")); 
      //  ... 
      try {
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      asyncCtx.complete();
   } 
}