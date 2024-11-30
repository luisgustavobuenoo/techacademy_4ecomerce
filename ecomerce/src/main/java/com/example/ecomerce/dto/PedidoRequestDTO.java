package com.example.ecomerce.dto;

import java.util.List;

public class PedidoRequestDTO {
    private Integer usuarioId;       // ID do Usuário que fez o pedido
    private String status;           // Status do pedido
    private List<PagamentoRequestDTO> pagamentos; // Lista de pagamentos
    private List<ItemPedidoDTO> itens;     // Lista de itens do pedido

    // Getter e Setter para usuarioId
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    // Getter e Setter para status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter e Setter para pagamentos
    public List<PagamentoRequestDTO> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<PagamentoRequestDTO> pagamentos) {
        this.pagamentos = pagamentos;
    }

    // Getter e Setter para itens
    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
