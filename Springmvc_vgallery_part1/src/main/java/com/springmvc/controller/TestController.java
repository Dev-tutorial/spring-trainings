package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestController {
	@RequestMapping(value="/test")
	public String test(Model model){
		model.addAttribute("test", "testing!!!");
		return "test";
	}
}
