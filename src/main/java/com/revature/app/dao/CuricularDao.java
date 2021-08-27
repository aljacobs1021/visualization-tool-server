package com.revature.app.dao;




import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



import com.revature.app.model.Curriculum;




public interface CuricularDao extends JpaRepository< Curriculum , Integer>{



	
	public List<Curriculum > findAll();
	
 public List<Curriculum> findAllByidcuriculummicro(int cur);
}



