
package com.autocinetwo.autocinetwo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Detalle_Compra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false)
    private ComprasModel compra;

    @ManyToOne
    @JoinColumn(name = "id_asiento", nullable = false)
    private AsientosModel asiento;

    @Column(nullable = false)
    private Double precio;
}