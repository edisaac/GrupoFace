package quy.com.facebook;

 
import org.apache.log4j.Logger;
import org.primefaces.json.JSONObject;

import quy.com.controller.UserBean;

 
public class FaceBookUser {
	private FaceBookToken token;
	private String facebookId;
	private String name;
	private String urlPicture;
	private String email;
	private static final Logger logger = Logger.getLogger(FaceBookUser.class);
	public FaceBookUser(FaceBookToken token) {
		this.token = token;
	}
	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlPicture() {
		return urlPicture;
	}

	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
	
	public String getFBGraphUrl() {
		String graph = "";		 
		graph= FaceBookUrl.GRAPH_URL
				+"me?"
				+"access_token=" + token.getAccess_token()
				+"&format=json"
				+"&method=get"
				+"&fields=" + token.getFaceBookConnection().getUserFields();	
		return graph;
	}

	public void doRequest() {
		String jsonStr;
		jsonStr= FaceBookUrl.getRequest( getFBGraphUrl());
		
		JSONObject json = new JSONObject(jsonStr);
		JSONObject picture;
		JSONObject data;
	
		
		
		this.facebookId=json.getString("id");
		this.name=json.getString("name");
	 
		picture=json.getJSONObject("picture");
		data=picture.getJSONObject("data");
		System.out.println(data.getString("url"));
		logger.trace(data.getString("url"));
		this.urlPicture=data.getString("url"); 
		 
		try{
			this.email=json.getString("email");
		}catch (Exception e) {
			this.email="no tiene";
		}
		 
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
