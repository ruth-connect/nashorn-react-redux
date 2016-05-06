package com.connect_group.nashorn_react_redux.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.ITemplateModeHandler;

import com.connect_group.nashorn_react_redux.thymeleaf.NashornReactReduxDialect;
import com.connect_group.nashorn_react_redux.thymesheet.SpringBootThymesheetTemplateModeHandler;
import com.connect_group.thymesheet.spring4.SpringThymesheetTemplateEngine;

@Configuration
public class SpringBootThymesheetConfig {

	@Autowired
	private ServletContext servletContext;
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false); // This would be set to true in a live production environment.
		templateResolver.initialize();
		return templateResolver;
	}
	
	@Bean
	public SpringThymesheetTemplateEngine templateEngine() {
		SpringThymesheetTemplateEngine templateEngine = new SpringThymesheetTemplateEngine();
		
		Set<ITemplateModeHandler> templateModeHandlers = new HashSet<>();
		SpringBootThymesheetTemplateModeHandler templateModeHandler = new SpringBootThymesheetTemplateModeHandler();
		templateModeHandler.setServletContext(servletContext);
		templateModeHandlers.add(templateModeHandler);
		templateEngine.setTemplateModeHandlers(templateModeHandlers);
		
		templateEngine.setTemplateResolver(templateResolver());
		
		Set<IDialect> additionalDialects = new HashSet<>();
		additionalDialects.add(new NashornReactReduxDialect());
		templateEngine.setAdditionalDialects(additionalDialects);
		
		return templateEngine;
	}
}
