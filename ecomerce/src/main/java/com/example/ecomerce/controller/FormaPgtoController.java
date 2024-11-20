package com.example.ecomerce.controller;


import com.example.ecomerce.dto.FormaPgtoRequestDTO;
import com.example.ecomerce.dto.UsuarioRequestDTO;
import com.example.ecomerce.model.FormaPgto;
import com.example.ecomerce.model.Usuario;
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
    public ResponseEntity<FormaPgto> save(@RequestBody FormaPgtoRequestDTO dto){
        if (dto.descricao().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        FormaPgto formaPgto = new FormaPgto();

        formaPgto.setDescricao(formaPgto.getDescricao());
        this.repository.save(formaPgto);
        return ResponseEntity.ok(formaPgto);
     }
}
