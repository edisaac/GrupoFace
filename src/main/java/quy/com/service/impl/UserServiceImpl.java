package quy.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import quy.com.controller.util.JsfUtil;
import quy.com.dao.IUserDao;
import quy.com.entity.User;
import quy.com.service.IUserService;

@Service("userService") 	
public class UserServiceImpl implements IUserService {
		@Autowired
		private IUserDao userDao;

		@Override
		@Transactional 
		public boolean guardar(User arg0) {
			try		{
				userDao.guardar(arg0); 			
				return true;
			}catch (Exception e){
				JsfUtil.setException(e);
				return false;
			}
		}

		@Override
		@Transactional
		public boolean actualizar(User arg0) {
			try		{
				userDao.actualizar(arg0); 			
				return true;
			}catch (Exception e){
				JsfUtil.setException(e);
				return false;
			}
		}

		@Override
		@Transactional
		public boolean eliminar(User arg0) {
			try		{
				userDao.eliminar(arg0); 			
				return true;
			}catch (Exception e){
				JsfUtil.setException(e);
				return false;
			}
		}

		@Override
		@Transactional(readOnly=true)
		public User getUser (int id) {
			try	{					
				return userDao.getUser(id );	
			}catch (Exception e){
				JsfUtil.setException(e);
				return null;
			}
		}

		@Override
		@Transactional(readOnly=true)
		public List<User> getUsers() {
			try	{					
				return userDao.getUsers();	
			}catch (Exception e){
				JsfUtil.setException(e);
				return null;
			}
		}

		@Override
		@Transactional(readOnly=true)
		public User getUserByFaceId(String faceBookId) {
			try	{					
				return userDao.getUserByFaceId(faceBookId);	
			}catch (Exception e){
				JsfUtil.setException(e);
				return null;
			}
		}

		@Override
		@Transactional(readOnly=true)
		public List<User> getNotGroupUsersByName(int groupId, String name) {
			try	{					
				return userDao.getNotGroupUsersByName(groupId,name);	
			}catch (Exception e){
				JsfUtil.setException(e);
				return null;
			}
		}

	 
		
		
}
