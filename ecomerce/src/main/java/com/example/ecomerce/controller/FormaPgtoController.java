package com.example.ecomerce.controller;

import com.example.ecomerce.model.FormaPgto;
import com.example.ecomerce.repository.FormaPgtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formas-pgto")
public class FormaPgtoController {

    @Autowired
    private FormaPgtoRepository formaPgtoRepository;

    // Endpoint para listar todas as formas de pagamento
    @GetMapping
    public ResponseEntity<List<FormaPgto>> listarFormasDePagamento() {
        List<FormaPgto> formasPgto = formaPgtoRepository.findAll();
        return ResponseEntity.ok(formasPgto);
    }

    // Endpoint para criar uma nova forma de pagamento
    @PostMapping
    public ResponseEntity<FormaPgto> criarFormaDePagamento(@RequestBody FormaPgto formaPgto) {
        FormaPgto novaFormaPgto = formaPgtoRepository.save(formaPgto);
        return ResponseEntity.ok(novaFormaPgto);
    }

    // Endpoint para buscar uma forma de pagamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<FormaPgto> buscarFormaDePagamentoPorId(@PathVariable Integer id) {
        FormaPgto formaPgto = formaPgtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));
        return ResponseEntity.ok(formaPgto);
    }
}
