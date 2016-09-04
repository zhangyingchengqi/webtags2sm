package com.yc.web.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.yc.bean.JsonModel;
import com.yc.bean.Tag;
import com.yc.biz.TagBiz;
import com.yc.biz.impl.TagBizImpl;
import com.yc.common.YcConstants;

public class TagAction extends ActionSupport implements ServletContextAware {
	private static final long serialVersionUID = -7260733931628288387L;
	private JsonModel jsonModel;
	private ServletContext application;

	public void findAll() throws IOException {
		HttpServletResponse response=		ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out=response.getWriter();
		jsonModel = new JsonModel();
		Map<String,Tag> map=null;
		if(   application.getAttribute(YcConstants.ALLTAG)!=null  ){
			map=(Map<String, Tag>) application.getAttribute(YcConstants.ALLTAG);
			jsonModel.setCode(1);
		}
		jsonModel.setObj( map );
		Gson g = new Gson();
		String s = g.toJson(jsonModel);
		out.println(    s  );
		out.flush();
		out.close();
	}

	public JsonModel getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(JsonModel jsonModel) {
		this.jsonModel = jsonModel;
	}

	public void setServletContext(ServletContext arg0) {
		this.application=arg0;
	}
	
	

}
