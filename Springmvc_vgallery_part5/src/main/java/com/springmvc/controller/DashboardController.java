package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Dashboard;
import com.springmvc.model.VideoSelection;
import com.springmvc.service.VideoService;
@Controller
public class DashboardController {
	@Autowired
	private VideoService service;

	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public @ResponseBody List<VideoSelection> findAllCategories(){
		return service.findAllCategories();
	}
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getdashboard(@ModelAttribute("dashboard") Dashboard dashboard){
		return "dashboard";
	}
}
