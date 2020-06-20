package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DashboardController {

	@RequestMapping(value="/dashboard")
	public String getDashboard(Model model){
		return "dashboard";
	}
}
