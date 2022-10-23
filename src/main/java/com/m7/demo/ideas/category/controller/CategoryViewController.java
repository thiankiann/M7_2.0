package com.m7.demo.ideas.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.m7.demo.ideas.category.domain.model.Category;
import com.m7.demo.ideas.category.service.CategoryService;
import com.m7.demo.ideas.question.domain.model.Question;
import com.m7.demo.ideas.question.service.QuestionService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryViewController {

	private final CategoryService categoryService;
	private final QuestionService questionService;

	public CategoryViewController(CategoryService categoryService, QuestionService questionService) {
		this.categoryService = categoryService;
		this.questionService = questionService;
	}

	@GetMapping("{id}")
	public String singleView(@PathVariable UUID id, Model model){
		Category category = categoryService.getCategory(id);
		List<Question> questions = questionService.findAllByCategoryId(id);

		model.addAttribute("category", category);
		model.addAttribute("questions", questions);

		return "category/single";
	}
}
