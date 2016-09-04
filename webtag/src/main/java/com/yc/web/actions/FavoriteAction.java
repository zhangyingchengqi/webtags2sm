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
import com.opensymphony.xwork2.ModelDriven;
import com.yc.bean.Favorite;
import com.yc.bean.JsonModel;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.TagBiz;
import com.yc.biz.impl.FavoriteBizImpl;
import com.yc.biz.impl.TagBizImpl;
import com.yc.common.YcConstants;

public class FavoriteAction extends ActionSupport implements
		ModelDriven<Favorite>, ServletContextAware {
	private static final long serialVersionUID = 1010376690376126207L;

	private FavoriteBiz favoriteBiz;
	private JsonModel jsonModel;
	private Favorite favorite;
	private ServletContext application;

	public void add() throws IOException {
		HttpServletResponse response=		ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out=response.getWriter();
		jsonModel = new JsonModel();
		try {
			Map<String, Tag> tagMap = null;
			if (application.getAttribute(YcConstants.ALLTAG) != null) {
				tagMap = (Map<String, Tag>) application
						.getAttribute(YcConstants.ALLTAG);
			}
			favoriteBiz.addFavorite(favorite, tagMap);
			jsonModel.setCode(1);
			jsonModel.setMsg("success");
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			jsonModel.setMsg(e.getMessage());
		}
		Gson g = new Gson();
		String s = g.toJson(jsonModel);
		out.println(    s  );
		out.flush();
		out.close();
	}

	public void  findAll() throws IOException {
		HttpServletResponse response=		ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out=response.getWriter();
		jsonModel = new JsonModel();
		try {
			List<Favorite> list = null;
			list = favoriteBiz.findFavoriteByTagName(favorite);
			jsonModel.setCode(1);
			jsonModel.setObj(list);
		} catch (Exception e) {
			e.printStackTrace();
			jsonModel.setCode(0);
			jsonModel.setMsg(e.getMessage());
		}
		Gson g = new Gson();
		String s = g.toJson(jsonModel);
		out.println(    s  );
		out.flush();
		out.close();

	}

	public void setFavoriteBiz(FavoriteBiz favoriteBiz) {
		this.favoriteBiz = favoriteBiz;
	}

	public JsonModel getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(JsonModel jsonModel) {
		this.jsonModel = jsonModel;
	}

	public Favorite getModel() {
		favorite = new Favorite();
		return favorite;
	}

	public void setServletContext(ServletContext arg0) {
		this.application = arg0;
	}

}
