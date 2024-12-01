package com.example.ecomerce.controller;

import com.example.ecomerce.dto.PedidoRequestDTO;
import com.example.ecomerce.model.*;
import com.example.ecomerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FormaPgtoRepository formaPgtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = this.repository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = new Pedido();


        pedido.setUsuario(usuarioRepository.findById(pedidoRequestDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
        pedido.setStatus(pedidoRequestDTO.getStatus());


        Pedido pedidoSalvo = repository.save(pedido);


        List<ItemPedido> itensPedido = pedidoRequestDTO.getItens().stream().map(itemPedidoDTO -> {
            ItemPedido itemPedido = new ItemPedido();


            ItemPedidoPK itemPedidoPK = new ItemPedidoPK();
            itemPedidoPK.setPedidoId(pedidoSalvo.getPedidoId());
            itemPedidoPK.setItemId(itemPedidoDTO.getItemId());

            itemPedido.setId(itemPedidoPK);


            Item item = itemRepository.findById(itemPedidoDTO.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item não encontrado"));
            itemPedido.setItem(item);
            itemPedido.setPedido(pedidoSalvo);


            BigDecimal quantidade = itemPedidoDTO.getQuantidade();
            itemPedido.setQuantidade(quantidade);
            BigDecimal precoTotal = item.getPreco().multiply(quantidade);
            itemPedido.setPrecoTotal(precoTotal.setScale(2, RoundingMode.HALF_UP));

            return itemPedido;
        }).toList();


        itemPedidoRepository.saveAll(itensPedido);


        List<Pagamento> pagamentos = pedidoRequestDTO.getPagamentos().stream().map(pagamentoDTO -> {
            Pagamento pagamento = new Pagamento();


            PagamentoPK pagamentoPK = new PagamentoPK();
            pagamentoPK.setPedidoId(pedidoSalvo.getPedidoId());
            pagamentoPK.setFormaPgtoId(pagamentoDTO.getFormaPgtoId());
            pagamento.setId(pagamentoPK);


            FormaPgto formaPgto = formaPgtoRepository.findById(pagamentoDTO.getFormaPgtoId())
                    .orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));
            pagamento.setFormaPgto(formaPgto);
            pagamento.setPedido(pedidoSalvo);

            return pagamento;
        }).toList();


        pagamentoRepository.saveAll(pagamentos);


        pedidoSalvo.setItens(itensPedido);
        pedidoSalvo.setPagamentos(pagamentos);


        return ResponseEntity.ok(pedidoSalvo);
    }


}
