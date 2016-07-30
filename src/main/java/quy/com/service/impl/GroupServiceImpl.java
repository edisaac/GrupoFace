package quy.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import quy.com.controller.util.JsfUtil;
import quy.com.dao.IDetailGroupDao;
import quy.com.dao.IGroupDao;
import quy.com.entity.DetailGroup;
import quy.com.entity.Group;
import quy.com.service.IGroupService;

@Service("groupService") 
public class GroupServiceImpl implements IGroupService {
	@Autowired
	private IGroupDao groupDao;
	
	@Override
	@Transactional
	public boolean guardar(Group arg0 ) {
		try		{			 
			 
			groupDao.guardar(arg0);
		
			return true;
		}catch (Exception e){
			JsfUtil.setException(e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean actualizar(Group arg0) {
		try		{
			groupDao.actualizar(arg0); 		
			return true;
		}catch (Exception e){
			JsfUtil.setException(e);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean eliminar(Group arg0) {
		try		{
			groupDao.eliminar(arg0 ); 		
			return true;
		}catch (Exception e){
			JsfUtil.setException(e);
			return false;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Group getGroup(int id) {
		try	{					
			return groupDao.getGroup(id );	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Group> getGroups() {
		try	{					
			return groupDao.getGroups() ;	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Group> getGroupsByUser(int id) {
		try	{					
			return groupDao.getGroupsByUser(id) ;	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}
	
}
