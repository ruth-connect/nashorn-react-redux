package com.connect_group.nashorn_react_redux.thymesheet;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.thymeleaf.dom.Document;

import com.connect_group.thymesheet.ThymesheetLocator;
import com.connect_group.thymesheet.impl.HtmlThymesheetLocator;

public class SpringBootThymesheetLocator extends HtmlThymesheetLocator implements ThymesheetLocator {

	private static final Logger log = Logger.getLogger(SpringBootThymesheetLocator.class);

	private ServletContext servletContext;
	private static final String PATH_PREFIX = "/templates/";
	private static final String DEFAULT_SUFFIX = ".tss";
	
	private final Set<String> thymesheetSuffixes = new HashSet<String>();
	
	@Override
	public List<String> getThymesheetPaths(Document document) {
		String path = document.getDocumentName();
		List<String> thymesheetPaths = getThymesheetPaths(path);
		thymesheetPaths.addAll(super.getThymesheetPaths(document));
		
		if (log.isInfoEnabled()) {
			log.info("getThymesheetPaths called");
			for (String thymesheetPath : thymesheetPaths) {
				log.info("Thymesheet Path: " + thymesheetPath);
			}
		}
		
		return thymesheetPaths;
	}
	
	@Override
	public void removeThymesheetLinks(Document document) {
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public void addThymesheetSuffix(String suffix) {
		if (suffix != null) {
			if (suffix.startsWith("*")) {
				suffix = suffix.substring(1);
			}
			thymesheetSuffixes.add(suffix);
		}
	}
	
	protected boolean isPathWithThymesheetSuffix(String path) {
		boolean result = false;
		if (path != null && path.length() > 0) {
			if (thymesheetSuffixes != null && !thymesheetSuffixes.isEmpty()) {
				for (String suffix : thymesheetSuffixes) {
					if (path.endsWith(suffix)) {
						result = true;
						break;
					}
				}
			} else {
				result = path.endsWith(DEFAULT_SUFFIX);
			}
		}
		return result;
	}
	
	private List<String> getThymesheetPaths(String documentPath) {
		String thymesheetPath = PATH_PREFIX + documentPath + ".tss";
		if (servletContext.getClassLoader().getClass().getResourceAsStream(thymesheetPath) != null) {
			if (log.isInfoEnabled()) {
				log.info("Found Thymesheet file: " + thymesheetPath);
			}
			return Collections.singletonList("classpath:" + thymesheetPath);
		} else {
			if (log.isInfoEnabled()) {
				log.info("Thymesheet file not present: " + thymesheetPath);
			}
			return Collections.emptyList();
		}
	}
}
