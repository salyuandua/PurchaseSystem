package com.purchase.project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.purchase.bean.Project;
@Repository
@Transactional(rollbackFor=Exception.class)
public class DefaultProjectDao implements ProjectDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		
			Session session=sessionFactory.getCurrentSession();
			//session.beginTransaction();
			List<Project> projects= session.createQuery("from Project").list();
			//session.getTransaction().commit();
			return projects;

		

	}



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
