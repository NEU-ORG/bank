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

import com.neusoft.po.Companyaccount;

/**
 * A data access object (DAO) providing persistence and search support for
 * Companyaccount entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.neusoft.po.Companyaccount
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CompanyaccountDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanyaccountDAO.class);

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

	public void save(Companyaccount transientInstance) {
		log.debug("saving Companyaccount instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Companyaccount persistentInstance) {
		log.debug("deleting Companyaccount instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Companyaccount findById(java.lang.Integer id) {
		log.debug("getting Companyaccount instance with id: " + id);
		try {
			Companyaccount instance = (Companyaccount) getCurrentSession().get(
					"com.neusoft.po.Companyaccount", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Companyaccount instance) {
		log.debug("finding Companyaccount instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.neusoft.po.Companyaccount")
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
		log.debug("finding Companyaccount instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companyaccount as model where model."
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
		log.debug("finding all Companyaccount instances");
		try {
			String queryString = "from Companyaccount";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Companyaccount merge(Companyaccount detachedInstance) {
		log.debug("merging Companyaccount instance");
		try {
			Companyaccount result = (Companyaccount) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Companyaccount instance) {
		log.debug("attaching dirty Companyaccount instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Companyaccount instance) {
		log.debug("attaching clean Companyaccount instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyaccountDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyaccountDAO) ctx.getBean("CompanyaccountDAO");
	}
}