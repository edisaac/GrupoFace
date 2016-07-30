package quy.com.facebook;

 
import java.io.UnsupportedEncodingException;
 
import java.net.URLEncoder;


public class FaceBookConnection {
	private String id ;
	private String secret ;
	private String uri ; 
	private String scope;	
	private String userFields;
	
	public String getFBAuthUrl() {
		String fbLoginUrl = "";
	 
			fbLoginUrl = FaceBookUrl.AUTH_URL
					+ "oauth?" 
					+ "client_id=" + this.getId() 
					+ "&redirect_uri=" +  this.getUri() 
					+ "&scope="+this.getScope();
	 
		return fbLoginUrl;
	}


	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUri()  {
		try {
			return URLEncoder.encode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "error in URL:" + uri;
		}
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getUserFields() {
		return userFields;
	}


	public void setUserFields(String userFields) {
		this.userFields = userFields;
	}

	
}
