package quy.com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quy.com.dao.IGroupDao;
import quy.com.entity.DetailGroup;
import quy.com.entity.Group;
 
@Repository 

public class GroupDaoImpl extends Dao implements IGroupDao {

	@Override
	public void guardar(Group arg0) {
		// TODO Auto-generated method stub
		getSession().save(arg0);
	}

	@Override
	public void actualizar(Group arg0) {
		// TODO Auto-generated method stub
		getSession().update(arg0);	
	}

	@Override
	public void eliminar(Group arg0) {
		// TODO Auto-generated method stub
		getSession().delete(arg0);
	}	

	@Override
	public Group getGroup(int id) {
		// TODO Auto-generated method stub
		return (Group)getSession().get(Group.class, id);
	}

	@Override
	public List<Group> getGroups() {
		// TODO Auto-generated method stub
		return    crearCriteria(Group.class).list();
	}

	@Override
	public List<Group> getGroupsByUser(int id) {
		// TODO Auto-generated method stub		
		Criteria criteria = crearCriteria(Group.class, "g");
		DetachedCriteria subcriteria = DetachedCriteria.forClass(DetailGroup.class, "dg");
		subcriteria.add(Restrictions.eq("dg.user.userId", id));
		subcriteria.add(Restrictions.eqProperty(  "dg.group.groupId", "g.groupId"));
		subcriteria.setProjection(Projections.property("dg.user.userId"));
		criteria.add(Subqueries.exists(subcriteria));
	 
		return   criteria.list();

	}
}
