package com.javatpoint.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.beans.UserVO;

import com.javatpoint.service.UserServiceImpl;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired    
    UserServiceImpl service;//will inject dao from XML file  
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(String t, Model model) {
		return "login";
	}
	
	@RequestMapping(value="/loginOk", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo) {
		String returnURL = "";
		if(session.getAttribute("login")!=null) {
			session.removeAttribute("login");
		}
	
		UserVO loginvo = service.getUser(vo);
		if(loginvo != null) {
			System.out.println("login success!");
			session.setAttribute("login",loginvo);
			returnURL = "redirect:/";
		}else {
			System.out.println("login fail!");
			returnURL = "redirect:/login/login";
		}
		return returnURL;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
}


