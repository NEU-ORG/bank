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

import com.neusoft.po.CompanyTransactionDetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * CompanyTransactionDetail entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.neusoft.po.CompanyTransactionDetail
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CompanyTransactionDetailDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanyTransactionDetailDAO.class);

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

	public void save(CompanyTransactionDetail transientInstance) {
		log.debug("saving CompanyTransactionDetail instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyTransactionDetail persistentInstance) {
		log.debug("deleting CompanyTransactionDetail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyTransactionDetail findById(java.lang.Integer id) {
		log.debug("getting CompanyTransactionDetail instance with id: " + id);
		try {
			CompanyTransactionDetail instance = (CompanyTransactionDetail) getCurrentSession()
					.get("com.neusoft.po.CompanyTransactionDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyTransactionDetail instance) {
		log.debug("finding CompanyTransactionDetail instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.neusoft.po.CompanyTransactionDetail")
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
		log.debug("finding CompanyTransactionDetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CompanyTransactionDetail as model where model."
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
		log.debug("finding all CompanyTransactionDetail instances");
		try {
			String queryString = "from CompanyTransactionDetail";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyTransactionDetail merge(
			CompanyTransactionDetail detachedInstance) {
		log.debug("merging CompanyTransactionDetail instance");
		try {
			CompanyTransactionDetail result = (CompanyTransactionDetail) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyTransactionDetail instance) {
		log.debug("attaching dirty CompanyTransactionDetail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyTransactionDetail instance) {
		log.debug("attaching clean CompanyTransactionDetail instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyTransactionDetailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyTransactionDetailDAO) ctx
				.getBean("CompanyTransactionDetailDAO");
	}
}