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

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
        if (dto.getNome().isEmpty() ) {
            return ResponseEntity.status(428).build();
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        // Validação e definição da data do pedido
        if (dto.getDataCriacao() == null) {
            usuario.setDataCriacao(Timestamp.valueOf(LocalDateTime.now()));
        } else {
            usuario.setDataCriacao(dto.getDataCriacao());
        }

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
