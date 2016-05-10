package com.connect_group.nashorn_react_redux.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SlideDeckController {

	private static final Logger log = Logger.getLogger(SlideDeckController.class);
	
	@RequestMapping({"/", "/slides", "/index.html"})
    public String index() {
		if(log.isInfoEnabled()) {
			log.info("SlideDeckController index() invoked");
		}
        return "index.html";
    }
}
