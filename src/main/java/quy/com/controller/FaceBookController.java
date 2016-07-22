package quy.com.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quy.com.entity.User;
import quy.com.facebook.FaceBookConnection;
import quy.com.facebook.FaceBookToken;
import quy.com.facebook.FaceBookUser;
 
@Controller
@Scope("session")
public class FaceBookController {

	@Autowired
	FaceBookConnection faceBookConnection;
	@Autowired
	FaceBookToken faceBookToken;
	@Autowired
	User user;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String nuevaOrden() {
   
	return "redirect:" + faceBookConnection.getFBAuthUrl();
	}
	
	
	@RequestMapping(value = "/callback.do", method = RequestMethod.GET)
	public String callback(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {	
		String code; 
		code = req.getParameter("code");
		
		if (code == null || code.equals("")) {
			System.out.println(req.getRequestURI());
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
	 
		faceBookToken.setCode(code);		
		faceBookToken.doRequest();		
		 
		  
		FaceBookUser fcUser = new FaceBookUser(faceBookToken);
		fcUser.doRequest();
		
		user.setFacebookId(fcUser.getId());
		user.setName( fcUser.getName());
		user.setUrlPicture(fcUser.getUrlPicture());
	 
		return "view/grupos";
	}
}
