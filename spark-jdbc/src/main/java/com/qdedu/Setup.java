/**
 * Setup.java
 * com.qdedu
 * Copyright (c) 2017, 北京聚智未来科技有限公司版权所有.
*/

package com.qdedu;

import javax.servlet.ServletContext;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.we.core.web.util.FtlUtil;

import freemarker.template.Configuration;

/**
 * 启动
 * <p>
 * 应用的启动入口
 *
 * @author   ZhuangJunxiang(529272571@qq.com)
 * @Date	 2017年4月10日
 */
@Component
@org.springframework.context.annotation.Configuration
@EnableApolloConfig(value = "application", order = 10)
public class Setup implements ServletContextAware {

	@Override
	public void setServletContext(final ServletContext context) {
		WebApplicationContext act = ContextLoader.getCurrentWebApplicationContext();
		FtlUtil.initConfiguration((Configuration) act.getBean("configuration"), context, "/", "config/ftl.properties");
	}
}
