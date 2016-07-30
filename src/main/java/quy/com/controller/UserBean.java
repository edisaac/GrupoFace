package quy.com.controller;

import java.io.IOException; 

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.javaplugs.jsf.ViewScope;

import quy.com.entity.User;
import quy.com.facebook.FaceBookConnection;
import quy.com.facebook.FaceBookToken;
import quy.com.facebook.FaceBookUser;
import quy.com.service.IUserService;
 
@Controller
@Scope("session")
public class UserBean {

	@Autowired
	private FaceBookConnection faceBookConnection;
	
	@Autowired
	private FaceBookToken faceBookToken;
	
	@Autowired
	private IUserService userService;
 
	private User user;
		
	 
	  
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
		
	 
		this.user=userService.getUserByFaceId(fcUser.getFacebookId() ) ;
		boolean isNew=false;
		
		if (this.user==null){
			this.user= new User();
			this.user.setState('0');
			isNew=true;
		}
		
		this.user.setFacebookId(fcUser.getFacebookId()); 
		this.user.setName( fcUser.getName());
		this.user.setUrlPicture(fcUser.getUrlPicture());
		this.user.setEmail(fcUser.getEmail()); 
		
		if( isNew){ 			
			if (userService.guardar(this.user))
				return "welcome";			
			faceBookToken.setMensaje("Error: No se pudo crear el usuario.");
			return "index";
		} else {			
			
			if (userService.actualizar(this.user))		
				return "welcome";
			faceBookToken.setMensaje("Error: No se pudo actualizar el usuario.");
			return "index";
		}
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
