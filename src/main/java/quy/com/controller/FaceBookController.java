package quy.com.controller;

import java.io.IOException; 

import javax.servlet.ServletException; 
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
import quy.com.service.IUserService;
 
@Controller
@Scope("session")
public class FaceBookController {

	@Autowired
	private FaceBookConnection faceBookConnection;
	
	@Autowired
	private FaceBookToken faceBookToken;
	
	@Autowired
	private User user;
		
	@Autowired
	private IUserService UserService;
	
	
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
			 faceBookToken.setMensaje("Error: No se pudo validar el usuario");
			 return "index";
		}
	 
		faceBookToken.setCode(code);		
		faceBookToken.doRequest();		
		 
		  
		FaceBookUser fcUser = new FaceBookUser(faceBookToken);
		fcUser.doRequest();
		
		
		
		user.setFacebookId(fcUser.getId()); 
		user.setName( fcUser.getName());
		user.setUrlPicture(fcUser.getUrlPicture());
		
		User temp;
		temp=UserService.getUserByFaceId(user.getFacebookId()) ;
		
		if( temp ==null)
		{
			UserService.guardar(user);	
			return "nuevo";
		} 
		
		UserService.actualizar(user);		
		return "grupos";
	}
}
