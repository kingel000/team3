package main.project.web.question.conrtoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import main.project.web.question.service.IQuestionService;

@Controller("questionController")
@RequestMapping()
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	
	@RequestMapping(value="/question.do", method=RequestMethod.GET)
	public String questionMain(Model model, HttpSession session) {
		return null;
	}
	
	
	
	
	
}
