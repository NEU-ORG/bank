package com.neusoft.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.po.Endorsement;

/**
 * A data access object (DAO) providing persistence and search support for
 * Endorsement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.neusoft.po.Endorsement
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class EndorsementDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EndorsementDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Endorsement transientInstance) {
		log.debug("saving Endorsement instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Endorsement persistentInstance) {
		log.debug("deleting Endorsement instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Endorsement findById(java.lang.Integer id) {
		log.debug("getting Endorsement instance with id: " + id);
		try {
			Endorsement instance = (Endorsement) getCurrentSession().get(
					"com.neusoft.po.Endorsement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Endorsement instance) {
		log.debug("finding Endorsement instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.neusoft.po.Endorsement")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Endorsement instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Endorsement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Endorsement instances");
		try {
			String queryString = "from Endorsement";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Endorsement merge(Endorsement detachedInstance) {
		log.debug("merging Endorsement instance");
		try {
			Endorsement result = (Endorsement) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Endorsement instance) {
		log.debug("attaching dirty Endorsement instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Endorsement instance) {
		log.debug("attaching clean Endorsement instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EndorsementDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EndorsementDAO) ctx.getBean("EndorsementDAO");
	}
}