package quy.com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quy.com.dao.IDetailGroupDao;
import quy.com.entity.DetailGroup;
 
@Repository 
@Transactional
public class DetailGroupDaoImpl extends Dao implements IDetailGroupDao {

	@Override
	public void guardar(DetailGroup arg0) {
		// TODO Auto-generated method stub
		getSession().save(arg0);
	}

	@Override
	public void actualizar(DetailGroup arg0) {
		// TODO Auto-generated method stub
		getSession().update(arg0);	
	}

	@Override
	public void eliminar(DetailGroup arg0) {
		// TODO Auto-generated method stub
		getSession().delete(arg0);	
	}

	@Override
	public DetailGroup getDetailGroup(int id) {
		// TODO Auto-generated method stub
		return (DetailGroup)getSession().get(DetailGroup.class, id);
	}

	@Override
	public List<DetailGroup> getDetailGroups() {
		// TODO Auto-generated method stub
		return    crearCriteria(DetailGroup.class).list();
	}

	@Override
	public List<DetailGroup> getDetailsByGroup(int id) {
		// TODO Auto-generated method stub
		//Hibernate.initialize(user.getUserProfile()); 
		Criteria criteria = crearCriteria(DetailGroup.class);
		criteria.add(Restrictions.eq("group.groupId", id));
		criteria.addOrder(Order.asc("position"));
		
		return   criteria.list();		 
	}

}
