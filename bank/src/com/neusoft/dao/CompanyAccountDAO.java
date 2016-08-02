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

import com.neusoft.po.CompanyAccount;

/**
 * A data access object (DAO) providing persistence and search support for
 * CompanyAccount entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.neusoft.po.CompanyAccount
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CompanyAccountDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanyAccountDAO.class);

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

	public void save(CompanyAccount transientInstance) {
		log.debug("saving CompanyAccount instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompanyAccount persistentInstance) {
		log.debug("deleting CompanyAccount instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompanyAccount findById(java.lang.Integer id) {
		log.debug("getting CompanyAccount instance with id: " + id);
		try {
			CompanyAccount instance = (CompanyAccount) getCurrentSession().get(
					"com.neusoft.po.CompanyAccount", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompanyAccount instance) {
		log.debug("finding CompanyAccount instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.neusoft.po.CompanyAccount")
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
		log.debug("finding CompanyAccount instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CompanyAccount as model where model."
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
		log.debug("finding all CompanyAccount instances");
		try {
			String queryString = "from CompanyAccount";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompanyAccount merge(CompanyAccount detachedInstance) {
		log.debug("merging CompanyAccount instance");
		try {
			CompanyAccount result = (CompanyAccount) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompanyAccount instance) {
		log.debug("attaching dirty CompanyAccount instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompanyAccount instance) {
		log.debug("attaching clean CompanyAccount instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyAccountDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyAccountDAO) ctx.getBean("CompanyAccountDAO");
	}
}