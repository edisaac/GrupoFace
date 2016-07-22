package quy.com.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FaceBookUrl {
	public static final String GRAPH_URL= "https://graph.facebook.com/v2.7/";
	public static final String AUTH_URL= "http://www.facebook.com/dialog/";
	
	public static String getRequest(String url) {
			String response;
			response="";
			URL fbGraphURL;
			try {
				fbGraphURL = new URL(url);
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
			response= b.toString();
			System.out.println(response);
			return response;
		}
}
