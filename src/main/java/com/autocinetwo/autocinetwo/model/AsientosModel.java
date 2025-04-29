package com.autocinetwo.autocinetwo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Asientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsientosModel {
    
    public enum EstadoAsiento {
        Disponible, Reservado, Ocupado
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asiento")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_funcion", nullable = false)
    private FuncionesModel funcion;
    
    @Column(name = "numero_asiento", nullable = false)
    private String numeroAsiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAsiento estado = EstadoAsiento.Disponible;

    @Column(nullable = false)
    private BigDecimal precio;
}
