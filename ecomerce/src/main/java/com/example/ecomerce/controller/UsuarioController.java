package com.example.ecomerce.controller;


import com.example.ecomerce.dto.UsuarioRequestDTO;
import com.example.ecomerce.model.Usuario;
import com.example.ecomerce.repository.PedidoRepository;
import com.example.ecomerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")


public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("usuario não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Usuario usuario = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }




}
