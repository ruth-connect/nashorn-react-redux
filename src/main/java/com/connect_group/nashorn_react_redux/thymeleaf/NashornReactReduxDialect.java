package com.connect_group.nashorn_react_redux.thymeleaf;

import org.thymeleaf.dialect.AbstractDialect;

public class NashornReactReduxDialect extends AbstractDialect {

	@Override
	public String getPrefix() {
		return "demo";
	}
	
	@Override
	public boolean isLenient() {
		return false;
	}
}
