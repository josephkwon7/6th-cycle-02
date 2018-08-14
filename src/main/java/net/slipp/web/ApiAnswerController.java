package net.slipp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.slipp.domain.Answer;
import net.slipp.domain.AnswerRepository;
import net.slipp.domain.Question;
import net.slipp.domain.User;

@RestController
@RequestMapping("/api/questions/{questionId}/answers")
public class ApiAnswerController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@PostMapping("")
	public Answer cretate(@PathVariable Long questionId, String content, HttpSession session) {
		if (!HttpSessionUtils.isLoginUser(session)) {
			return null;
		}
		User loginUser = HttpSessionUtils.getUserFromSession(session);
		Question question = questionRepository.getOne(questionId);
		Answer answer = new Answer(loginUser, question, content);
		System.out.println(answer);
		return answerRepository.save(answer);
	}
	
}
