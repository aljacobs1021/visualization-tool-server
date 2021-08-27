package com.revature.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.app.exception.BadParameterException;
import com.revature.app.exception.CurriculumNotFoundException;
import com.revature.app.exception.EmptyParameterException;
import com.revature.app.model.Curriculum;
import com.revature.app.model.Skill;
import com.revature.app.service.CuriculurService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class CurricularController {
	
	
	private  CuriculurService curriserv;
	 
	
	//for curricular micro service
	@GetMapping("/{id}")
	public ResponseEntity<List<Skill>> skillList(@PathVariable("id")String id){
	Curriculum cur = null;  

	List<Skill> skillList =  new ArrayList<Skill>();;
		
		
		try {
			
		
			
		cur =	curriserv.getcurriculumbyCuriculumMicroId(id);
		if(cur !=null) {
			
			skillList  = cur.getSkillList();
		}
			
		return new ResponseEntity<List<Skill>>(skillList, HttpStatus.OK);
		} catch (BadParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (EmptyParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (CurriculumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<Skill>>(skillList, HttpStatus.CONFLICT);
		}
	
	}
	


}


