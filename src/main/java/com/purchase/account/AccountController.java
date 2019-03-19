package com.purchase.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.purchase.bean.Account;
import com.purchase.common.CommonService;

@Controller
public class AccountController {
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/getSignup")
	public String getSignupPage(Model model) {
		model.addAttribute("roles", commonService.getAccountRoles());
		return "/account/signup";
	}
	
	@RequestMapping("/signup")
	@ResponseBody
	public String signup(@Valid Account account,BindingResult bindingResult) {
		System.out.println(account);
		return "";
	}
	
	
	
	
}
