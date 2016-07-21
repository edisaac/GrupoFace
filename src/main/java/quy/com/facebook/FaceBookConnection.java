package quy.com.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class FaceBookConnection {
	private String id ;
	private String secret ;
	private String uri ;
	private FaceBookToken token   ;
	private String scope;
	private String code;
	
	public String getFBAuthUrl() {
		String fbLoginUrl = "";
		try {
			fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id="
					+ this.getId() + "&redirect_uri="
					+ URLEncoder.encode(this.getUri(), "UTF-8")
					+ "&scope="+this.getScope();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbLoginUrl;
	}

	public String getFBGraphUrl() {
		String fbGraphUrl = "";
		try {
			fbGraphUrl = "https://graph.facebook.com/v2.7/oauth/access_token?"
					+ "client_id=" + this.getId()  + "&redirect_uri="
					+ URLEncoder.encode(this.getUri(), "UTF-8")
					+ "&client_secret=" + this.getSecret()+ "&code=" + this.code;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbGraphUrl;
	}

	public FaceBookToken getAccessToken() {
		if (token==null) {
			URL fbGraphURL;
			try {
				fbGraphURL = new URL(getFBGraphUrl());
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection fbConnection;
			StringBuffer b = null;
			try {
				fbConnection = fbGraphURL.openConnection();
				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(
						fbConnection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook "
						+ e);
			}
		 
			token = new FaceBookToken(b.toString());
		}
		return token;
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

	public String getUri() {
		return uri;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
