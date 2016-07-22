package quy.com.facebook;

 
import org.primefaces.json.JSONObject;

public class FaceBookToken    {
	private String access_token="";
	private String token_type;
	private long expires_in;
	private String code;
	private String mensaje;
	private FaceBookConnection faceBookConnection; 
	

	public FaceBookConnection getFaceBookConnection() {
		return faceBookConnection;
	}

	public void setFaceBookConnection(FaceBookConnection faceBookConnection) {
		this.faceBookConnection = faceBookConnection;
	}
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (!code.equals(this.code)) this.access_token="";
		this.code = code;
	}
	
	public String getFBGraphUrl() {
		String fbGraphUrl = "";	
		 
			fbGraphUrl = FaceBookUrl.GRAPH_URL
					+ "oauth/access_token"
					+ "?client_id=" + faceBookConnection.getId()  
					+ "&redirect_uri="	+ faceBookConnection.getUri()
					+ "&client_secret=" + faceBookConnection.getSecret()
					+ "&code=" + this.code;
		 
		return fbGraphUrl;
	}
	 
	public void doRequest(){
		
		if (!this.access_token.equals("")){
			return;
		}
		String jsonStr;
		jsonStr= FaceBookUrl.getRequest( getFBGraphUrl());
		
		JSONObject json = new JSONObject(jsonStr);
		
		this.access_token=json.getString("access_token");
		this.token_type=json.getString("token_type");
		this.expires_in=json.getLong("expires_in");		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
		 
	 


}
