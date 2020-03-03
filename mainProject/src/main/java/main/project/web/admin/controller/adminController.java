package main.project.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("adminController")
@RequestMapping(value="/admin")
public class adminController {
	
	
	@RequestMapping(value="/admin.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String chat (Model model){
		return "admin/admin";
	}
}
