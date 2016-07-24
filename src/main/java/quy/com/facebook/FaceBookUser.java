package quy.com.facebook;

 
import org.primefaces.json.JSONObject;

 
public class FaceBookUser {
	private FaceBookToken token;
	private String facebookId;
	private String name;
	private String urlPicture;
	
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
				+"&fields=id,name,picture";	
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
		
		this.urlPicture=data.getString("url"); 
		
	}

	
}
