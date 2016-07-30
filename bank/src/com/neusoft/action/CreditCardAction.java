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
import com.neusoft.po.CreditCardBill;
import com.neusoft.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreditCardAction extends ActionSupport {
	private int creditCardID;
	private CreditCardManager creditCardManager;// auto DI ???

	public String info() {
		Set cards = creditCardManager.getCardInfo((String) ActionContext
				.getContext().getSession().get("loginInfo"));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("creditCards", cards);
		return "info";
	}

	public String apply() {// …Í«Î–≈”√ø®
		return "apply";
	}

	public String application_progress() {
		return "application_progress";
	}

	public String report_loss() {// ø®∆¨π“ ß
		return "report_loss";
	}

	public String active() {// ø®∆¨º§ªÓ
		return "active";
	}

	public String checkedBill() {// “—≥ˆ’Àµ•≤È—Ø
		System.out.println(creditCardID);
		Map<String,Object> request = (Map) ActionContext.getContext().get("request");
		CreditCardBill checkedBill = creditCardManager.getCheckedBill(creditCardID);
		request.put("checkedBill",checkedBill);
		return "checkedBill";
	}

	public String uncheckedBill() {//need to check user<->card relationship;
		Map<String,Object> request = (Map) ActionContext.getContext().get("request");
		
		Set uncheckedBill = creditCardManager.getUncheckedBill(creditCardID);
		request.put("uncheckedBill", uncheckedBill);
		return "uncheckedBill";
	}

	public String changeSPassword() {

		return "changeSPassword";
	}

	public String changeTPassword() {

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

}
