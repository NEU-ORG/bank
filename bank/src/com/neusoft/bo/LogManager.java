package com.neusoft.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.ConstantDAO;
import com.neusoft.dao.LogDAO;
import com.neusoft.po.CompanyAccount;
import com.neusoft.po.CompanyTransactionDetail;
import com.neusoft.po.Log;

public class LogManager {
	private LogDAO logDao;
	public void addLog(String operator, String type, String message)
	{
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		LogDAO log = (LogDAO) ctx.getBean("LogDAO");*/
		Log log = new Log();
		log.setOperator(operator);
		log.setType(type);
		log.setMessage(message);
		log.setTime(new Timestamp(System.currentTimeMillis()));
		logDao.save(log);
		//log.attachDirty(log);
	}
	
	public List getTransactionDetail(Date begin, Date end) {
		//List log = logDao.findByProperty("operator", operator);
		if(begin != null && end != null){
			List log = logDao.findAll();
			Iterator<Log> iterator = log.iterator();
			List it = new ArrayList();
			//Set<Log> out = 
			while(iterator.hasNext()){
				Log temp = new Log();
				temp = iterator.next();
				if(temp.getTime().after(begin)
						&&temp.getTime().before(end)){
					it.add(temp);
				}
			}
			return it;
		}
		else {
			return null;
		}

	}
	
	public List logShow()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		LogDAO log = (LogDAO) ctx.getBean("LogDAO");
		return log.findAll();
	}
	public List getLogList()
	{
		return logDao.findAll();
	}

	public LogDAO getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDAO logDao) {
		this.logDao = logDao;
	}
	

}
