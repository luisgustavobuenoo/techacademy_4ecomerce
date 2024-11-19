package com.example.ecomerce.controller;


import com.example.ecomerce.model.FormaPgto;
import com.example.ecomerce.repository.FormaPgtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formaPgto")
public class FormaPgtoController {

    @Autowired
    private FormaPgtoRepository repository;

    @GetMapping
    public ResponseEntity<List<FormaPgto>> achaTodoPagamento() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public FormaPgto salvaOPagemento(@RequestBody FormaPgto formaPgtoRequest) {
        FormaPgto formaPgto = new FormaPgto();
        formaPgto.setDescricao(formaPgtoRequest.getDescricao());

        this.repository.save(formaPgto);
        return formaPgto;
     }
}
