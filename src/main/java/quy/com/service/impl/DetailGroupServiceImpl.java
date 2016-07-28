package quy.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quy.com.controller.util.JsfUtil;
import quy.com.dao.IDetailGroupDao;
import quy.com.dao.IGroupDao;
import quy.com.entity.DetailGroup;
import quy.com.service.IDetailGroupService;

@Service("detailGroupService") 
public class DetailGroupServiceImpl implements IDetailGroupService {
	@Autowired
	private IDetailGroupDao detailGroupDao;
	
	@Override
	public boolean guardar(DetailGroup arg0) {
		try		{
			detailGroupDao.guardar(arg0); 			
			return true;
		}catch (Exception e){
			JsfUtil.setException(e);
			return false;
		}
	}

	@Override
	public boolean actualizar(DetailGroup arg0) {
		try		{
			detailGroupDao.actualizar( arg0); 			
			return true;
		}catch (Exception e){
			JsfUtil.setException(e);
			return false;
		}
	}

	@Override
	public boolean eliminar(DetailGroup arg0) {
		try		{
			detailGroupDao.eliminar(arg0 ); 		
			return true;
		}catch (Exception e){
			JsfUtil.setException(e);
			return false;
		}
	}

	@Override
	public DetailGroup getDetailGroup(int id) {
		try	{					
			return detailGroupDao.getDetailGroup(id );	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

	@Override
	public List<DetailGroup> getDetailGroups() {
		try	{					
			return detailGroupDao.getDetailGroups() ;	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

	@Override
	public List<DetailGroup> getDetailsByGroup(int id) {
		try	{					
			return detailGroupDao.getDetailsByGroup(id) ;	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

}
