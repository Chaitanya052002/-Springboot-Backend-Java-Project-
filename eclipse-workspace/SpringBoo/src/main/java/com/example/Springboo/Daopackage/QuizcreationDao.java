package com.example.Springboo.Daopackage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Springboo.Model.Question;
import com.example.Springboo.Model.Quizset;

@Repository
public interface QuizcreationDao extends JpaRepository< Quizset , Integer>{
	
	

}
