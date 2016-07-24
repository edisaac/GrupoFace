package quy.com.dao.impl;

import java.util.List;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quy.com.dao.IUserDao;
import quy.com.entity.User;

@Repository 
@Transactional
public class UserDaoImpl extends Dao implements IUserDao {

	@Override
	public void guardar(User arg0) {
		// TODO Auto-generated method stub
		getSession().save(arg0);	
	}

	@Override
	public void actualizar(User arg0) {
		// TODO Auto-generated method stub
		getSession().update(arg0);	
	}

	@Override
	public void eliminar(User arg0) {
		// TODO Auto-generated method stub
		getSession().delete(arg0);	
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return (User)getSession().get(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return    crearCriteria(User.class).list();
	}

	@Override
	public User getUserByFaceId(String faceBookId) {
		// TODO Auto-generated method stub
		//sizeCriteria.add(Property.forName("user_id").eq(id));
		return  (User) crearCriteria(User.class).add(
				//Property.forName("facebookId").eq(faceBookId)
				Restrictions.eq("facebookId", faceBookId)
				//Restrictions.sqlRestriction("facebook_id=?",faceBookId,new StringType() )
				).uniqueResult();
		
	}

}
