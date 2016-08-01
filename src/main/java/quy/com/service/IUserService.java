package quy.com.service;

import java.util.List;

import quy.com.entity.User;
 
public interface IUserService {
	public boolean guardar(User arg0);
	public boolean actualizar(User arg0);
	public boolean eliminar(User arg0);
	public User getUser(int id);
	public List<User> getUsers();
	public User getUserByFaceId(String faceBookId); 
	public List<User> getNotGroupUsersByName(int groupId, String name);
}