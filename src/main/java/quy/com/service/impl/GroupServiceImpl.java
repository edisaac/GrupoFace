package quy.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quy.com.dao.IGroupDao;
import quy.com.entity.Group;
import quy.com.service.IGroupService;

@Service("userGroup") 
public class GroupServiceImpl implements IGroupService {
	@Autowired
	private IGroupDao groupDao;

	@Override
	public boolean guardar(Group arg0) {
		try		{
			groupDao.guardar(arg0); 			
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}
	}

	@Override
	public boolean actualizar(Group arg0) {
		try		{
			groupDao.actualizar(arg0); 		
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}
	}

	@Override
	public boolean eliminar(Group arg0) {
		try		{
			groupDao.eliminar(arg0 ); 		
			return true;
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return false;
		}
	}

	@Override
	public Group getGroup(int id) {
		try	{					
			return groupDao.getGroup(id );	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}

	@Override
	public List<Group> getGroups() {
		try	{					
			return groupDao.getGroups() ;	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}

	@Override
	public List<Group> getGroupsByUser(int id) {
		try	{					
			return groupDao.getGroupsByUser(id) ;	
		}catch (Exception e){
			System.out.println("Error>>" + e);
			return null;
		}
	}
	
}
