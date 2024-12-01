package com.example.ecomerce.dto;

import java.util.List;

public class PedidoRequestDTO {
    private Integer usuarioId;
    private String status;
    private List<PagamentoRequestDTO> pagamentos;
    private List<ItemPedidoDTO> itens;


    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<PagamentoRequestDTO> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<PagamentoRequestDTO> pagamentos) {
        this.pagamentos = pagamentos;
    }


    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
