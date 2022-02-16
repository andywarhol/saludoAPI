package com.aurrea.greetings.rest;


import java.util.List;
import java.util.Optional;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurrea.greetings.model.Saludo;

import com.aurrea.greetings.service.SaludoService;


@RestController
@RequestMapping("/api/saludo")
public class SaludoREST {
	
	@Autowired
	private SaludoService saludoService;
	
	@GetMapping("/")
	private String saludo() {
		return "Api funcionando correctamente";
	}
	
	
	@PostMapping("/agregarSaludo")
	private Saludo agregarSaludo(@RequestBody Saludo saludo){
		
			return saludoService.agregarSaludo(saludo);
	
	}
	
	
	@GetMapping("get/{id}")
	private ResponseEntity<Optional<Saludo>> listarPorId(@PathVariable("id") Long id){
		return ResponseEntity.ok(saludoService.findById(id));
	}
	
	@GetMapping("/findByTipo/{saludo_tipo}")
	private Saludo findByTipo(@PathVariable("saludo_tipo")String saludo_tipo) {
		return saludoService.findOneTipo(saludo_tipo);
	}
	
	
	@GetMapping("/getAllSaludos")
	private ResponseEntity<List<Saludo>> listarSaludos(){
		return ResponseEntity.ok(saludoService.getAllSaludos());
	}
	
	@GetMapping("/getSaludo")
	private String getSaludo() {
		return saludoService.getSaludo();
	}
	
	@DeleteMapping("/delete")
	private ResponseEntity<List<Saludo>> eliminarSaludo(@RequestBody Saludo saludo){
		saludoService.eliminarSaludo(saludo);
		return ResponseEntity.ok().build();
	}
}
