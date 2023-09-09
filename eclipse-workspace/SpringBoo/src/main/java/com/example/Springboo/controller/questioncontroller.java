package com.example.Springboo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboo.Model.Question;
import com.example.Springboo.service.Questionservice;

@RestController
@RequestMapping("question")
public class questioncontroller {
	
	
	@Autowired
	Questionservice questionservice; 


	@GetMapping("questions")
	public ResponseEntity<List<Question>> getAllquestions() {
		return questionservice.getAllquestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		return questionservice.getQuestionsByCategory(category);
		
	}
	
	@PostMapping("/addquestions")
	public String addQuestions(@RequestBody Question question){
		questionservice.addQuestion(question);
		return "Question added";
	}
}
