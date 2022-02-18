package com.aurrea.greetings.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurrea.greetings.model.Saludo;
import com.aurrea.greetings.repository.SaludoRepository;


@Service
public class SaludoService {
	@Autowired
	private SaludoRepository saludoRepository;
	private Saludo saludo;
	
	public Saludo agregarSaludo(Saludo saludo) {
	
		return saludoRepository.save(saludo);
	
	}
	
	public List<Saludo> getAllSaludos(){
		return saludoRepository.findAll();
	}
	
	public void eliminarSaludo(Saludo saludo) {
		saludoRepository.delete(saludo);
	}
	
	public Optional<Saludo> findById(Long id){
		return saludoRepository.findById(id);
	}
	
	public Saludo findOneTipo(String tipo){
		return saludoRepository.getByTipo(tipo);
	}
	
	public String getSaludo() {
		LocalTime time = LocalTime.now();
		
		Integer hour = time.getHour();
	
		if(hour >= 5 && hour < 12) {
			String mensaje = this.findOneTipo("manana").getSaludo_mensaje();
			return mensaje;
		} else if (hour >= 12 && hour < 18) {
			String mensaje = this.findOneTipo("tarde").getSaludo_mensaje();
			return mensaje;
		} else if (hour >= 18 && hour <=24){
			String mensaje = this.findOneTipo("noche").getSaludo_mensaje();
			return mensaje;
		} else if (hour >= 1 && hour < 5) {
			String mensaje = this.findOneTipo("noche").getSaludo_mensaje();
			return mensaje;
		}
		return null;
		
	}
	
	public String getLocalTime() {

		LocalTime time = LocalTime.now();
		
		Integer hour = time.getHour();
		return hour.toString();
	}

}
