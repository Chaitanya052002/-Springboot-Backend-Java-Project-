  package com.example.Springboo.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Springboo.Daopackage.QuestionDao;
import com.example.Springboo.Daopackage.QuizcreationDao;
import com.example.Springboo.Model.Question;
import com.example.Springboo.Model.QuestionWrapper;
import com.example.Springboo.Model.Quizset;
import com.example.Springboo.Model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizcreationDao quizcreationdao;
	@Autowired
	QuestionDao questiondao;
	

	public ResponseEntity<String> quizcreator(int qno, String title, String category) {
		
		List<Question> questions = questiondao.findRandomQuestionsbycategory(category,qno);
		
		Quizset quizset= new Quizset();
		quizset.setTitle(title);
		quizset.setQuestion(questions);
		quizcreationdao.save(quizset);
		
			return new ResponseEntity<>("Done",HttpStatus.CREATED );
		
	}


	public ResponseEntity<List<QuestionWrapper>> getQuiz(int quid) {
		// TODO Auto-generated method stub
		Optional<Quizset> quiz = quizcreationdao.findById(quid);
		List<Question> questionfromdb = quiz.get().getQuestion();
		
		
		List<QuestionWrapper> questionfruser = new ArrayList<>();
		
		for(Question q : questionfromdb) {
		QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
		questionfruser.add(qw);
		}
		
		return new ResponseEntity<>(questionfruser, HttpStatus.ACCEPTED);
	}

	

	public ResponseEntity<Integer> calculate(int id, List<Response> response) {
		// TODO Auto-generated method stub
		Quizset qz = quizcreationdao.findById(id).get();
		List<Question> listans = qz.getQuestion();
		int score =0;
		int counter = 0;
		for(int i =0; i< listans.size(); i++ ) {
			if(listans.get(i).getRightAnswer().equalsIgnoreCase(response.get(i).getResponse())){
				score++;
			}
		}
		return new ResponseEntity<>(score,HttpStatus.ACCEPTED);
	}

	
}
