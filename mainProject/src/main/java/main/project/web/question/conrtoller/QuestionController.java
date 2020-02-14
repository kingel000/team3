package main.project.web.question.conrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.project.web.question.service.IQuestionService;

@Controller("questionController")
@RequestMapping()
public class QuestionController {
	
	@Autowired
	private IQuestionService QuestionService;
	
	
}
