package quy.com.dao;

import java.util.List;

import quy.com.entity.Group;

public interface IGroupDao {
	public void guardar(Group arg0);
	public void actualizar(Group   arg0);
	public void eliminar(Group arg0);
	public Group getGroup(int id);	
	public List<Group> getGroups();
	public List<Group> getGroupsByUser(int id);
}
