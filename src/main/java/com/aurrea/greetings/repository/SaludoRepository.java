package com.aurrea.greetings.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aurrea.greetings.model.Saludo;


public interface SaludoRepository extends JpaRepository<Saludo, Long>{


	Saludo getByTipo(String tipo);
	
	

}
