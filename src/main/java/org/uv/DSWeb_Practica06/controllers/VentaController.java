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
import org.uv.DSWeb_Practica06.data.RepositoryVenta;
import org.uv.DSWeb_Practica06.data.Venta;
import org.uv.DSWeb_Practica06.data.VentaDetalleRepository;

/**
 *
 * @author carlosart17
 */
@RestController
@RequestMapping("/api/venta")
public class VentaController {

    @Autowired
    private RepositoryVenta repositoryVenta;

    @GetMapping("/msg")
    public String getHelloMessage() {
        return "Hola mundo";
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return repositoryVenta.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        Optional<Venta> optVenta = repositoryVenta.findById(id);

        return optVenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        Venta ventaRes = repositoryVenta.save(venta);
        return ResponseEntity.ok(ventaRes);
    }

 

}

