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

import com.neusoft.po.CreditcardApplyed;

/**
 * A data access object (DAO) providing persistence and search support for
 * CreditcardApplyed entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.neusoft.po.CreditcardApplyed
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CreditcardApplyedDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CreditcardApplyedDAO.class);

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

	public void save(CreditcardApplyed transientInstance) {
		log.debug("saving CreditcardApplyed instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CreditcardApplyed persistentInstance) {
		log.debug("deleting CreditcardApplyed instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CreditcardApplyed findById(java.lang.Integer id) {
		log.debug("getting CreditcardApplyed instance with id: " + id);
		try {
			CreditcardApplyed instance = (CreditcardApplyed) getCurrentSession()
					.get("com.neusoft.po.CreditcardApplyed", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CreditcardApplyed instance) {
		log.debug("finding CreditcardApplyed instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.neusoft.po.CreditcardApplyed")
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
		log.debug("finding CreditcardApplyed instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CreditcardApplyed as model where model."
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
		log.debug("finding all CreditcardApplyed instances");
		try {
			String queryString = "from CreditcardApplyed";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CreditcardApplyed merge(CreditcardApplyed detachedInstance) {
		log.debug("merging CreditcardApplyed instance");
		try {
			CreditcardApplyed result = (CreditcardApplyed) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CreditcardApplyed instance) {
		log.debug("attaching dirty CreditcardApplyed instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CreditcardApplyed instance) {
		log.debug("attaching clean CreditcardApplyed instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CreditcardApplyedDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CreditcardApplyedDAO) ctx.getBean("CreditcardApplyedDAO");
	}
}