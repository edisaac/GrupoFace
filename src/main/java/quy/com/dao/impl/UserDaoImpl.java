package quy.com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quy.com.dao.IUserDao;
import quy.com.entity.DetailGroup;
import quy.com.entity.Group;
import quy.com.entity.User;

@Repository 

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
		return  (User) crearCriteria(User.class).add(				
				Restrictions.eq("facebookId", faceBookId)				
				).uniqueResult();		
	}

	@Override
	public List<User> getNotGroupUsersByName(int groupId, String name) {
		// TODO Auto-generated method stub
		Criteria criteria = crearCriteria(User.class, "u");
		DetachedCriteria subcriteria = DetachedCriteria.forClass(DetailGroup.class, "dg");
		subcriteria.add(Restrictions.eq("dg.group.id", groupId));
		subcriteria.add(Restrictions.eqProperty(  "dg.user.userId", "u.userId"));
		subcriteria.setProjection(Projections.property("dg.user.userId"));
		criteria.add(Subqueries.notExists(subcriteria));
		criteria.add(Restrictions.ilike("u.name","%" + name + "%"));
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

	 

}
