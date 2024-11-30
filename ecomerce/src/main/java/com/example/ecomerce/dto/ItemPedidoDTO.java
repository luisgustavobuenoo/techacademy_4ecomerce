package com.example.ecomerce.dto;

import java.math.BigDecimal;

public class ItemPedidoDTO {
    private Integer itemId;  // Este é o ID do item
    private BigDecimal quantidade;
    private BigDecimal precoTotal;

    // Getters e Setters
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }
}
