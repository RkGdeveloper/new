package com.cg.emplm.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/index")
	public String showIndex(HttpServletRequest req,Model m){
		
		
		m.addAttribute("appTitle",req.getServletContext().getServletContextName());
		return "index";
		
	}
	
}
