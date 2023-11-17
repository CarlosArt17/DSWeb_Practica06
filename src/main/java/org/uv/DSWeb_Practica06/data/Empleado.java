/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_Practica06.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author carlosart17
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleados_id_empleado_seq")
    @SequenceGenerator(name = "empleados_id_empleado_seq", sequenceName = "empleados_id_empleado_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "direccion")
    private String direccion;

    @NotNull
    @Column(name = "telefono")
    private String telefono;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
//    private List<Venta> ventas = new ArrayList<>(); // Inicializar la lista para evitar problemas de null

   
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

//    public List<Venta> getVentas() {
//        return ventas;
//    }
//
//    public void setVentas(List<Venta> ventas) {
//        this.ventas = ventas;
//    }
}
