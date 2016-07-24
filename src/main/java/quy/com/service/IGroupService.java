package quy.com.service;

import java.util.List;

import quy.com.entity.Group;

public interface IGroupService {
	public boolean guardar(Group arg0);
	public boolean actualizar(Group arg0);
	public boolean eliminar(Group arg0);
	public Group getGroup(int id);
	public List<Group> getGroups();
	public List<Group> getGroupsByUser(int id);
}
