package quy.com.entity;

public class User {
	 
		private int UserId;
		private String id;
		private String name;
		private String urlPicture;
 

		public int getUserId() {
			return UserId;
		}

		public void setUserId(int userId) {
			UserId = userId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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
	  
}
