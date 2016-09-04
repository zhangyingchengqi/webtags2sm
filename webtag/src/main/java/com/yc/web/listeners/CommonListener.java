package com.yc.web.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//适配器
/**
 * 在web项目中，如果想在j2ee对象中取出spring容器,必须考虑使用   WebApplicationContextUtils.getWebAplicationContext() 才能取到spring容器.
 * 而不能使用  new ClassPathXmlApplicationContext(),因为这样会创建另外一个spring容器.
 * 
 * 扩展: j2ee对象中取spring容器，都要按这种方式
 *
 */
public abstract class CommonListener implements ServletContextListener,
		ServletContextAttributeListener, HttpSessionListener,
		HttpSessionAttributeListener {

	/**
	 * 通过WebApplicationContextUtils 得到Spring容器的实例。根据bean的名称返回bean的实例。
	 * 
	 * @param servletContext
	 *            ：ServletContext上下文。
	 * @param beanName
	 *            :要取得的Spring容器中Bean的名称。
	 * @return 返回Bean的实例。
	 */
	protected Object getObjectFromApplication(ServletContext servletContext,
			String beanName) {
		// 通过WebApplicationContextUtils 得到Spring容器的实例。     
		ApplicationContext ac = WebApplicationContextUtils                     
				.getWebApplicationContext(servletContext);
		// 返回Bean的实例。
		return ac.getBean(beanName);
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {

	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {

	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}

	public void sessionCreated(HttpSessionEvent arg0) {

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {

	}

	public void attributeAdded(ServletContextAttributeEvent arg0) {

	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {

	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {

	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {

	}

}
