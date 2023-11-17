/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DSWeb_Practica06.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.uv.DSWeb_Practica06.data.Producto;
import org.uv.DSWeb_Practica06.data.RepositoryProducto;
import org.uv.DSWeb_Practica06.data.RepositoryVenta;
import org.uv.DSWeb_Practica06.data.Venta;
import org.uv.DSWeb_Practica06.data.VentaDetalle;
import org.uv.DSWeb_Practica06.data.VentaDetalleRepository;

/**
 *
 * @author carlosart17
 */
@RestController
@RequestMapping("/api/detalles-venta")
public class VentaDetalleController {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    @Autowired
    private RepositoryVenta repositoryVenta;

    @Autowired
    private RepositoryProducto repositoryProducto;

    @PostMapping
    public ResponseEntity<VentaDetalle> crearDetalleVenta(@RequestBody VentaDetalle ventaDetalle) {
        Optional<Venta> optVenta = repositoryVenta.findById(ventaDetalle.getVenta().getIdVenta());
        if (optVenta.isPresent()) {

            ventaDetalle.setVenta(optVenta.get());

            Optional<Producto> optProducto = repositoryProducto.findById(ventaDetalle.getProducto().getIdProducto());
            if (optProducto.isPresent()) {

                ventaDetalle.setProducto(optProducto.get());

                VentaDetalle detalleRes = ventaDetalleRepository.save(ventaDetalle);
                return ResponseEntity.ok(detalleRes);
            } else {

                return ResponseEntity.notFound().build();
            }
        } else {

            return ResponseEntity.notFound().build();
        }
    }

}
