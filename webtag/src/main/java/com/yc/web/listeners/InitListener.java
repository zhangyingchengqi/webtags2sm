package com.yc.web.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yc.bean.Tag;
import com.yc.biz.TagBiz;
import com.yc.common.YcConstants;

//       implements ServletContextListener
public class InitListener extends  CommonListener {

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		
		//                      new Annotation
		//ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");  //创建一次容器
		//ac=getBean("tagBiz");
		
		TagBiz tb=(TagBiz) super.getObjectFromApplication(arg0.getServletContext(), "tagBiz");
		Map<String, Tag> map=new HashMap<String,Tag>();
		try {
			map=tb.findAllTag();
			//application.setAttribute("",map);
			arg0.getServletContext().setAttribute( YcConstants.ALLTAG, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
