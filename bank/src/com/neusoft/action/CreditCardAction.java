package com.neusoft.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bo.CreditCardManager;
import com.neusoft.dao.UserDAO;
import com.neusoft.po.CreditCard;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreditCardAction extends ActionSupport {
	private int creditCardID;
	private CreditCardManager creditCardManager;// auto DI ???
	private String password;
	private String newPassword;
	private String flag;
	public String info() {
		Set cards = creditCardManager.getCardInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("creditCards", cards);
		return "info";
	}

	public String apply() {// 申请信用卡
		if(flag!=null){
			creditCardManager.applyCreditCard((String) ActionContext.getContext().getSession().get("loginInfo"));
		}
		return "apply";
	}

	public String application_progress() {
		Set cardsApplyed = creditCardManager.getApplicationProgress((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("cardsApplyed", cardsApplyed);
		return "application_progress";
	}

	public String report_loss() {// 卡片挂失
		Set cards = creditCardManager.getCardInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("creditCards", cards);
		if(flag!=null){
			creditCardManager.reportLoss(creditCardID);
		}
		return "report_loss";
	}

	public String active() {// 卡片激活
		Set cards = creditCardManager.getCardInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("creditCards", cards);
		if(flag!=null){
			creditCardManager.activeCard(creditCardID);
		}
		return "active";
	}

	public String checkedBill() {// 已出账单查询
		Set cards = creditCardManager.getCardInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("creditCards", cards);
		
	
		//CreditCardBill checkedBill = creditCardManager.getCheckedBill(creditCardID);
		//request.put("checkedBill",checkedBill);
		return "checkedBill";
	}

	public String uncheckedBill() {//need to check user<->card relationship;
		Set cards = creditCardManager.getCardInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("creditCards", cards);
		if(flag!=null){
			Set uncheckedBill = creditCardManager.getUncheckedBill(creditCardID);
			request.put("uncheckedBill", uncheckedBill);
		}
		return "uncheckedBill";
	}

	public String changeSPassword() {
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		Map<String,Object> request = (Map) ActionContext.getContext().get("request");
		Set<CreditCard> cards = creditCardManager.getCardInfo((String) session.get("loginInfo"));
		request.put("cards", cards);
		
		if(creditCardManager.checkQueryPassword(creditCardID, password)){
			if(session.get("passwordError")!=null)
			{
				session.remove("passwordError");
			}
			creditCardManager.changeSPassword(creditCardID,newPassword);
		}else{
			session.put("passwordError","密码不正确！！");
		}
		return "changeSPassword";
	}

	public String changeTPassword() {
		Map<String,Object> session = ActionContext.getContext().getSession();
		Map<String,Object> request = (Map) ActionContext.getContext().get("request");
		Set<CreditCard> cards = creditCardManager.getCardInfo((String) session.get("loginInfo"));
		request.put("cards", cards);
		
		if(creditCardManager.checkTransactionPassword(creditCardID, password)){
			if(session.get("passwordError")!=null)
			{
				session.remove("passwordError");
			}
			creditCardManager.changeTPasssword(creditCardID,newPassword);
		}else{
			session.put("passwordError","密码不正确！！");
		}
		return "changeTPassword";
	}
	public String returnMain(){
		return "backMain";
	}

	public CreditCardManager getCreditCardManager() {
		return creditCardManager;
	}

	public void setCreditCardManager(CreditCardManager creditCardManager) {
		this.creditCardManager = creditCardManager;
	}

	public int getCreditCardID() {
		return creditCardID;
	}

	public void setCreditCardID(int creditCardID) {
		this.creditCardID = creditCardID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
