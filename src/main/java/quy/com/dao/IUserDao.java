package quy.com.dao;

import java.util.List;
 
import quy.com.entity.User;

public interface IUserDao {
	public void guardar(User arg0);
	public void actualizar(User   arg0);
	public void eliminar(User arg0);
	public User getUser(int id);
	public User getUserByFaceId(String faceBookId);
	public List<User> getUsers();
}
