package com.plalance.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.plalance.configuration.HibernateUtil;
import com.plalance.models.Animal;

public class AnimalDao {
	
	public List<Animal> list() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Animal", Animal.class).list();
		}
	}
	
	public boolean save(Animal obj) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            
			Serializable id = session.save(obj);
			
			session.getTransaction().commit();
			
			return id != null;
		}
	}
	
}