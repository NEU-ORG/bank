package com.neusoft.bo;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.neusoft.dao.CompanyAccountDAO;
import com.neusoft.dao.CompanyOperatorDAO;
import com.neusoft.dao.CompanyTransactionDetailDAO;
import com.neusoft.po.Account;
import com.neusoft.po.CompanyAccount;
import com.neusoft.po.CompanyOperator;
import com.neusoft.po.CompanyTransactionDetail;
import com.neusoft.po.TransactionDetail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GroupManager  extends ActionSupport {
	private ApplicationContext ctx;
	
	private CompanyAccountDAO caDAO;
	private CompanyTransactionDetailDAO ctDAO;
	private CompanyOperatorDAO coDAO;
	
	//0-成功；-1-无账户；-2：密码错误
	public int judgeTransPwd(Integer aid, String password) {
		CompanyAccount ca = caDAO.findById(aid);
		if(ca.equals(null)) {
			System.out.println("null");
			return -1;
		}
		//System.out.println("1:"+password);
		String pwd = ca.getTransactionPassword();
		if(!pwd.equals(password))
			return -2;
		return 0;
	}
	
	//重复用户-2；
	public int payroll(int aid, List<Map<String, String> > l) {
		CompanyAccount ca = caDAO.findById(aid);
		Double mainpay = 0.0;
		for(int i=0;i<l.size();i++) {
			if(ca.getAccountNumber().equals(l.get(i).get("account")))
				return -2;
			mainpay = mainpay + Double.parseDouble(l.get(i).get("pay"));
		}
		System.out.println("mainpay:"+mainpay);
		if(ca.getAvailableBalance() < mainpay)
			return -3;
		for(int i=0;i<l.size();i++) {
			String tanum = l.get(i).get("account");
			String p = l.get(i).get("pay");
			Double pay = Double.parseDouble(p);
			System.out.println("taid:"+tanum);
			System.out.println("pay:"+pay);
			int t2 = this.payroll_transfer(aid, tanum, pay);
			if(t2 != 0)
				return t2;
		}
		return 0;
	}
	
	public int payroll_transfer(int aid, String tanum, double pay) {
		Map<String,Object> session = ActionContext.getContext().getSession();
		String operator = (String) session.get("loginInfo");
		CompanyOperator co = (CompanyOperator) coDAO.findByProperty("managerName", operator).get(0);
		//System.out.println("o:"+operator);
		CompanyAccount ca = caDAO.findById(aid);
		if(ca.equals(null)) {
			System.out.println("a null");
			return -1;
		}
		List<CompanyAccount> tcal = caDAO.findByProperty("accountNumber", tanum);
		if(tcal.size() != 1) {
			System.out.println("a null");
			return -1;
		}
		CompanyAccount tca = tcal.get(0);
		if(ca.getId().equals(tca.getId()))
			return -4;
		double ab = ca.getBalance();
		double aab = ca.getAvailableBalance();
		double tab = tca.getBalance();
		double taab = tca.getAvailableBalance();
		if(aab < pay) {
			System.out.println("no");
			return 1;
		}
		ca.setAvailableBalance(aab-pay);
		ca.setBalance(ab-pay);
		tca.setBalance(tab+pay);
		tca.setAvailableBalance(taab+pay);
		caDAO.attachDirty(ca);
		caDAO.attachDirty(tca);
		CompanyTransactionDetail td1 = new CompanyTransactionDetail();
		CompanyTransactionDetail td2 = new CompanyTransactionDetail();
		td1.setCompanyOperator(co);
		td2.setCompanyOperator(co);
		td1.setCompanyAccountByAccountId(ca);
		td1.setCompanyAccountByTargetAccount(tca);
		td2.setCompanyAccountByAccountId(tca);
		td2.setCompanyAccountByTargetAccount(ca);
		td1.setAmountPaid(pay);
		td1.setAmountReceived(0.00);
		td2.setAmountPaid(0.00);
		td2.setAmountReceived(pay);
		td1.setBalance(ca.getBalance());
		td2.setBalance(tca.getBalance());
		td1.setType("代发工资");
		td2.setType("工资");
		td1.setCurrency("CNY");
		td2.setCurrency("CNY");
		ctDAO.save(td1);
		ctDAO.save(td2);
		return 0;
	}
	
	//0：成功；-1：无账户；-2：无目标账户；-3：跨行;-4:相同账户
	//1：金额不足
	public int transfer(int aid, int taid, double pay) {
		Map<String,Object> session = ActionContext.getContext().getSession();
		String operator = (String) session.get("loginInfo");
		CompanyOperator co = (CompanyOperator) coDAO.findByProperty("managerName", operator).get(0);
		//System.out.println("o:"+operator);
		CompanyAccount ca = caDAO.findById(aid);
		if(ca.equals(null)) {
			System.out.println("a null");
			return -1;
		}
		CompanyAccount tca = caDAO.findById(taid);
		if(tca.equals(null)) {
			System.out.println("a null");
			return -1;
		}
		if(ca.getId().equals(tca.getId()))
			return -4;
//		if(!tca.getBank().getType().equals(ca.getBank().getType())) {
//			return -3;
//		}
		double ab = ca.getBalance();
		double aab = ca.getAvailableBalance();
		double tab = tca.getBalance();
		double taab = tca.getAvailableBalance();
		if(aab < pay) {
			System.out.println("no");
			return 1;
		}
		ca.setAvailableBalance(aab-pay);
		ca.setBalance(ab-pay);
		tca.setBalance(tab+pay);
		tca.setAvailableBalance(taab+pay);
		caDAO.attachDirty(ca);
		caDAO.attachDirty(tca);
		CompanyTransactionDetail td1 = new CompanyTransactionDetail();
		CompanyTransactionDetail td2 = new CompanyTransactionDetail();
		td1.setCompanyOperator(co);
		td2.setCompanyOperator(co);
		td1.setCompanyAccountByAccountId(ca);
		td1.setCompanyAccountByTargetAccount(tca);
		td2.setCompanyAccountByAccountId(tca);
		td2.setCompanyAccountByTargetAccount(ca);
		td1.setAmountPaid(pay);
		td1.setAmountReceived(0.00);
		td2.setAmountPaid(0.00);
		td2.setAmountReceived(pay);
		td1.setBalance(ca.getBalance());
		td2.setBalance(tca.getBalance());
		td1.setType("转账");
		td2.setType("收款");
		td1.setCurrency("CNY");
		td2.setCurrency("CNY");
		ctDAO.save(td1);
		ctDAO.save(td2);
		return 0;
	}
	
	public int transferall(int aid, int taid) {
		Map<String,Object> session = ActionContext.getContext().getSession();
		String operator = (String) session.get("loginInfo");
		CompanyOperator co = (CompanyOperator) coDAO.findByProperty("managerName", operator).get(0);
		//System.out.println("o:"+operator);
		CompanyAccount ca = caDAO.findById(aid);
		if(ca.equals(null)) {
			System.out.println("a null");
			return -1;
		}
		CompanyAccount tca = caDAO.findById(taid);
		if(tca.equals(null)) {
			System.out.println("a null");
			return -1;
		}
		if(ca.getId().equals(tca.getId()))
			return -4;
//		if(!tca.getBank().getType().equals(ca.getBank().getType())) {
//			return -3;
//		}
		double ab = ca.getBalance();
		double aab = ca.getAvailableBalance();
		double tab = tca.getBalance();
		double taab = tca.getAvailableBalance();
		
		double pay = ca.getAvailableBalance();
		
		ca.setAvailableBalance(aab-pay);
		ca.setBalance(ab-pay);
		tca.setBalance(tab+pay);
		tca.setAvailableBalance(taab+pay);
		caDAO.attachDirty(ca);
		caDAO.attachDirty(tca);
		CompanyTransactionDetail td1 = new CompanyTransactionDetail();
		CompanyTransactionDetail td2 = new CompanyTransactionDetail();
		td1.setCompanyOperator(co);
		td2.setCompanyOperator(co);
		td1.setCompanyAccountByAccountId(ca);
		td1.setCompanyAccountByTargetAccount(tca);
		td2.setCompanyAccountByAccountId(tca);
		td2.setCompanyAccountByTargetAccount(ca);
		td1.setAmountPaid(pay);
		td1.setAmountReceived(0.00);
		td2.setAmountPaid(0.00);
		td2.setAmountReceived(pay);
		td1.setBalance(ca.getBalance());
		td2.setBalance(tca.getBalance());
		td1.setType("转账");
		td2.setType("收款");
		td1.setCurrency("CNY");
		td2.setCurrency("CNY");
		ctDAO.save(td1);
		ctDAO.save(td2);
		return 0;
	}
	
	public CompanyAccountDAO getCaDAO() {
		return caDAO;
	}
	public void setCaDAO(CompanyAccountDAO caDAO) {
		this.caDAO = caDAO;
	}
	public CompanyTransactionDetailDAO getCtDAO() {
		return ctDAO;
	}
	public void setCtDAO(CompanyTransactionDetailDAO ctDAO) {
		this.ctDAO = ctDAO;
	}

	public CompanyOperatorDAO getCoDAO() {
		return coDAO;
	}

	public void setCoDAO(CompanyOperatorDAO coDAO) {
		this.coDAO = coDAO;
	}
}
