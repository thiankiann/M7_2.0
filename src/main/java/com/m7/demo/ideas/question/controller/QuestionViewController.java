package com.m7.demo.ideas.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.m7.demo.ideas.category.service.CategoryService;
import com.m7.demo.ideas.question.domain.model.Question;
import com.m7.demo.ideas.question.service.AnswerService;
import com.m7.demo.ideas.question.service.QuestionService;

import java.util.UUID;

@Controller
@RequestMapping("/questions")
public class QuestionViewController {

	private final QuestionService questionsService;
	private final AnswerService answerService;
	private final CategoryService categoryService;

	public QuestionViewController(QuestionService questionsService,
	                              AnswerService answerService,
	                              CategoryService categoryService) {
		this.questionsService = questionsService;
		this.answerService = answerService;
		this.categoryService = categoryService;
	}

	@GetMapping
	public String indexView(Model model){
		model.addAttribute("questions", questionsService.getQuestions());
		model.addAttribute("categories", categoryService.getCategories());

		return "question/index";
	}

	@GetMapping("{id}")
	public String singleView(Model model, @PathVariable UUID id){
		model.addAttribute("question", questionsService.getQuestion(id));
		model.addAttribute("answers", answerService.getAnswers(id));
		model.addAttribute("categories", categoryService.getCategories());

		return "question/single";
	}

	@GetMapping("add")
	public String addView(Model model){
		model.addAttribute("question", new Question());

		return "question/add";
	}

	@PostMapping
	public String add(Question question){
		questionsService.createQuestion(question);

		return "redirect:/questions";
	}
}
