package com.connect_group.nashorn_react_redux.thymesheet;

import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.web.context.ServletContextAware;
import org.thymeleaf.templateparser.html.LegacyHtml5TemplateParser;
import org.thymeleaf.templatewriter.XhtmlHtml5TemplateWriter;

import com.connect_group.thymesheet.templatemode.ThymesheetTemplateModeHandler;

public class SpringBootThymesheetTemplateModeHandler extends ThymesheetTemplateModeHandler implements ServletContextAware {

	private static final Logger log = Logger.getLogger(SpringBootThymesheetTemplateModeHandler.class);
	private static final String TEMPLATE_MODE_NAME = "HTML5";
	private static final int MAX_PARSERS_POOL_SIZE = 24;
	
	private final SpringBootThymesheetLocator thymeleafDemoThymesheetLocator;
	
	public SpringBootThymesheetTemplateModeHandler() {
		super(TEMPLATE_MODE_NAME, new LegacyHtml5TemplateParser("HTML5", getPoolSize()), new XhtmlHtml5TemplateWriter(), new SpringBootThymesheetLocator());
		this.thymeleafDemoThymesheetLocator = (SpringBootThymesheetLocator)thymesheetLocator;
		
		if (log.isInfoEnabled()) {
			log.info("ThymeleafDemoTemplateModeHandler constructor invoked");
		}
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.thymeleafDemoThymesheetLocator.setServletContext(servletContext);
	}
	
	public void setThymesheetSuffixes(Set<String> suffixes) {
		for (String suffix : suffixes) {
			thymeleafDemoThymesheetLocator.addThymesheetSuffix(suffix);
		}
	}
	
	private static final int getPoolSize() {
		final int availableProcessors = Runtime.getRuntime().availableProcessors();
		final int poolSize = Math.min((availableProcessors <= 2 ? availableProcessors : availableProcessors - 1), MAX_PARSERS_POOL_SIZE);
		return poolSize;
	}
}
