package com.connect_group.nashorn_react_redux.controller;

import com.connect_group.nashorn_react_redux.model.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReactController {

    private static final Film[] FILM_LIST = {
        new Film("Episode IV - A New Hope", 1977),
        new Film("Episode V - The Empire Strikes Back", 1980),
        new Film("Episode VI - Return Of The Jedi", 1983)
    };

    @RequestMapping(value = "/react")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("requestPath", request.getRequestURI());
        model.addAttribute("filmList", FILM_LIST);
        return "react.ejs";
    }
}
