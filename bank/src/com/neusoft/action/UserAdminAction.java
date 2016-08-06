package com.neusoft.action;

import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bo.AdminManager;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AdminDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Account;
import com.neusoft.po.Admin;
import com.neusoft.po.Constant;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAdminAction  extends ActionSupport{
	private AdminManager adminManager;
	private String name;
	private String password;
	private double value;
	private String text;
	private int benefitID;
	private int id;
	private String flag;
	private int nameID;
	private int adminName;
	private String newPassword;
	public String changeTPassword() {
		//Map<String, Object> session = ActionContext.getContext().getSession();
		/*Set companyAccounts = companyManager
				.getAccountInfo((String) ActionContext.getContext()
						.getSession().get("loginInfo"));*/
		Map<String, Object> session = ActionContext.getContext().getSession();
		String name = (String)session.get("loginInfo");
		Map request = (Map) ActionContext.getContext().get("request");
		//request.put("companyAccounts", companyAccounts);
		if()
		if (adminManager.checkOutTPassword(name, password)) {
			adminManager.changeTPassword(name, newPassword);
		} else {
			request.put("passwordError", "ÃÜÂë²»ÕýÈ·£¡£¡");
		}
		return "changeTPassword";
	}
	public String loginOut(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("loginInfo");
		return "loginOut";
	}
	public String signUp(){
		/*Map request = (Map) ActionContext.getContext().get("request");*/
		Map<String, Object> session = ActionContext.getContext().getSession();
		Map request = (Map)ActionContext.getContext().get("request");
		if(adminManager.checkOutLogin(name, password))
		{
			
			session.put("loginInfo", name);
			return "success_admin";
		}
		else
		{
			//Map<String, Object> session = ActionContext.getContext().getSession();
			request.put("FailLogin", "µÇÂ½Ê§°Ü");
			return "error2";
		}
	}
	public String benefitShow()
	{
		return "benefitShow";
	}
	//public String 
/*	public String setCurrent()
	{
		adminManager.currentBenefitSet(value);
		return "";
	}*/
	public String changeBenefit()
	{
		Map<String, Object> request = (Map)ActionContext.getContext().get("request");
		request.put("benefits", adminManager.getBenefitList());
		return "admin_changeBenefit";
	}
	public String benefitSet()
	{
		adminManager.scheduledBenefitSet(benefitID, value, text);
		//System.out.println("text"+text);
		//adminManager.scheduledBenefitSet(value, text);
		return "success";
		
	}
	
	public AdminManager getAdminManager() {
		return adminManager;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBenefitID() {
		return benefitID;
	}
	public void setBenefitID(int benefitID) {
		this.benefitID = benefitID;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setNameID(int nameID) {
		this.nameID = nameID;
	}
	public void setAdminName(int adminName) {
		this.adminName = adminName;
	}
	public int getNameID() {
		return nameID;
	}
	public int getAdminName() {
		return adminName;
	}
	
	



}
