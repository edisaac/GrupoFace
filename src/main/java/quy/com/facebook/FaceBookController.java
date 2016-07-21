package quy.com.facebook;

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
 
@Controller
@Scope("session")
public class FaceBookController {

	@Autowired
	FaceBookConnection faceBookConnection;
	
	@RequestMapping(value = "/face/login.do", method = RequestMethod.GET)
	public String nuevaOrden() {
   
	return "redirect:" + faceBookConnection.getFBAuthUrl();
	}
	
	
	@RequestMapping(value = "/face/callback.do", method = RequestMethod.GET)
	public void callback(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {	
		String code; 
		code = req.getParameter("code");
		
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		faceBookConnection.setCode(code);
		ServletOutputStream out = res.getOutputStream();
		
		FaceBookToken token = faceBookConnection.getAccessToken();
		out.println("<h1>xx"+token.getAccess_token()+"</h1>");
		FaceBookGraph fbGraph = new FaceBookGraph(token);
		String graph = fbGraph.getFBGraph();
		out.println("<br><h2>"+graph+"</h2>");
		/*
		 * Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
	 	out.println("<h1>Facebook Login using Java</h1>");
		
		out.println("<div>Welcome "+fbProfileData.get("first_name"));
		out.println("<div>Your Email: "+fbProfileData.get("email"));
		out.println("<div>You are "+fbProfileData.get("gender"));		*/
	}
}
