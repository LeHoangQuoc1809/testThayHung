package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Loaihaisan;
import uti.HibernateUti;

public class LoaihaisanDAO implements DAO<Loaihaisan> {

	@Override
	public List<Loaihaisan> findALL() {
		// TODO Auto-generated method stub
		SessionFactory sf=HibernateUti.getSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		try {
			List<Loaihaisan> list=sess.createCriteria(Loaihaisan.class).list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			if (tx!=null)
				tx.rollback();
		}
		return null;
	}

	@Override
	public Loaihaisan findByid(Serializable id) {
		// TODO Auto-generated method stub
				SessionFactory sf=HibernateUti.getSessionFactory();
				Session sess=sf.openSession();
				Transaction tx=sess.beginTransaction();
				try {
					Loaihaisan c=(Loaihaisan) sess.get(Loaihaisan.class,id);
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
			Loaihaisan c=(Loaihaisan) sess.get(Loaihaisan.class,id);
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
	public boolean add(Loaihaisan t) {
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
	public boolean update(Loaihaisan t) {
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
