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

import com.neusoft.po.PayeeList;

/**
 * A data access object (DAO) providing persistence and search support for
 * PayeeList entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.neusoft.po.PayeeList
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PayeeListDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PayeeListDAO.class);

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

	public void save(PayeeList transientInstance) {
		log.debug("saving PayeeList instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PayeeList persistentInstance) {
		log.debug("deleting PayeeList instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PayeeList findById(java.lang.Integer id) {
		log.debug("getting PayeeList instance with id: " + id);
		try {
			PayeeList instance = (PayeeList) getCurrentSession().get(
					"com.neusoft.po.PayeeList", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PayeeList instance) {
		log.debug("finding PayeeList instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.neusoft.po.PayeeList")
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
		log.debug("finding PayeeList instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PayeeList as model where model."
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
		log.debug("finding all PayeeList instances");
		try {
			String queryString = "from PayeeList";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PayeeList merge(PayeeList detachedInstance) {
		log.debug("merging PayeeList instance");
		try {
			PayeeList result = (PayeeList) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PayeeList instance) {
		log.debug("attaching dirty PayeeList instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PayeeList instance) {
		log.debug("attaching clean PayeeList instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PayeeListDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PayeeListDAO) ctx.getBean("PayeeListDAO");
	}
}