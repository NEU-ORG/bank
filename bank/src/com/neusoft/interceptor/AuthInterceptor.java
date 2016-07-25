package com.neusoft.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		if(session.get("loginInfo")!=null){
			return invocation.invoke();
		}else{
			return "login";
		}
		
	}

}
