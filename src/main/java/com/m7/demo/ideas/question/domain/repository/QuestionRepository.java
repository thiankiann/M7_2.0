package com.m7.demo.ideas.question.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.m7.demo.ideas.question.domain.model.Question;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

	List<Question> findAllByCategoryId(UUID id);
}
