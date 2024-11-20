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
            // Busca o usuário pelo ID informado no DTO
            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

            // Cria uma nova instância de Pedido
            Pedido novoPedido = new Pedido();
            novoPedido.setUsuario(usuario);  // Agora você está associando o objeto Usuario
            novoPedido.setStatus(dto.getStatus());

            // Salva o pedido no banco de dados
            Pedido pedidoSalvo = repository.save(novoPedido);
            return ResponseEntity.ok(pedidoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
