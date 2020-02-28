package main.project.admin;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("adminController")
@RequestMapping(value="/admin")
public class adminController {
	//* package  -> "main.project.admin
	//localhost:8080/web/admin/*.mdo
	@RequestMapping({"/","/admin.mdo"})
	public String home(Locale locale, Model model) {
		System.out.println("ADMIN MAIN MDO 호출");
		return "admin/adminMain";
	}
	
	@RequestMapping(value = "/adminDetail.mdo" , method = RequestMethod.POST )
	public String adminDetail() {
		System.out.println("ADMIN DETAIL MDO POST 호출");
		return "admin/adminDetail.page2";
	}

	
	
}
