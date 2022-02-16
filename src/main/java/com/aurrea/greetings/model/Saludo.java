package com.aurrea.greetings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;

import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="saludo")
public class Saludo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="saludo_tipo", length=30, unique=true)
	private String saludo_tipo;
	@Column(name="saludo_mensaje")
	private String saludo_mensaje;
	
	public Saludo() {
		
	}
	public Saludo(Long id, String saludo_tipo, String saludo_mensaje) {

		this.id = id;
		this.saludo_tipo = saludo_tipo;
		this.saludo_mensaje = saludo_mensaje;
	}
	
	
	
	
}
