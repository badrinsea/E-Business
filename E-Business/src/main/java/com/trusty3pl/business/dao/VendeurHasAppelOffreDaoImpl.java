package com.trusty3pl.business.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trusty3pl.business.model.VendeurHasAppelOffre;

@Repository("vendeurhasappeloffreDao")
public class VendeurHasAppelOffreDaoImpl implements VendeurHasAppelOffreDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public VendeurHasAppelOffre findById(String id) {
		Session session = this.sessionFactory.openSession();
		VendeurHasAppelOffre p = (VendeurHasAppelOffre) session.load(VendeurHasAppelOffre.class, id);
		return p;
	}

	@Override
	public boolean save(VendeurHasAppelOffre c1) {
		boolean isav=false;
		Session session = this.sessionFactory.openSession();
		session.persist(c1);
		session.flush();
		isav= true;
		return isav;
	}

	@Override
	public boolean delete(String c1) {
		Session session = this.sessionFactory.getCurrentSession();
		VendeurHasAppelOffre p = (VendeurHasAppelOffre) session.load(VendeurHasAppelOffre.class, c1);
		if(null != p){
			session.delete(p);
			return true;
		}
        return false;
	}

	@Override
	public boolean update(VendeurHasAppelOffre c1) {
		Session session = this.sessionFactory.openSession();
		session.update(c1);
		session.flush();

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VendeurHasAppelOffre> findAllUsers() {
		Session session = this.sessionFactory.openSession();
		List<VendeurHasAppelOffre> cartList = (List<VendeurHasAppelOffre>)session.createQuery("from VendeurHasAppelOffre").list();
		return cartList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
