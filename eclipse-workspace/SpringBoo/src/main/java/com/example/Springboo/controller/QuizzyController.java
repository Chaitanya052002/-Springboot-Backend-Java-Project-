package com.example.Springboo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboo.Model.Question;
import com.example.Springboo.Model.QuestionWrapper;
import com.example.Springboo.Model.Response;
import com.example.Springboo.service.QuizService;

@RestController
@RequestMapping("create")
public class QuizzyController {
	
	@Autowired
	QuizService quizservice ;

	@PostMapping("bycategory")
	public ResponseEntity<String> quizcreator(@RequestParam int qno,@RequestParam String title,@RequestParam String category) {
		
		return quizservice.quizcreator(qno,  title, category);
	}
	
	@GetMapping("get/{qid}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int qid){
		return quizservice.getQuiz(qid);
		
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitans(@PathVariable int id,@RequestBody List<Response> response){
		System.out.print(response);
		return quizservice.calculate(id, response);
		
	}
}
