package com.example.ecomerce.controller;

import com.example.ecomerce.dto.PedidoRequestDTO;
import com.example.ecomerce.model.Pedido;
import com.example.ecomerce.model.Usuario;
import com.example.ecomerce.repository.UsuarioRepository;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoRequestDTO dto) {
        try {

            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));


            Pedido novoPedido = new Pedido();
            novoPedido.setUsuario(usuario);
            novoPedido.setStatus(dto.getStatus());


            Pedido pedidoSalvo = repository.save(novoPedido);
            return ResponseEntity.ok(pedidoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        if (dto.getStatus().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pedido não foi encontrado"));

        pedido.setStatus(dto.getStatus());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}
