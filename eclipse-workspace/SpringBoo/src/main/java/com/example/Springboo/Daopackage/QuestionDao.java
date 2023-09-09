package com.example.Springboo.Daopackage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Springboo.Model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
	
	 List<Question> findByCategory(String category);

	
	 @Query(value = "select * from question q where q.category = :category order by RANDOM() LIMIT :qno", nativeQuery = true)
	 List<Question> findRandomQuestionsbycategory(String category, int qno);


}
