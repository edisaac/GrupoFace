package quy.com.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional(readOnly=true)
	public DetailGroup getDetailGroup(int id) {
		try	{					
			return detailGroupDao.getDetailGroup(id );	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<DetailGroup> getDetailGroups() {
		try	{					
			return detailGroupDao.getDetailGroups() ;	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<DetailGroup> getDetailsByGroup(int id) {
		try	{					
			return detailGroupDao.getDetailsByGroup(id) ;	
		}catch (Exception e){
			JsfUtil.setException(e);
			return null;
		}
	}

	@Override
	@Transactional
	public boolean mover(DetailGroup arg0, DetailGroup arg1) {
		int position;
		Date paymentDate;
		
		position=arg0.getPosition();
		paymentDate=arg0.getPaymentDate();
		
		arg0.setPosition(arg1.getPosition());
		arg0.setPaymentDate(arg1.getPaymentDate());
		
		arg1.setPosition(position);
		arg1.setPaymentDate(paymentDate);
		
		try		{
			detailGroupDao.actualizar(arg0);
			detailGroupDao.actualizar(arg1); 	
			return true;
		}catch (Exception e){
			JsfUtil.setException(e);
			return false;
		}
	}

}
