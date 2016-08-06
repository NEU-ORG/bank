package com.neusoft.bo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.dao.ConstantDAO;
import com.neusoft.dao.LogDAO;
import com.neusoft.po.Log;

public class LogManager {
	private LogDAO logDao;
	public void logOut(String operator, String type, String message)
	{
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		LogDAO log = (LogDAO) ctx.getBean("LogDAO");*/
		Log log = new Log();
		log.setOperator(operator);
		log.setType(type);
		log.setMessage(message);
		logDao.save(log);
		//log.attachDirty(log);
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
