package com.neusoft.action;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bo.LogManager;
import com.neusoft.bo.UserManager;
import com.neusoft.dao.AccountDAO;
import com.neusoft.dao.AddressDAO;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.Address;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private LogManager logManager;
	private String realName;
	private String idNumber;
	private String cardNumber;
	private String userName;
	private String password;
	private String newPassword;
	private UserManager userManager;
	private String email;
	private String address;
	private String postCode;
	private String flag;
	
	public String logout(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		logManager.addLog((String)session.get("loginInfo"), "登出", "登出系统");
		session.remove("loginInfo");
		
		return "login";
	}
	
	public String changeUserName(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		if(userManager.checkOutLogin((String)session.get("loginInfo"), password)){
			userManager.changeUserName((String)session.get("loginInfo"),userName);
			request.put("loginInfo", userName);
			logManager.addLog((String)session.get("loginInfo"), "信息修改", "修改登录名");
		}else{
			request.put("passwordError","密码不正确！！");
		}
		return "changeUserName";
	}
	public String changePassword(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		if(userManager.checkOutLogin((String)session.get("loginInfo"), password)){
			userManager.changePassword((String)session.get("loginInfo"),newPassword);
			logManager.addLog((String)session.get("loginInfo"), "信息修改", "修改登陆密码");
		}else{
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("passwordError","密码不正确！！");
		}
		return "changePassword";
	}
	public String info(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map<String,Object> session = ActionContext.getContext().getSession();
		request.put("user",userManager.getUserInfo((String) session.get("loginInfo")));
		return "info";
	}
	public String changeUserInfo(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = userManager.changeUserInfo((String) session.get("loginInfo"), email, address, postCode);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddressDAO addressDAO = (AddressDAO) ctx.getBean("AddressDAO");
		List<Address> l = addressDAO.findAll();
		request.put("addresses",l);
		
		request.put("user",userManager.getUserInfo((String) session.get("loginInfo")));
		logManager.addLog((String)session.get("loginInfo"), "信息修改", "修改用户信息");
		return "changeUserInfo";
	}
	
	public String signIn() {	
		String result;
		Map<String,Object> session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");
		if(userName!=null&&userManager.checkOutLogin(userName, password)){
				session.put("loginInfo",userName);
				result = "success";
				logManager.addLog(userName, "登录", "登入系统");
		}else{
			request.put("loginError","用户名或密码不正确！！");
			result = "signIn";
		}
		return result;
		
	}
	public String signUp(){
		Map request = (Map) ActionContext.getContext().get("request");
		if(userManager.checkOutRegister(realName, idNumber, cardNumber,
				userName, password))
		{
			logManager.addLog(userName, "注册", "新用户注册");
			return "success";
		}
		else
		{
			return "sign_up";
		}
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public LogManager getLogManager() {
		return logManager;
	}

	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
