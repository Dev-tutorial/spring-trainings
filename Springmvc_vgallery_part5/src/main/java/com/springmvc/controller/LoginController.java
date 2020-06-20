package com.springmvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.model.UserDetail;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getUserLogin(@ModelAttribute("userLogin") UserDetail user){
		user.setUserId(null);
		user.setPassword(null);
		System.out.println("user: "+user.getUserName());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String userLoggedin(@Valid@ModelAttribute("userLogin") UserDetail user, BindingResult result, Model model){
		if(result.hasErrors()){
			return "login";
		}
		model.addAttribute("user", user);
		return "redirect:dashboard.html";
	}
}
