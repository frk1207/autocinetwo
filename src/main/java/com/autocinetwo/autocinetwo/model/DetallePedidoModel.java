
package com.autocinetwo.autocinetwo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Integer idDetallePedido;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoDulceriaModel pedidoDulceria;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private DulceriaModel dulceria;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    // Getters y Setters
    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public PedidoDulceriaModel getPedidoDulceria() {
        return pedidoDulceria;
    }

    public void setPedidoDulceria(PedidoDulceriaModel pedidoDulceria) {
        this.pedidoDulceria = pedidoDulceria;
    }

    public DulceriaModel getDulceria() {
        return dulceria;
    }

    public void setDulceria(DulceriaModel dulceria) {
        this.dulceria = dulceria;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
