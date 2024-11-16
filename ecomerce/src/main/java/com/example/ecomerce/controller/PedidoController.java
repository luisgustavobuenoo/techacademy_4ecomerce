package com.example.ecomerce.controller;

import com.example.ecomerce.dto.PedidoRequestDTO;
import com.example.ecomerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ecomerce.repository.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping ("/api/pedidos")


public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = this.repository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pedido não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Pedido pedido = new Pedido();
        pedido.setStatus(dto.nome());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}
