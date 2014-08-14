package com.okdevtv.mvc;

import java.util.Locale;

import okjsp.User;
import okjsp.UserDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Project : okspring
 * @FileName : RegisterController.java
 * @Date : 2014. 8. 14.
 * @Author : SKLEE
 * @Note :
 */
@Controller
public class RegisterController {

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		return "register";
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String registerFinished(Locale locale,
			@ModelAttribute("User") User user, Model model) {

		// check password and confirmPassword
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			model.addAttribute("msg", "password not matched!");
			model.addAttribute("user", user);
			return "register";
		}
		// check id duplication
		// save()
		UserDAO.save(user);
		// to finish page
//		return "registerFinished";
		return "redirect:registerFinished.do";
	}

	@RequestMapping(value = "/registerFinished.do")
	public String registerFinished(Model model) {
		return "registerFinished";
	}
}
