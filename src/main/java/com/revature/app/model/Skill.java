package com.revature.app.model;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.app.dto.SkillDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Skills")
@AllArgsConstructor @EqualsAndHashCode @Getter @Setter @ToString @NoArgsConstructor
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private int skillId;
	
	@Column(name = "skill_name")
	private String skillName;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="skillList")	
	@JsonIgnore
	private List<Curriculum> curriculumList = new ArrayList<Curriculum>();
	
	
	
	public Skill(SkillDTO skillDTO) {
		this.skillName = skillDTO.getName();
		
		
		if(skillDTO.getCategory().getCategoryId()!= 0) {
			this.category = skillDTO.getCategory();
		}else {
				this.category = null;
		}
		
//		if(skillDTO.getCurriculumListl() ==null) {
//			this.curriculumList = null;
//		}else {
//			this.curriculumList = skillDTO.getCurriculumListl();			
//		}
//	
	}
	
	public void updateFromDTO(SkillDTO skillDTO) {
		this.skillName = skillDTO.getName();
		if(skillDTO.getCategory()!=null) {
			this.category =skillDTO.getCategory();;
		}else {
				this.category = null;
		}
		
//		if(skillDTO.getCurriculumListl() !=null) {
//			this.curriculumList = skillDTO.getCurriculumListl();
//		}
	}
	
}

