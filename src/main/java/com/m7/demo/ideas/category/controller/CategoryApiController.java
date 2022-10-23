package com.m7.demo.ideas.category.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.m7.demo.ideas.category.domain.model.Category;
import com.m7.demo.ideas.category.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryApiController {

	private final CategoryService categoryService;

	public CategoryApiController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping
	List<Category> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping("{id}")
	Category getCategory(@PathVariable UUID id) {
		return categoryService.getCategory(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	Category updateCategory(@PathVariable UUID id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void deleteCategory(@PathVariable UUID id) {
		categoryService.deleteCategory(id);
	}
}
