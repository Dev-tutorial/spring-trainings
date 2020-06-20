package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.model.UserDetail;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String getUserLogin(@ModelAttribute("userLogin") UserDetail user){
		System.out.println("user: "+user.getUserName());
		
		return "login";
		//return "forward:forward.html";
		//return "redirect:forward.html";
	}
	
	
	
	/*@RequestMapping(value="/forwardOrRedirect")
	public String useForwardChaining(@ModelAttribute("userLogin") UserDetail user){
		System.out.println("forwarded or redirected method. User: " +user.getUserName());
		return "login";
	}*/
}
