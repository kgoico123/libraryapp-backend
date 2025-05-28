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
@Table(name="computadora")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Computadora {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idComptadora;
	
	@Column(nullable = false, length = 100)
	private String marca;
	
	@Column(nullable = false, length = 150)
	private String modelo;

    @Column(nullable = false, length = 150)
	private String procesador;

    @Column(nullable = false, length = 150)
	private int ramGB;
}
