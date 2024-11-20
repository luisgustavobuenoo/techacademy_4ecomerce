package com.example.ecomerce.dto;

import com.example.ecomerce.model.Usuario;

public class PedidoRequestDTO {
    private Integer usuarioId;  // ID do usuário que fez o pedido
    private String status;      // Status do pedido

    // Getters e Setters


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
}
