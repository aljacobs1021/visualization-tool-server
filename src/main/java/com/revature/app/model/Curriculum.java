package com.revature.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;




import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;























@Entity
@Table
@AllArgsConstructor @EqualsAndHashCode @Getter @Setter @ToString @NoArgsConstructor
public class Curriculum{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int curriculums;

	
	@Column(nullable=false, unique=true)	
    private int  idcuriculummicro;
	

	
//
//	@ManyToMany
//	@JoinColumn( nullable = false)
//	private  List<Skill> skills;
	//dont joint the table
	//need to add curiculaer id colum in skill tables
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Curricula_Skills", joinColumns = { @JoinColumn(name = "curriculums") }, inverseJoinColumns = {
	@JoinColumn(name = "skill_id", nullable = true),  })	
	private List<Skill> skillList;



	public Curriculum(int  idcuriculummicro, List<Skill> skillList) {
		super();
	this.idcuriculummicro = idcuriculummicro;
		
		if( skillList == null) {
			this.skillList = null;
			
		
		}else {
			
			this.skillList = skillList;
		}
		
	}


	
	
	

	
	
	
//	public Curriculum(CurriculumDto dto) {
//		this.curriculumName = dto.getName();
//		this.skillList = dto.getSkillList();
//	}
}
