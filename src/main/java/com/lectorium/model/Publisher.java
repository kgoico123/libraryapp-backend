package com.lectorium.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="publishers")//, schema="sistemas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // para comparar objetos
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idPublisher;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 150)//, name="direccion")
	private String address;
	
	// Constructor sin argumentos
	//public Publisher() {}

	// Constructor con argumentos
	/*public Publisher(Integer idPublisher, String name) {
		this.idPublisher = idPublisher;
		this.name = name;
	}*/

	// Getters y Setters
	/*
	public Integer getIdPublisher() {
		return idPublisher;
	}

	public void setIdPublisher(Integer idPublisher) {
		this.idPublisher = idPublisher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	*/
}
