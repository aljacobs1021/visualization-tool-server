package com.revature.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.app.dao.CuricularDao;

import com.revature.app.exception.BadParameterException;
import com.revature.app.exception.CurriculumNotFoundException;
import com.revature.app.exception.EmptyParameterException;
import com.revature.app.exception.SkillNotFoundException;
import com.revature.app.model.Curriculum;
import com.revature.app.model.Skill;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor= @__(@Autowired))
@Getter
@Setter
@ToString
public class CuriculurService {

	
	private CuricularDao Curiculardao;

	@Transactional(rollbackOn = {SkillNotFoundException.class})
	public Curriculum  getcurriculumbyCuriculumMicroId(String curricularMicroID) throws BadParameterException, EmptyParameterException, CurriculumNotFoundException{
		List<Curriculum >curriculumList;
		
		if(curricularMicroID.trim().equals("")){
			throw new EmptyParameterException("empty Id");
		}

try {
	
	 int curricularMicroIDInt =	Integer.parseInt(curricularMicroID);
	 
	
//	 curriculum =curentSess.byNaturalId(Curriculum.class).using("IdcuriculumMicro",curricularMicroIDInt)
//             .load();
	 
	 curriculumList = Curiculardao.findAllByidcuriculummicro(curricularMicroIDInt);

	if(curriculumList.isEmpty() ) {
		throw new CurriculumNotFoundException("The curriculum with ID not found" );
		 
	}else{
		return   curriculumList.get(0) ;
	}
	
	
	
	
	
	
	
} catch (NumberFormatException e) {
	throw new BadParameterException("can not convert to int from string");
}
		
	
	}
}


