package quy.com.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

 
public class Dao {
	private SessionFactory sessionFactory;
	
	public  void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    public Session getSession() throws HibernateException {
    	Session session;
		try {
		    session = getSessionFactory().getCurrentSession();
		} catch (HibernateException e) {
		    session = getSessionFactory().openSession();
		}
		
		return session;
    }
    protected Criteria crearCriteria(Class arg0){
		return getSession().createCriteria( arg0);
	}
    protected Criteria crearCriteria(Class arg0,String alias){
		return getSession().createCriteria( arg0,alias);
	}

	
}
