package com.connect_group.nashorn_react_redux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

@Configuration
public class ViewConfig {

    private static final String[] scripts = {
        "static/js/polyfill.js",
        "static/js/ejs.min.js",
        "static/js/render.js",
        "static/js/bundle.js"
    };

    @Bean
    public ViewResolver reactViewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("templates/");
        return viewResolver;
    }

    @Bean
    public ScriptTemplateConfigurer reactConfigurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        configurer.setEngineName("nashorn");
        configurer.setScripts(scripts);
        configurer.setRenderFunction("render");

        // Nashorn is not thread safe -> this will use a ThreadLocal ScriptEngine.
        configurer.setSharedEngine(false);
        return configurer;
    }
}