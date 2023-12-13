package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Haisan;
import uti.HibernateUti;

public class HaisanDAO implements DAO<Haisan> {

	@Override
	public List<Haisan> findALL() {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			List<Haisan> list=sess.createCriteria(Haisan.class).list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return null;
	}

	@Override
	public Haisan findByid(Serializable id) {
		// TODO Auto-generated method stub
				SessionFactory sf=HibernateUti.getSessionFactory();
				Session sess=sf.openSession();
				Transaction tx=sess.beginTransaction();
				try {
					Haisan c=(Haisan) sess.get(Haisan.class,id);
					tx.commit();
					return c;
					
				} catch (Exception e) {
					if (tx!=null)
						tx.rollback();
				}
				return null;
		
	}

	@Override
	public boolean delete(Serializable id) {
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			Haisan c=(Haisan) sess.get(Haisan.class,id);
			sess.delete(c);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return false;
	}

	@Override
	public boolean add(Haisan t) {
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			sess.save(t);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return false;
	}

	@Override
	public boolean update(Haisan t) {
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			sess.saveOrUpdate(t);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return false;
	}

}
