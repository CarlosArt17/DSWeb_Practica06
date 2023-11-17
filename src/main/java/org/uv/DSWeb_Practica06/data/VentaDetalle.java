/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_Practica06.data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author carlosart17
 */
@Entity
@Table(name = "venta_detalle")
public class VentaDetalle implements Serializable {

    @Id
    @GeneratedValue(generator = "venta_detalle_iddetalleventa_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "venta_detalle_iddetalleventa_seq", sequenceName = "venta_detalle_iddetalleventa_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "iddetalleventa")
    private Long idDetalleVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenta", referencedColumnName = "idventa") // Ajustado para que coincida con el nombre en la entidad Venta
    private Venta venta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", referencedColumnName = "id_producto")
    private Producto producto;

    @Column(name = "idproducto")
    private Long idProducto;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    // Getters y setters
    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
