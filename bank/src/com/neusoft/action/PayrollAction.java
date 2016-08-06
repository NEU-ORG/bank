package com.neusoft.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.neusoft.bo.GroupManager;
import com.neusoft.bo.LogManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PayrollAction extends ActionSupport{
	private File[] uploadImages; // 得到上传的文件
	private String[] uploadImagesContentType; // 得到文件的类型
	private String[] uploadImagesFileName; // 得到文件的名
	private GroupManager groupManager;
	private LogManager logManager;
	
	private String aselect;
	private String pwd;

	public void addlogmsg(String type, String message) {
		Map<String,Object> session = ActionContext.getContext().getSession();
		String operator = (String) session.get("loginInfo");
		logManager.addLog(operator, type, message);
	}
	
	public String upload() throws Exception {
//		System.out.println("aid:"+aselect);
//		System.out.println("pwd:"+pwd);
		Integer aid = Integer.parseInt(aselect);
		Map request  = (Map) ActionContext.getContext().get("request");
		int t1 = groupManager.judgeTransPwd(aid, pwd);
		if(t1 != 0) {
			request.put("errormsg", "密码错误");
			System.out.println("error");
			return "success";
		}
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/images");
		System.out.println("realpath" + realpath);
		File file = new File(realpath);
		if (!file.exists()) {
			System.out.println("no file");
			file.mkdirs();
		}
		//System.out.println("u:"+uploadImages);
		if(uploadImages == null) {
			request.put("errormsg", "请选择文件");
			System.out.println("no file select");
			return "success";
		}
		for (int i = 0; i < uploadImages.length; i++) {
			File uploadImage = uploadImages[i];
			FileUtils.copyFile(uploadImage, new File(file, uploadImagesFileName[i]));
			//System.out.println(FileUtils.readFileToString(uploadImage));
			FileInputStream fis = new FileInputStream(uploadImage); 
			jxl.Workbook rwb = Workbook.getWorkbook(fis);
			Sheet[] sheet = rwb.getSheets();
			List<Map<String, String> > l = new ArrayList<Map<String, String> >();
			for(int j=0;j<sheet.length;j++) {
				Sheet rs = rwb.getSheet(j);
				for(int k=0;k<rs.getRows();k++) {
					Cell[] cells = rs.getRow(k);
					//System.out.println("cl:"+cells.length);
					if(cells.length != 2) {
						request.put("errormsg", "文件书写格式错误");
						System.out.println("file error");
						return "success";
					}
					for(int m=0;m<cells.length;m++) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("account", cells[0].getContents());
						map.put("pay", cells[1].getContents());
						l.add(map);
						//System.out.println("data:"+cells[m].getContents());
					}
				}
			}
			int t = groupManager.payroll(aid, l);
			System.out.println("t:"+t);
			fis.close();
			if(t != 0) {
				if(t == -1)
					request.put("errormsg", "代发工资出错");
				else if(t == -2 || t == -4 || t == 1)
					request.put("errormsg", "账户重复");
				else if(t == -3)
					request.put("errormsg", "金额不足");
				return SUCCESS;
			}
		}
		request.put("errormsg", "代发工资成功");
		this.addlogmsg("交易", "代发工资"+aid);
		return "success";
	}

	public String execute() throws Exception {
		return upload();
	}
	
	public File[] getUploadImages() {
		return uploadImages;
	}

	public void setUploadImages(File[] uploadImages) {
		this.uploadImages = uploadImages;
	}

	public String[] getUploadImagesContentType() {
		return uploadImagesContentType;
	}

	public void setUploadImagesContentType(String[] uploadImagesContentType) {
		this.uploadImagesContentType = uploadImagesContentType;
	}

	public String[] getUploadImagesFileName() {
		return uploadImagesFileName;
	}

	public void setUploadImagesFileName(String[] uploadImagesFileName) {
		this.uploadImagesFileName = uploadImagesFileName;
	}

	public GroupManager getGroupManager() {
		return groupManager;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}

	public String getAselect() {
		return aselect;
	}

	public void setAselect(String aselect) {
		this.aselect = aselect;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public LogManager getLogManager() {
		return logManager;
	}

	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}
}
