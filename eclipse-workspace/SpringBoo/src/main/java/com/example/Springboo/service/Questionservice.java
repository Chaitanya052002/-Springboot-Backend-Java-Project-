package com.example.Springboo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Springboo.Daopackage.QuestionDao;
import com.example.Springboo.Model.Question;


@Service
public class Questionservice {
	
	@Autowired
	QuestionDao questiondao;

	public ResponseEntity<List<Question>> getAllquestions() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.FOUND);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}

	public void addQuestion(Question question) {
		// TODO Auto-generated method stub
		questiondao.save(question);
	}

	
	

}
