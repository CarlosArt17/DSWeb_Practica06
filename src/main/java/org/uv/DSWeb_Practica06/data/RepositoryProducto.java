/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWeb_Practica06.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carlosart17
 */
public interface RepositoryProducto extends JpaRepository<Producto, Long> {
    
}
