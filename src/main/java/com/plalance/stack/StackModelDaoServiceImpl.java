package com.plalance.stack;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.plalance.configuration.HibernateUtil;
import com.plalance.services.StackModelDaoService;

public class StackModelDaoServiceImpl<T, V extends Serializable> implements StackModelDaoService<T, V>{

	private final Class<T> entityType;
	private final Class<V> idType;

	@SuppressWarnings("unchecked")
	public StackModelDaoServiceImpl() {
		this.entityType = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.idType = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
	}

	/**
	 * Generic List Method
	 * 
	 * @return List<T> defined in StackModelDao<T> heritage
	 */
	public List<T> list() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return session.createQuery(String.format("from %s", this.entityType.getSimpleName()), this.entityType)
					.list();
		}

	}

	/**
	 * Generic Find Method
	 * 
	 * @return T or null;
	 */
	public T find(V id) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			T obj = session.get(this.entityType, id);

			return obj;
		}

	}

	/**
	 *
	 * Generic Save Method
	 */
	@Override
	public boolean save(T obj) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();

			Serializable id = session.save(obj);

			session.getTransaction().commit();

			return id != null;
		}
	}

	/**
	 * Generic Delete Method
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(V id) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			session.beginTransaction();
			
			Object persistentInstance = session.load(this.entityType, id);

			if (persistentInstance != null) {
				session.delete(persistentInstance);
				
				session.getTransaction().commit();
				return true;
			}

			return false;
		}

	}
}
