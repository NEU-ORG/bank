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

import com.neusoft.po.CreditCardBill;

/**
 * A data access object (DAO) providing persistence and search support for
 * CreditCardBill entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.neusoft.po.CreditCardBill
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CreditCardBillDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CreditCardBillDAO.class);

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

	public void save(CreditCardBill transientInstance) {
		log.debug("saving CreditCardBill instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CreditCardBill persistentInstance) {
		log.debug("deleting CreditCardBill instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CreditCardBill findById(java.lang.Integer id) {
		log.debug("getting CreditCardBill instance with id: " + id);
		try {
			CreditCardBill instance = (CreditCardBill) getCurrentSession().get(
					"com.neusoft.po.CreditCardBill", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CreditCardBill instance) {
		log.debug("finding CreditCardBill instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.neusoft.po.CreditCardBill")
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
		log.debug("finding CreditCardBill instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CreditCardBill as model where model."
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
		log.debug("finding all CreditCardBill instances");
		try {
			String queryString = "from CreditCardBill";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CreditCardBill merge(CreditCardBill detachedInstance) {
		log.debug("merging CreditCardBill instance");
		try {
			CreditCardBill result = (CreditCardBill) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CreditCardBill instance) {
		log.debug("attaching dirty CreditCardBill instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CreditCardBill instance) {
		log.debug("attaching clean CreditCardBill instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CreditCardBillDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CreditCardBillDAO) ctx.getBean("CreditCardBillDAO");
	}
}