package com.lectorium.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ComputadoraDTO {
    private Integer idComptadora;
    private String marca;
    private String modelo;
    private String procesador;
    private int ramGB;
}
